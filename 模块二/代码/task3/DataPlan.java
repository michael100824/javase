package com.lagou.module2.task3;

public class DataPlan implements DataService{

    //私有化成员变量，使用private关键字修饰
    private int data;          // 上网流量
    private int monthFee;      // 每月资费

    public DataPlan() {
    }

    public DataPlan(int data, int monthFee) {
        setData(data);
        setMonthFee(monthFee);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        if (data >= 0) {
            this.data = data;
        } else {
            System.out.println("流量不合理...");
        }
    }

    public int getMonthFee() {
        return monthFee;
    }

    public void setMonthFee(int monthFee) {
        if(monthFee >= 0) {
            this.monthFee = monthFee;
        } else {
            System.out.printf("资费不合理...");
        }
    }

    public void show(){
        System.out.println("该上网套餐信息为："
                + "上网流量：" + getData() + "GB, 每月资费：￥" + getMonthFee());
    }

    @Override
    public void dataSer(int data, SimCard c) {
        System.out.println("这里是上网服务接口==DataService==中重写的抽象方法！");
        c.show();
    }
}
