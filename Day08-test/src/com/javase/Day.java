package com.javase;

import java.time.LocalDate;

/**
 * @Author: gs_wang
 * @Date: 2024/06/18/下午2:59
 * @Description:
 */
public class Day {
    public Day() {
    }

    private LocalDate date;

    public Day(LocalDate date) {
        this.date = date;
    }

    public Day(LocalDate date, boolean flag) {
        this.date = date;
        this.flag = flag;
    }

    private boolean flag; // true休息

    @Override
    public String toString() {
        return date.toString() + (flag ? "[休息]" : "");
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
