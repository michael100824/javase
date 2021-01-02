package com.lagou.module2.task3;

import javax.management.openmbean.CompositeDataSupport;

public class PhoneTest {

    public static void main(String[] args) {

        // 声明SimCard类型的引用指向SimCard类型的对象并打印特征
        SimCard c1 = new SimCard();
        c1.show();

        System.out.println("-------------------------------------------");

        // 声明CallPlan类型的引用指向CallPlan类型的对象并打印特征
        CallPlan cp = new CallPlan(500, 100 , 50);
        cp.show();

        System.out.println("-------------------------------------------");

        // 声明CallService接口类型的引用指向实现类的对象,形成了多态
        CallService cs = new CallPlan();
        CardType ct1 = CardType.BIG;
        cs.callSer(20, new SimCard(ct1.getDesc(),1000,"张三","zhangsan",100.0,300,50));

        System.out.println("-------------------------------------------");

        // 声明DataPlan类型的引用指向DataPlan类型的对象并打印特征
        DataPlan dp = new DataPlan(20, 80);
        dp.show();

        System.out.println("-------------------------------------------");
        // 声明DataService接口类型的引用指向实现类的对象,形成了多态
        DataService ds = new DataPlan();
        CardType ct2 = CardType.SMALL;
        ds.dataSer(10,new SimCard(ct2.getDesc(),1001,"李四","lisi",100.0,200,30));

        System.out.println("-------------------------------------------");

        // 声明AbstractPlan类型的引用指向Consumption类型的对象，形成了多态
        AbstractPlan ap = new Consumption(100, 200, 50, 60.0);
        // 编译阶段调用父类版本，运行阶段调用子类版本
        ap.show();
    }


}
