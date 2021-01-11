package task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Opration {


    private List<Student> array;
    File file = new File("/Users/junzhang/Student.txt");

    public Opration() {
        array = new ArrayList<>();
    }


    // 判断学号是否重复
    public boolean isUsed(int id) {
        boolean flag = false;

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getID() == id) {
                flag = true;
                break;
            }

        }
        return flag;
    }

    // 添加学生
    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        int id;

        while (true) {
            System.out.println("请输入学生学号");
            id = sc.nextInt();

            boolean flag = isUsed(id);
            if (flag) {
                System.out.println("学号重复，请重新输入");
            } else {
                break;
            }
        }

        System.out.println("请输入学生姓名");
        String name = sc.next();

        System.out.println("请输入学生年龄");
        int age = sc.nextInt();
        // 创建学生对象，并赋值
        Student s = new Student();
        s.setID(id);
        s.setName(name);
        s.setAge(age);
        //将学生对象添加到集合中
        array.add(s);
        //给出成功提示
        System.out.println("添加学生成功！");
        System.out.printf("添加学生信息如下：学号：" + s.getID() + "，姓名：" +
                s.getName() + "，年龄：" + s.getAge());
        System.out.println();
    }

    // 修改学生
    public void modifyStudent() {

        Scanner sc = new Scanner(System.in);
        int id;
        int index;
        while (true) {
            System.out.println("请输入需要修改的学生学号");
            id = sc.nextInt();
            // index = -1，如果能够匹配，则将匹配到的对象下标赋值给index
            // 如果index在循环完之后仍然为-1，则表示集合中没有可匹配的对象
            index = -1;
            for (int i = 0; i < array.size(); i++) {
                Student student = array.get(i);
                if (student.getID() == id) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("输入的学生号有误，请重新输入");
            } else {
                break;
            }
        }


        System.out.println("请输入学生新姓名");
        String name = sc.next();
        System.out.println("请输入学生新年龄");
        int age = sc.nextInt();

        //创建新的学生对象
        Student s = new Student();
        s.setID(id);
        s.setName(name);
        s.setAge(age);

        //修改学生
        array.set(index, s);

        System.out.println("修改学生成功");
    }


    // 查看学生
    public void findAllStudent() {
        if (array.size() == 0) {
            System.out.println("没有学生信息");
            return;
        }

        System.out.println("学号\t\t姓名\t\t年龄");

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getID() + "\t" + s.getName() + "\t\t" + s.getAge());
        }
    }

    // 删除学生
    public void deleteStudent() {
        System.out.println("请输入需要删除的学生学号");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();

        //判断输入学号是否存在
        int index = -1;

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getID() == (id)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("输入的学生不存在");
        } else {
            array.remove(index);
        }

        System.out.println("删除学生成功！");
    }

    //获取全部数据
    public List<Student> getStudentList() {
        return array;
    }

    //初始化缓存数据
    public void setStudentList(Object list) {
        if (null == list) {
            return;
        }
        this.array = (List<Student>) list;
    }


    //写入文件中
    public void writeStudent() {
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(getStudentList());
            System.out.println("写入文件成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //从文件读取对象
    public void readStudent() {
        ObjectInputStream oi = null;
        if (file.exists()) {
            try {
                oi = new ObjectInputStream(new FileInputStream(file));
                setStudentList(oi.readObject());
                System.out.println("读取文件成功！");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (null != oi) {
                    try {
                        oi.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else {
            System.out.println("第一次使用，还没有可读取的文件！");
        }
    }
}
