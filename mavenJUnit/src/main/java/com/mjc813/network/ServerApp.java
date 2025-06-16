package com.mjc813.network;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ServerApp {
    private ServerSocket serverSocket;
    private final Set<ClientHandler> clients = ConcurrentHashMap.newKeySet(); // 쓰레드 안전한 클라이언트 목록
    private boolean running = true;

    public ServerApp(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() {
        System.out.println("Server started. Waiting for clients...");

        // 클라이언트 연결 수락용 스레드
        new Thread(() -> {
            while (running) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    ClientHandler handler = new ClientHandler(clientSocket);
                    clients.add(handler);
                    new Thread(handler).start(); // 클라이언트별 수신 쓰레드
                    System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());
                } catch (IOException e) {
                    if (running)
                        System.err.println("Accept error: " + e.getMessage());
                }
            }
        }).start();

        // 서버 콘솔 입력으로 종료 제어
        try (Scanner scanner = new Scanner(System.in)) {
            while (running) {
                System.out.print("서버 명령어 입력 (quit 입력시 종료): ");
                String cmd = scanner.nextLine();
                if ("quit".equalsIgnoreCase(cmd)) {
                    shutdown();
                }
            }
        }
    }

    public void broadcast(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
        System.out.println("Client disconnected: " + client.socket.getRemoteSocketAddress());
    }

    public void shutdown() {
        running = false;
        try {
            for (ClientHandler client : clients) {
                client.sendMessage("exit!@#$app");
                client.close();
            }
            serverSocket.close();
            System.out.println("Server shutdown.");
        } catch (IOException e) {
            System.err.println("Shutdown error: " + e.getMessage());
        }
    }

    class ClientHandler implements Runnable {
        private final Socket socket;
        private BufferedReader reader;
        private BufferedWriter writer;

        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }

        public void run() {
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    if ("exit!@#$app".equals(line)) {
                        break;
                    }
                    System.out.println("From " + socket.getRemoteSocketAddress() + ": " + line);
                    broadcast("From " + socket.getRemoteSocketAddress() + ": " + line, this);
                }
            } catch (IOException e) {
                System.err.println("Client error: " + e.getMessage());
            } finally {
                close();
                removeClient(this);
            }
        }

        public void sendMessage(String msg) {
            try {
                writer.write(msg + "\n");
                writer.flush();
            } catch (IOException e) {
                System.err.println("Send error: " + e.getMessage());
            }
        }

        public void close() {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Close error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerApp server = new ServerApp(44567);
        server.start();
    }
}
