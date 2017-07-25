package qianle.UDPdemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {
    public static void main(String[] args) throws IOException{
        DatagramSocket ds = new DatagramSocket(6000);
        byte[] data = new byte[1024];
        while (true) {
            DatagramPacket dp = new DatagramPacket(data, data.length);
            ds.receive(dp);
            String address = dp.getAddress().getHostAddress();
            int port = dp.getPort();
            int length = dp.getLength();
            System.out.println(new String(data,0,length) + " " + address +  "  " + port);
        }
    }
}
