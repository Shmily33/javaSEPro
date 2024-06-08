package com.javase.oopFundamental.homework;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/21:26
 * @Description:
 */
public class Rectangle {
    private double width;
    private double length;

    public Rectangle(){

    }
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
