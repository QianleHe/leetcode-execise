package qianle.UDPdemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpSend {

    public static void main(String[] args) throws IOException{
        InetAddress inet = InetAddress.getByName("10.0.124.28");
        DatagramSocket ds = new DatagramSocket();
        while (true) {
            Scanner sc = new Scanner(System.in);
            String message = sc.nextLine();
            byte[] bytes = message.getBytes();
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, inet, 6000);

            ds.send(dp);
        }

//        ds.close();
    }
}
