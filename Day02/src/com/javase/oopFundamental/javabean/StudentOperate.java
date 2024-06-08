package com.javase.oopFundamental.javabean;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/20:42
 * @Description:
 */
public class StudentOperate {
    private Student student;

    public StudentOperate(Student student) {
        this.student = student;
    }

    public void printPass() {
        if (student.getScore() >= 60){
            System.out.println("及格了~");
        }else{
            System.out.println("不及格~");
        }
    }

}
