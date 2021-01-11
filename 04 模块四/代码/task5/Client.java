package task5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket = null;
    private ClientReadThread readThread = null;
    private ClientWriteThread writeThread = null;


    Scanner sc = null;

    public Client() {
    }

    public void connect() {

        PrintStream ps = null;
        BufferedReader br = null;
        Scanner sc = null;

        try {
            sc = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String userName = sc.next();
            System.out.println("正在登陆.....");
            Socket socket = new Socket("127.0.0.1", 9999);


            //使用读写两个线程，避免需要录入时无法接收其他人的消息
            readThread = new ClientReadThread(socket, userName);
            writeThread = new ClientWriteThread(userName, socket, sc);

            readThread.start();
            writeThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
