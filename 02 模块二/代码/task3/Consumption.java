package com.lagou.module2.task3;

public class Consumption extends AbstractPlan{

    private int sumTalkDuration;    // 统计通话时长
    private int sumData;            // 统计上网流量
    private double sumConsumption;  // 每月消费金额


    public Consumption() {
    }

    public Consumption(int monthFee, int sumTalkDuration, int sumData, double sumConsumption) {
        super(monthFee);
        setSumTalkDuration(sumTalkDuration);
        setSumData(sumData);
        setSumConsumption(sumConsumption);
    }

    public int getSumTalkDuration() {
        return sumTalkDuration;
    }

    public void setSumTalkDuration(int sumTalkDuration) {
        if(sumTalkDuration >= 0) {
            this.sumTalkDuration = sumTalkDuration;
        } else {
            System.out.println("统计通话时长不合理...");
        }
    }

    public int getSumData() {
        return sumData;
    }

    public void setSumData(int sumData) {
        if(sumData >= 0) {
            this.sumData = sumData;
        } else {
            System.out.println("统计流量不合理...");
        }
    }

    public double getSumConsumption() {
        return sumConsumption;
    }

    public void setSumConsumption(double sumConsumption) {
        if(sumConsumption >= 0) {
            this.sumConsumption = sumConsumption;
        } else {
            System.out.println("统计消费不合理...");
        }
    }

    @Override
    public void show() {
        System.out.println("该月通话时长：" + getSumTalkDuration() + "分钟, 使用流量：" + getSumData() + "GB, 月费金额: ￥" + getSumConsumption());
    }
}
