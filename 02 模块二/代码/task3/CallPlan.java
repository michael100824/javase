package com.lagou.module2.task3;

public class CallPlan implements CallService {

    // 私有化成员变量，使用private关键字修饰
    private int talkDuration;  // 通话时长
    private int messageNumber; // 短信条数
    private int monthFee;      // 每月资费

    public CallPlan() {
    }

    public CallPlan(int talkDuration, int messageNumber, int monthFee) {
       setTalkDuration(talkDuration);
       setMessageNumber(messageNumber);
       setMonthFee(monthFee);
    }

    public int getTalkDuration() {
        return talkDuration;
    }

    public void setTalkDuration(int talkDuration) {
        if(talkDuration >= 0) {
            this.talkDuration = talkDuration;
        } else {
            System.out.println("通话时长不合理...");
        }

    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(int messageNumber) {
        if( messageNumber >= 0) {
            this.messageNumber = messageNumber;
        } else {
            System.out.println("短信数量不合理...");
        }

    }

    public int getMonthFee() {
        return monthFee;
    }

    public void setMonthFee(int monthFee) {
        if( monthFee >= 0) {
            this.monthFee = monthFee;
        } else {
            System.out.println("资费不合理...");
        }
    }

    public void show(){
        System.out.println("该通话套餐信息为：" +
                "通话时长：" + getTalkDuration() + "分钟, 短信条数：" + getMessageNumber() + "条, 每月资费：￥"+ getMonthFee());
    }

    @Override
    public void callSer(int talkDuration, SimCard c) {
        System.out.println("这里是通话服务接口==CallService==中重写的抽象方法!");
        c.show();
    }
}
