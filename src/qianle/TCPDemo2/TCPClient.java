package qianle.TCPDemo2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("10.0.124.28",8888);
        OutputStream out = socket.getOutputStream();

        FileInputStream fis = new FileInputStream("/Users/qianle/Pictures/stuffs/head2.jpeg");
        int len = 0;
        byte[] data = new byte[1024];
        while ((len = fis.read(data)) != -1) {
            out.write(data, 0, len);
        }
        socket.shutdownOutput();
        InputStream in = socket.getInputStream();
        len = in.read(data);
        System.out.println(new String(data, 0, len));

        fis.close();
        socket.close();
    }
}
