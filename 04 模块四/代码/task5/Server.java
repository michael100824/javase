package task5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server implements ClientMessageCallback {

    private ClientMessageCallback clientMessageCallback = this;
    private List<ServerThread> users = new ArrayList<>();
    private ServerSocket ss;
    private ExecutorService threads = Executors.newFixedThreadPool(10);



    public void startService() {
        try {
            ss = new ServerSocket(9999);
            System.out.println("聊天室已启动...");
            while(true) {
                Socket s = ss.accept();
                ServerThread userThread = new ServerThread(s,this);
                users.add(userThread);
                userThread.start();
                System.out.println("当前在线人数：" + users.size());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToClient(String message) {
        for (ServerThread user : users) {
            user.sendMessage(message);
        }
    }

    @Override
    public void receiveMessage(String message) {
        sendMessageToClient(message);
    }

}

interface ClientMessageCallback {
    void receiveMessage(String message);
}
