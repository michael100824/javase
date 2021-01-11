package task5;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

public class ClientWriteThread extends Thread {

    private String username = "";
    private Socket socket = null;
    private Scanner scanner = null;


    public ClientWriteThread(String userName, Socket socket, Scanner scanner) {
        this.username = userName;
        this.socket = socket;
        this.scanner = scanner;
    }

    @Override
    public void run() {

        PrintStream ps = null;
        try {
            //用户名登陆：
            ps = new PrintStream(socket.getOutputStream());
            ps.println("login:" + username);
            System.out.println("请直接输入要发送的内容(发送文件请输入 file: + 地址)：");
            while (true) {
                String input = scanner.next();
                //传输文件
                if (input.startsWith("file:")) {
                    String path = input.replace("file:", "");
                    File file = new File(path);
                    if (!file.exists() || file.isDirectory()) {
                        break;
                    }
                    FileInputStream inputStream = new FileInputStream(file);
                    // file: 表示传递文件 0 1 2 表示传递开始，过程中，结束 后面跟文件名和内容
                    ps.println("file:0:" + username + ":" + file.getName());
                    byte[] bArr = new byte[1024 * 8];
                    int res = 0;
                    while ((res = inputStream.read(bArr)) != -1) {
                        //当长度不足时，copy成等长数组，避免传输额外内容
                        if (res < bArr.length) {
                            byte[] bArrEnd = Arrays.copyOf(bArr, res);
                            System.out.println();
                            ps.println("file:1:" + username + ":" + file.getName() + ":" + res + ":" + new String(Base64.getEncoder().encode(bArrEnd)));
                        } else {
                            ps.println("file:1:" + username + ":" + file.getName() + ":" + res + ":" + new String(Base64.getEncoder().encode(bArr)));
                        }
                    }
                    ps.println("file:2:" + username + ":" + file.getName());
                } else {
                    //传输消息
                    ps.println("message:" + input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
