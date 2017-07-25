package qianle.TCPDemo2;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class MultiThreadServer implements Runnable{

    private Socket socket;

    MultiThreadServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            File upload = new File("/Users/qianle/Desktop/demo");
            if (!upload.exists())
                upload.mkdir();

            String fileName = upload + "/" + Long.toString(System.currentTimeMillis()) + new Random().nextInt(666666) + ".jpg";
            System.out.println(fileName);
            FileOutputStream fos = new FileOutputStream(fileName);
            byte[] data = new byte[1024];
            int len = 0;
            while ((len = in.read(data)) != -1) {
                fos.write(data, 0, len);
            }

            OutputStream out = socket.getOutputStream();
            out.write("upload success".getBytes());
            fos.close();
            socket.close();
        } catch (IOException e) {

        }

    }
}
