package chapter6;

import annotation.NotRecommend;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@NotRecommend
public class ThreadTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(9999);
        while (true) {
            Socket accept = socket.accept();
            new Thread((() -> {/**do something*/})).start();
        }
    }
}
