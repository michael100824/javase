/*
提示用户输入年月日信息，判断这一天是这一年中的第几天并打印。
*/
import java.util.Scanner;
public class dateNumber{

  public static void main(String[] args) {

    boolean leapYear = false;
    boolean legal = false;

    int year = 0;
    int month = 0;
    int day = 0;

    outer:
    while(!legal){
        System.out.println("请输入年月日并用空格隔开：");
        Scanner sc = new Scanner(System.in);
        year = sc.nextInt();
        month = sc.nextInt();
        day = sc.nextInt();
        //1. 判断是否是闰年

        if((year%4==0 && year%100!=0) || (year%400==0)){
          leapYear = true;
        }

        //2. 判断日期是否正确
        if(month>0 && month<=12){
            switch(month){
              case 1:;
              case 3:;
              case 5:;
              case 7:;
              case 8:;
              case 10:;
              case 12: if(day>0 && day<=31){
                          legal = true;
                        } else{
                            System.out.println("输入日期有误，请重新输入");
                          } break;
              case 4:;
              case 6:;
              case 9:;
              case 11: if(day>0 && day<=30){
                          legal = true;
                       } else{
                           System.out.println("输入日期有误，请重新输入");
                         } break;
              case 2: if((leapYear==true & (day>0 && day<=29)) || (leapYear==false & (day>0 || day>28))) {
                        legal = true;
                      } else{
                          System.out.println("输入日期有误，请重新输入");
                        } break;
            }
       } else {
         System.out.println("输入日期有误，请重新输入");
       }
    }


    //3. 创建一个一维数组保存每个月的天数

    byte[] monthDay = new byte[13];
         for(int i = 1; i<monthDay.length;i++){
           monthDay[i]=31;                  //大月31天
           if(4==i||6==i||9==i||11==i){ //小月30天
             monthDay[i]=30;
          }
         }

         if(leapYear){                   //闰年2月29天
           monthDay[2] = 29;
          }else{monthDay[2] = 28;
         }

    //4.计算并输出
    int sum = 0;
  	for(int i=1 ; i<month; i++){
  	 sum += monthDay[i]; //计算之前天数
  	}
    sum += day; // 加上该月天数

    System.out.println(year + "年" + month + "月" + day + "日是第" + sum + "天。" );
  }
}
