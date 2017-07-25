package qianle;

import java.net.InetAddress;

public class InetAddressDemo {

    public static void main(String[] args) throws Exception{
        function();
        //getName();
    }


    public static void function() throws Exception{
        InetAddress inet = InetAddress.getLocalHost();
        System.out.println(inet);
        String hostAddr = inet.getHostAddress();
        String hostName = inet.getHostName();
    }

    public static void getName() throws Exception {
        InetAddress inet = InetAddress.getByName("www.google.com");
        System.out.println(inet);
    }
}
