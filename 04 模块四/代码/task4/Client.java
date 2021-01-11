package task4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Socket s = null;
        Scanner sc = new Scanner(System.in);
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            // 本地地址和端口号
            s = new Socket("127.0.0.1", 8888);
                System.out.println("请输入用户名和密码 :");

            String userName = sc.next();
            String userPswd = sc.next();
            User user = new User(userName, userPswd);

            oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(user);
            System.out.println("消息已发送给服务器!");

            ois = new ObjectInputStream(s.getInputStream());
            UserMessage um = (UserMessage) ois.readObject();

            System.out.println("登陆" + um.getType() + "!");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            //关闭流对象
        } finally {
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != s) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
