package com.lagou.module2.task3;

public interface CallService {
    //抽象方法: 参数1: 通话分钟, 参数2: 手机卡类对象
    public abstract void callSer(int talkDuration, SimCard c);
}
