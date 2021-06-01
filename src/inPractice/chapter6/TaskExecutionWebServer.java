package inPractice.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionWebServer {
    private static final int THREAD_NUM = 100;
    private static final Executor EXECUTOR = Executors.newFixedThreadPool(THREAD_NUM);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(9999);

        while (true) {
            Socket accept = socket.accept();
            EXECUTOR.execute(() -> {/***do something**/});
        }
    }
}
