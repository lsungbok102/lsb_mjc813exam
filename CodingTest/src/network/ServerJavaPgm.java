package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerJavaPgm {
    private ServerSocket serverSocket;

    public Socket accept(int port) throws IOException {
        this.serverSocket = new ServerSocket();
        this.serverSocket.bind(new InetSocketAddress(port));
        Socket socket = this.serverSocket.accept();
        return socket;
    }

    public void read(Socket socket) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
        String str = br.readLine();
        System.out.printf("From Client : %s\n", str);
        br.close();
        socket.close();
    }

    public void close() throws IOException {
        this.serverSocket.close();
    }

    public static void main(String[] args) {
        System.out.println("ServerJavaPgm start");

        ServerJavaPgm sjp = new ServerJavaPgm();
        try {
            Socket sck = sjp.accept(59999);
            sjp.read(sck);
            sjp.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
