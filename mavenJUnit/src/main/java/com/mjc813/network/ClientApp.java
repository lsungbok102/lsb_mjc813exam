package com.mjc813.network;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    private Socket sck;
    private BufferedWriter writer;
    private boolean running = true;

    public ClientApp() {
        this.sck = new Socket();
    }

    public void init(String ipAddr, int port) throws IOException {
        sck.connect(new InetSocketAddress(ipAddr, port));
        writer = new BufferedWriter(new OutputStreamWriter(sck.getOutputStream()));

        // 수신 스레드
        new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(sck.getInputStream()))) {
                String line;
                while (running && (line = reader.readLine()) != null) {
                    System.out.println("From server: " + line);
                    if (line.equals("exit!@#$app")) {
                        System.out.println("Exit signal received. Closing client.");
                        running = false;
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println("Read error: " + e.getMessage());
            }
        }).start();

        // 송신 루프
        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.print("보낼 메시지: ");
            String input = scanner.nextLine();
            send(input);
        }

        close();
        scanner.close();
    }

    public void send(String msg) throws IOException {
        writer.write(msg + "\n");
        writer.flush();
    }

    public void close() throws IOException {
        if (writer != null) writer.close();
        if (sck != null) sck.close();
        System.out.println("Client closed.");
    }

    public static void main(String[] args) {
        System.out.println("Client start");
        try {
            ClientApp ca = new ClientApp();
            ca.init("172.20.10.2", 44567); // 여기 서버 IP 입력!
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
