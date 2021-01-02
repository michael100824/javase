/*
编程找出 1000 以内的所有完数并打印出来。
所谓完数就是一个数恰好等于它的因子之和， 如： 6=1＋2＋3
*/
public class perfectNumber{

  public static void main(String[] args) {
      System.out.print("1000以内的完数有： ");
      // 历遍从2到1000的整数
      for (int i=2; i<=1000; i++){
        int sum = 0;
        // 历遍从1到i-1的整数
        for (int j=1; j<i; j++){
          if (i % j == 0){
            sum += j; // 如果可以整除则相加进sum
          }
        }
      // 如果相加结果等于i本身，则输出
      if(sum==i){
        System.out.print(i + " ");
      }
      }
  }
}
