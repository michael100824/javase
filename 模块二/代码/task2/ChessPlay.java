/**
 *  编程实现控制台版并支持两人对战的五子棋游戏。
 *
 * （1）绘制棋盘 - 写一个成员方法实现
 *
 * （2）提示黑方和白方分别下棋并重新绘制棋盘 - 写一个成员方法实现。
 *
 * （3）每当一方下棋后判断是否获胜 - 写一个成员方法实现。
 *
 * （4）提示： 采用二维数组来模拟并描述棋盘，棋盘如下：
 */
package com.lagou.module2.task2;

import java.util.Scanner;

public class ChessPlay {

    private static String[][] checkerboard = new String[17][17];

    private static int x;
    private static int y;

    private static boolean gameover;

    private Scanner sc = new Scanner(System.in);



    // 无参构造方法，初始化数组默认值
    public ChessPlay() {

        checkerboard[0][0] = " ";

        //1. 第一行
        for (int i = 0; i <= checkerboard.length - 1; i++){
            if (i <= 10){
                checkerboard[0][i] = String.valueOf((char)(48 + i - 1));
            } else {
                checkerboard[0][i] = String.valueOf((char)(i + 86));
            }
        }

        //2. 第一列
        for (int j = 0; j <= checkerboard.length - 1; j++){
            if (j <= 10){
                checkerboard[j][0] = String.valueOf((char)(48 + j - 1));
            } else {
                checkerboard[j][0] = String.valueOf((char)(j + 86));
            }
        }

        // 3. 其余都是符号“+”
        for (int i = 1; i < checkerboard.length; i++){
            for (int j = 1; j < checkerboard.length; j++){
                checkerboard[i][j] = "+";
            }
        }
    }

    public static void draw(){
        System.out.println("白棋：X 黑棋：O");

        for(int i = 0; i < checkerboard.length; i++) {  //行
            for (int j = 0; j < checkerboard.length; j++) {  //列
                System.out.print(checkerboard[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void isWin() {
        String shape = checkerboard[x][y]; // 当前棋子形状
        int forward = 0; // 向前数的棋子数
        int backward = 0; // 向后数的棋子数
        int sum = 0; // 相同形状棋子的总数

        // 水平方向的棋子数量，先向左数，再向右数
        for (int i = x, j = y - 1; checkerboard[i][j].equals(shape) && i < 16 && j > 0 && j < 16; j--) {
            forward++;
        }
        for (int i = x, j = y + 1; checkerboard[i][j].equals(shape) && i < 16 && j > 0 && j < 16; j++) {
            backward++;
        }
        sum = forward + backward;
        if(sum >= 4) { //左侧和右侧的棋子加起来共4颗，加上刚刚下的一颗共5颗
            gameover = true; //如果有5颗棋结束
        } else {
            forward = 0;
            forward = 0;
            sum = 0;
        }

        //竖直方向
        for(int i = x - 1, j = y; checkerboard[i][j].equals(shape) && i < 16 && j < 16; i--) {
            forward++;
        }
        for (int i = x + 1, j = y; checkerboard[i][j].equals(shape) && i < 16 && j < 16; i++) {
            backward++;
        }
        sum = forward + backward;
        if(sum >= 4) {
            gameover = true;
        } else {
            forward=0;
            backward = 0;
            sum = 0;
        }
        
        //右斜方向
        for(int i = x+1, j = y-1; checkerboard[i][j].equals(shape) && i < 17 && j < 16; i++,j--) {
            forward++;
        }
        for (int i = x-1, j = y+1; checkerboard[i][j].equals(shape) && i < 16 && j < 16; i--, j++) {
            backward++;
        }
        sum = forward + backward;
        if(sum >= 4) {
            gameover = true;
        } else {
            forward=0;
            backward = 0;
            sum = 0;
        }

        //左斜方向
        for(int i = x-1, j = y-1; checkerboard[i][j].equals(shape) && i < 16 && j < 16; i--,j--) {
            forward++;
        }
        for (int i = x+1, j = y+1; checkerboard[i][j].equals(shape) && i < 16 && j < 16; i++, j++) {
            backward++;
        }
        sum = forward + backward;
        if(sum >= 4) {
            gameover = true;
        } else {
            forward = 0;
            backward = 0;
            sum = 0;
        }

    }

    public void start() {
        boolean flag = false;
        System.out.println("比赛开始");
        while (true) {
            System.out.println("请" + (flag ? "白方" : "黑方") + "落子：");
            x = sc.nextInt() + 1;
            y = sc.nextInt() + 1;

            // 判断输入是否在棋盘内，判断输入点是否已经有棋子
            if (x < 0 || x > 16 || y < 0 || y > 16) {
                System.out.println("输入有误，请重新输入");
            } else if (!("+".equals(checkerboard[x][y]))) {  //判断输入的位置是否有棋子
                System.out.println("输入的位置已有棋子，请重新输入");
            } else {
                if (flag) {
                    checkerboard[x][y] = "O";
                } else {
                    checkerboard[x][y] = "X";
                }
            }
            ChessPlay.draw();
            ChessPlay.isWin();
            if (gameover) {
                System.out.print("游戏结束！");
                System.out.println((flag ? "白方" : "黑方") + "胜利！");
                break;
            } else {
                flag = !flag;//换对方下棋
            }
        }
    }

}
    
