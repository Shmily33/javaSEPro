package com.javase.oop1.homework;

/**
 * @Author: gs_wang
 * @Date: 2024/06/14/下午4:05
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        Manager manager = new Manager("张三", "001", 13000, 2000);
        Programmer programmer = new Programmer("李四","002",15000);
        manager.work();
        programmer.work();
    }
}

class People {
    private String name;
    private String workCode;
    private double salary;

    public People() {
    }

    public People(String name, String workCode, double salary) {
        this.name = name;
        this.workCode = workCode;
        this.salary = salary;
    }

    public void work() {
        System.out.println("工作中");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkCode() {
        return workCode;
    }

    public void setWorkCode(String workCode) {
        this.workCode = workCode;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Manager extends People {

    private double bonus;

    public Manager() {

    }

    public Manager(String name, String workCode, double salary, double bonus) {
        super(name, workCode, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("工号为："+getWorkCode()+"的"+getName()+"经理，拿着工资："+getSalary()
                +"和奖金："+getBonus()+"看程序员敲代码中~");
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}

class Programmer extends People {

    public Programmer() {
    }

    public Programmer(String name, String workCode, double salary) {
        super(name, workCode, salary);

    }

    @Override
    public void work() {
        System.out.println("工号为："+getWorkCode()+"的"+getName()+"程序员，拿着工资："+getSalary()
                +"敲代码中~！");
    }
}