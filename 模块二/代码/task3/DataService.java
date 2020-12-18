package com.lagou.module2.task3;

public interface DataService {
    //抽象方法: 参数1: 上网流量, 参数2: 手机卡类对象
    public abstract void dataSer(int data, SimCard c);
}
