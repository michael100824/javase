/**
 *  编程实现以下需求：
 *
 * 定义一个长度为[16][16]的整型二维数组并输入或指定所有位置的元素值，分别实现二维数组中所有行和所有列中所有元素的累加和并打印。
 *
 * 再分别实现二维数组中左上角到右下角和右上角到左下角所有元素的累加和并打印。
 */

package com.lagou.module2.task1;

import java.util.Random;

public class SumArr {
    // 声明二维数组、行、列
    private int[][] arr;
    private int row;
    private int col;

    // 声明两个一维数组储存行和列的求和数值
    // 声明两个变量储存对角线的求和数值
    private int[] rowSum;
    private int[] colSum;
    private int leftDiagonalSum;
    private int rightDiagonalSum;

    // 创建无参构造方法
    public SumArr() {
    }

    // 创建有参构造，参数为row col，初始化rowSum，colSum和arr
    public SumArr(int row, int col) {
        setRow(row);
        setCol(col);
        rowSum = new int[row];
        colSum = new int[col];
        arr = new int[row][col];
    }


    // 提供共有get set方法
    public int[][] getArr() {
        return arr;
    }

    public void setArr(int[][] arr) {
        this.arr = arr;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int[] getRowSum() {
        return rowSum;
    }

    public void setRowSum(int[] rowSum) {
        this.rowSum = rowSum;
    }

    public int[] getColSum() {
        return colSum;
    }

    public void setColSum(int[] colSum) {
        this.colSum = colSum;
    }

    public int getLeftDiagonalSum() {
        return leftDiagonalSum;
    }

    public int getRightDiagonalSum() {
        return rightDiagonalSum;
    }


    // 创建成员方法来计算每一行的和
   public void calc(){
        // 利用随机数填充数组
       Random ra = new Random();
       for (int i = 0; i < arr.length; i++) {
           for (int j = 0; j < arr[i].length; j++){

               //为了计算方便，所有的随机数小于10
               arr[i][j]=ra.nextInt(10);
               rowSum[i] += arr[i][j];
               colSum[j] += arr[i][j];

               if (i == j){
                   leftDiagonalSum += arr[i][j];
               }

               if ((i + j - 1) == arr[i].length){
                   rightDiagonalSum += arr[i][j];
               }
           }
       }
    }

    public void show() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.println();
        }
    }

}