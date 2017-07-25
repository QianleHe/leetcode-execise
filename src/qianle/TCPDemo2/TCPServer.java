package qianle.TCPDemo2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8888);
        while(true) {
            Socket socket = serverSocket.accept();
            new Thread(new MultiThreadServer(socket)).start();
        }
//        Socket socket = serverSocket.accept();
//
//        InputStream in = socket.getInputStream();
//        File upload = new File("/Users/qianle/Desktop/demo");
//        if (!upload.exists())
//            upload.mkdir();
//
//        String fileName = upload + "/" + Long.toString(System.currentTimeMillis()) + new Random().nextInt(666666) + ".jpg";
//        System.out.println(fileName);
//        FileOutputStream fos = new FileOutputStream(fileName);
//        byte[] data = new byte[1024];
//        int len = 0;
//        while ((len = in.read(data)) != -1) {
//            fos.write(data, 0, len);
//        }
//
//        OutputStream out = socket.getOutputStream();
//        out.write("upload success".getBytes());
//        fos.close();
//        socket.close();
//        serverSocket.close();
    }
}
