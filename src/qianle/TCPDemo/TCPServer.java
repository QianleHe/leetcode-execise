package qianle.TCPDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream in = socket.getInputStream(); //具有线程等待效果
        byte[] data = new byte[1024];
        int len = in.read(data);
        System.out.println(new String(data, 0, len));

        OutputStream out = socket.getOutputStream();
        out.write("received".getBytes());

        socket.close();
        serverSocket.close();
    }
}
