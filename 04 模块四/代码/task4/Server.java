package task4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket s = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            ss = new ServerSocket(8888);
            while(true) {
                System.out.println("等待客户端连接...");

                s = ss.accept();
                System.out.println("客户端" + s.getInetAddress() + "连接成功!");

                ois = new ObjectInputStream(s.getInputStream());
                User user = (User) ois.readObject();

                String type;
                if ("admin".equals(user.getName()) && "123456".equals(user.getPassWord())) {
                    type = "成功";
                } else {
                    type = "失败";
                }
                UserMessage um = new UserMessage(user.getName(), user.getPassWord(), type);

                oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(um);

                System.out.println("服务器发送消息成功!");
            }

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=oos){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null!=ois){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null!=s){
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null!=ss){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
