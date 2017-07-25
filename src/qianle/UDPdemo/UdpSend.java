package qianle.UDPdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSend {

    public static void main(String[] args) throws IOException{
        byte[] bytes = "Hellomydear".getBytes();
        InetAddress inet = InetAddress.getByName("10.0.124.28");
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, inet, 6000);
        DatagramSocket ds = new DatagramSocket();
        ds.send(dp);
        ds.close();
    }
}
