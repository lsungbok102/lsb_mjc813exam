package network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientJavaPgm {
    private Socket socket;

    public void connect( String ip, int port ) throws IOException {
        socket = new Socket();
        socket.connect(new InetSocketAddress(ip, port));
    }

    public void send( String str ) throws IOException {
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(this.socket.getOutputStream())
        );
        bw.write(str);
        bw.flush();
        bw.close();
    }

    public void close() throws IOException {
        this.socket.close();
    }

    public static void main(String[] args) {
        System.out.println("ClientJavaPgm start");
        ClientJavaPgm cjp = new ClientJavaPgm();
        try {
            cjp.connect("127.0.0.1", 59999);
            cjp.send(String.format("Client[%s] %s"
                    , InetAddress.getLocalHost()
                    , "잘 접속했다."));
            cjp.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
