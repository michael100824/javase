/*
实现双色球抽奖游戏中奖号码的生成，中奖号码由 6 个红球号码和 1 个蓝球号码组成。
其中红球号码要求随机生成 6 个 1~33 之间不重复的随机号码。
其中蓝球号码要求随机生成 1 个 1~16 之间的随机号码。
*/

import java.util.Random;
import java.util.Arrays;

public class chouJiang{

  public static void main(String[] args) {


        // 创建一个长度为7,类型为int的一维数组保存号码
        int[] resList = new int[7];  //默认初始值为0

        // 1.随机生成6个数(1~33)
        int redMax = 33;
        Random ra = new Random();
        boolean overlapFlag = false; //overlapFlag 初始值false表示不重复
        //遍历六个红球
        for(int i=0; i<6; i++) {

            do {    // 生成一个唯一的随机数
                resList[i] = ra.nextInt(redMax) + 1;
                // 判断是否重复
                for(int j=0; j<i; j++) {
                    if(resList[i]==resList[j]) {
                        overlapFlag = true;
                        break;
                    } else {
                        overlapFlag = false;
                    }
                }

            } while(overlapFlag);

        }

        // 2.随机生成1个蓝球号码(1~16)
        int blueMax = 16;
        resList[6] = ra.nextInt(blueMax) + 1;

        // 3.输出生成结果
        System.out.print("双色球中奖号码是：");
        System.out.print(Arrays.toString(resList));
        System.out.println();
  }
}
