package com.lagou.module2.task3;
/**
 * 设计和实现以下枚举类 手机卡的类型总共有 3 种：大卡、小卡、微型卡
 */
public enum CardType {

    //声明本类类型的引用指向本类类型的变量
    BIG("大卡"), SMALL("小卡"), MICRO("微型卡");

    private final String desc;  //  用于描述手机卡类型的成员变量

    //私有化构造方法，此时该构造方法只能在本类内部使用
    private CardType(String desc) {
        this.desc = desc;
    }

    // 通过公有的get方法可以在本类的外部访问该类成员变量的数值
    public String getDesc() {
        return desc;
    }
}
