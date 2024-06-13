package com.javase.ATMsystem;

/**
 * @Author: gs_wang
 * @Date: 2024/06/12/18:14
 * @Description: 账户类
 */
public class Account {
    private String accNo;  // 卡号
    private String accName; // 用户名
    private char sex;
    private String password;
    private double money;
    private double limit; // 取现额度

    public Account() {
    }

    public Account(String accNo, String accName, char sex, String password, double money, double limit) {
        this.accNo = accNo;
        this.accName = accName;
        this.sex = sex;
        this.password = password;
        this.money = money;
        this.limit = limit;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAccName() {
        return accName + (sex == '男' ? "先生" : "女士");
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
