package com.lagou.module2.task1;

public class SumArrTest {

    public static void main(String[] args) {

        //
        SumArr sa = new SumArr(16, 16);
        System.out.println("======随机生成的数组是======");
        sa.calc();
        sa.show();


        int[] rowSum = sa.getRowSum();
        System.out.println("======每一行的和为======");
        for (int i = 0; i < rowSum.length; i++){
            System.out.println("第" + (i+1) + "行的和是: " + rowSum[i]);
        }

        int[] colSum = sa.getColSum();
        System.out.println("======每一列的和为======");
        for (int i = 0; i < colSum.length; i++){
            System.out.println("第" + (i+1) + "列的和是: " + colSum[i]);
        }

        System.out.println("======左上角到右下角的和为======");
        System.out.println(sa.getLeftDiagonalSum());
        System.out.println("======右上角到左下角的和为======");
        System.out.println(sa.getRightDiagonalSum());
    }
}
