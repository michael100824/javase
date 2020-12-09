/*
使用双重循环实现五子棋游戏棋盘的绘制
*/
import java.util.Arrays;

public class Chess{

  public static void main(String[] args) {

    //1. 创建17x17的二维数组
    char[][] arr = new char[17][17];

    //2. 第一行
    for (int i=0; i<=arr.length-1; i++){
      if (i<=10){
      arr[0][i] = (char)(48+i-1);
    } else {
      arr[0][i] = (char)(i+86);
    }
    }

    //3. 第一列
    for (int j=0; j<=arr.length-1; j++){
      if (j<=10){
      arr[j][0] = (char)(48+j-1);
    } else {
      arr[j][0] = (char)(j+86);
    }
    }

    //4. 打印 + 符号
    for (int i=1; i<arr.length; i++){
      for (int j=1; j<arr.length; j++){
        arr[i][j] = '+';
      }
    }

    for(int i=0; i<arr.length; i++){  //行
      for(int j=0; j<arr.length; j++) {  //列
        System.out.print(arr[i][j] + "   ");
      }
        System.out.println();
    }
  }
}
