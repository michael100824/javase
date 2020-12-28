package task4;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {
        //创建学生对象
        ArrayList<Student> array = new ArrayList<>();


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
                    Opration.addStudent(array);
                    break;
                case "2":
                    //删除学生
                    Opration.deleteStudent(array);
                    break;
                case "3":
                    //修改学生
                    Opration.modifyStudent(array);
                    break;
                case "4":
                    //查看所有学生
                    Opration.findAllStudent(array);
                    break;
                case "5":
                    System.out.println("已退出");
                    System.exit(0);
            }
        }
    }
}
