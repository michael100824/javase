package com.lagou.module2.task3;

public class SimCard {

    // 私有化成员变量，使用private关键字修饰
    private String cardType;   // 卡类型
    private int id;            // 卡号
    private String userName;   // 用户名
    private String passWord;   // 密码
    private double balance;     // 余额
    private int talkDuration;   // 通话时长
    private int data;          // 上网流量

    public SimCard() {
    }

    public SimCard(String cardType, int id, String userName, String passWord, double balance, int talkDuration, int data) {
        setCardType(cardType);
        setId(id);
        setUserName(userName);
        setPassWord(passWord);
        setBalance(balance);
        setTalkDuration(talkDuration);
        setData(data);
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0){
            this.id = id;
        } else {
            System.out.println("输入卡号不合理，请重新输入...");
        }

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("输入余额不合理，请重新输入...");
        }
    }

    public int getTalkDuration() {
        return talkDuration;
    }

    public void setTalkDuration(int talkDuration) {
        if(talkDuration >= 0) {
            this.talkDuration = talkDuration;
        } else {
            System.out.println("输入通话时长不合理，请重新输入...");
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        if(data >= 0) {
            this.data = data;
        } else {
            System.out.println("输入流量不合理，请重新输入...");
        }
    }

    // 成员方法show打印内容
    public void show(){
        System.out.println("卡号是：" + getId() +
                ", 用户名是：" + getUserName() + ", 密码是：" + getPassWord() + ", 当前余额是：" + getBalance() + ", 卡的类型是：" + getCardType());
    }
}
