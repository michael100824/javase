/*
自定义数组扩容规则，当已存储元素数量达到总容量的 80%时，扩容 1.5 倍。
例如，总容量是 10，当输入第 8 个元素时，数组进行扩容，容量从 10 变 15。
*/
import java.util.Scanner;
import java.util.Arrays;

public class arrayExpansion{

  public static void main(String[] args) {

    //1. 创建一个一维数组,长度由用户定义
    System.out.println("请输入初始数组长度：");
    Scanner sc = new Scanner(System.in);
    int arrMax = sc.nextInt();
    int[] arr = new int[arrMax];
    System.out.println("现在的数组中最多可存放" + arrMax + "个元素");

    //2. 提示用户输入元素
    int i = 0;
    boolean flag = true;

    do {
    int arrLimit = (int)(arrMax * 0.8);
    while (i<arrLimit){
      System.out.println("请输入第" + (i+1) + "个元素：");
      int element = sc.nextInt();
      arr[i] = element;
      System.out.print("现在数组里有元素: ");
      System.out.println(Arrays.toString(arr));
      i++;
    }

    System.out.println("现在的数组已达到最大容量80%即将扩容，是否继续输入? 选择y/n继续...");
    String yesOrNo = sc.next();
    flag =  (yesOrNo.equals("y")) ? true : false;
    if (flag==false){
      break;
    }

    System.out.println("正在扩容...");
    int newArrMax = (int)(arrMax * 1.5);
    int newArrLimit = (int)(newArrMax * 0.8);
    int[] newArr = new int[newArrMax];
    System.arraycopy(arr, 0, newArr, 0, arrLimit);  //将原来数组的元素复制到扩容后的数组中
    arr = newArr; //将arr指向扩容后的数组
    arrMax = newArrMax; // 原数组长度更新为新数组长度
    System.out.println("扩容完成。现在的数组中最多可存放" + arrMax + "个元素");
    System.out.println("现在数组里有元素:" + Arrays.toString(arr));
  } while (flag);

  System.out.println("结束。现在数组里有元素:" + Arrays.toString(arr));
  }
}
