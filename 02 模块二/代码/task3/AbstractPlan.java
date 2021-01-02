package com.lagou.module2.task3;

public abstract class AbstractPlan {

    private int monthFee;

    public AbstractPlan() {
    }

    public AbstractPlan(int monthFee) {
        setMonthFee(monthFee);
    }

    public int getMonthFee() {
        return monthFee;
    }

    public void setMonthFee(int monthFee) {
        if(monthFee > 0) {
            this.monthFee = monthFee;
        } else {
            System.out.println("每月资费不合理...");
        }
    }

    public abstract void show();
}
