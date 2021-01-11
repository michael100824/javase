package task5;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {

    private Socket socket;
    private String name = "";
    private ClientMessageCallback callback;

    public ServerThread(Socket socket, ClientMessageCallback callback) {
        this.socket = socket;
        this.callback = callback;
    }

    public void setThreadName(String name) {
        this.name = name;
    }

    void sendMessage(String message) {
        try {
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true) {
                String message = br.readLine();
                if (message.startsWith("login:")) {
                    String userName = message.replace("login:","");
                    setThreadName(userName);
                    callback.receiveMessage(name + "加入聊天室");
                } else if (message.startsWith("message:")) {
                    String content = message.replace("message:","");
                    callback.receiveMessage(name + ": " + content);

                    if (content.equalsIgnoreCase("bye")) {
                        callback.receiveMessage( name + "已经下线");
                        break;
                    }
                } else if (message.startsWith("file:")) {
                    callback.receiveMessage(message);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
