package task5;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Base64;

public class ClientReadThread extends Thread {

    private Socket socket = null;
    private String name = null;


    public ClientReadThread(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }

    @Override
    public void run() {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            FileOutputStream fileOutputStream = null;

            String[] split = null;
            String fileName = "";
            String username = "";
            String message = br.readLine();
            recheck:
            while (true) {
                try {
                    if (message.startsWith("file:0")) {
                        split = message.split(":");
                        fileName = split[3];
                        username = split[2];
                        System.out.println(username + "向你发送了文件:" + fileName);
                    } else if (message.startsWith("file:1")) {
                        split = message.split(":");
                        File file = new File("./" + name);
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        fileOutputStream = new FileOutputStream(file.getPath() + "/" + fileName);
                        while (message.startsWith("file:1")) {
                            String content = split[4];
                            content = content.replaceAll("\n", "").replaceAll("\n", "").replaceAll("\r", "");
                            byte[] decode = Base64.getDecoder().decode(content.getBytes());
                            fileOutputStream.write(decode, 0, decode.length);
                            message = br.readLine();
                            if (message.startsWith("file:2")) {
                                System.out.println(username + "的文件：" + fileName + "已经发送完成");
                                break;
                            }
                        }
                    } else {
                        System.out.println(message);
                    }
                    message = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
