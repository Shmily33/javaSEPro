package com.javase.oopFundamental.homework;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/21:31
 * @Description:
 */
public class RectangleTest {
    public static void main(String[] args) {
        //空参创建对象set赋值
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setLength(8);
        rectangle1.setWidth(6);
        RectangleOperator rectangleOperator1 = new RectangleOperator();
        rectangleOperator1.area(rectangle1);
        rectangleOperator1.size(rectangle1);

        //满参直接创建
        Rectangle rectangle2 = new Rectangle(7, 3);
        RectangleOperator rectangleOperator2 = new RectangleOperator(rectangle2);
        rectangleOperator2.area();
        rectangleOperator2.size();
    }
}
