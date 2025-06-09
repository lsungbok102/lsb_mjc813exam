package com.mjc813.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp {
    private ServerSocket ss;
    private Socket sck;
    private BufferedWriter writer;
    private boolean running = true;

    public ServerApp(int port) throws IOException {
        this.ss = new ServerSocket(port);
    }

    public void init() {
        try {
            System.out.println("Waiting for client...");
            sck = ss.accept();
            System.out.println("Connected: " + sck.getRemoteSocketAddress());

            // 수신 스레드
            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(sck.getInputStream()))) {
                    String line;
                    while (running && (line = reader.readLine()) != null) {
                        System.out.println("From client: " + line);
                        if (line.equals("exit!@#$app")) {
                            System.out.println("Client requested exit.");
                            running = false;
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Read error: " + e.getMessage());
                }
            }).start();

            // 송신 루프 (키보드 입력)
            writer = new BufferedWriter(new OutputStreamWriter(sck.getOutputStream()));
            Scanner scanner = new Scanner(System.in);
            while (running) {
                System.out.print("보낼 메시지: ");
                String input = scanner.nextLine();
                if (input.equals("quit")) {
                    send("exit!@#$app");
                    running = false;
                } else {
                    send(input);
                }
            }

            close();
            scanner.close();
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    public void send(String msg) throws IOException {
        writer.write(msg + "\n");
        writer.flush();
    }

    public void close() throws IOException {
        if (writer != null) writer.close();
        if (sck != null) sck.close();
        if (ss != null) ss.close();
        System.out.println("Server closed.");
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Server start");
        ServerApp sa = new ServerApp(44567);
        sa.init();
    }
}
