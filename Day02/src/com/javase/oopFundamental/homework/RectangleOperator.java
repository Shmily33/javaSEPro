package com.javase.oopFundamental.homework;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/21:28
 * @Description:
 */
public class RectangleOperator {
    Rectangle rectangle;

    public RectangleOperator(){}

    public RectangleOperator(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public void area() {
        System.out.println("长方形面积：" + rectangle.getWidth() * rectangle.getLength());
    }
    public void area(Rectangle rectangle) {
        System.out.println("长方形面积：" + rectangle.getWidth() * rectangle.getLength());
    }

    public void size() {
        System.out.println("长方形周长：" + (rectangle.getWidth() + rectangle.getLength()) * 2);

    }
    public void size(Rectangle rectangle) {
        System.out.println("长方形周长：" + (rectangle.getWidth() + rectangle.getLength()) * 2);
    }

}
