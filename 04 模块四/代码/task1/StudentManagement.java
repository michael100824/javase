package task1;


import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {


        Opration op = new Opration();
        // 如果文件存在的话，读取文件
        op.readStudent();


        while (true) {
            System.out.println("=====欢迎使用学生管理系统=====");
            System.out.println("请输入选择：");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");

            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();

            switch (str) {
                case "1":
                    //添加学生
                    op.addStudent();
                    break;
                case "2":
                    //删除学生
                    op.deleteStudent();
                    break;
                case "3":
                    //修改学生
                    op.modifyStudent();
                    break;
                case "4":
                    //查看所有学生
                    op.findAllStudent();
                    break;
                case "5":
                    System.out.println("已退出");
                    //保存学生对象到文件中
                    op.writeStudent();
                    System.exit(0);
            }
        }
    }
}
