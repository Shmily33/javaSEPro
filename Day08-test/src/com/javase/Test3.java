package com.javase;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/18/上午11:19
 * @Description:
 */
public class Test3 {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2022, 2, 3); //休息
        System.out.println("请输入查询年月（必须是2022年2月及之后的）：");

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String str = s + "-01"; //日期的格式化方法只能解析年月日，随便加上一个日子

//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM");
        LocalDate endDate = LocalDate.parse(str);
        // 当前月的最后一天
        endDate = endDate.plusMonths(1).minusDays(1);//输入的月份+1再减一天就是输入的月份的最后一天
//        System.out.println(endDate);

        ArrayList<Day> days = new ArrayList<>();
        while (startDate.isBefore(endDate) || startDate.equals(endDate)) {
            Day day = new Day(startDate, false);
            days.add(day);
            startDate = startDate.plusDays(1);
        }
        System.out.println("全部日子：" + days);

        for (int i = 0; i < days.size(); i += 3) {
            Day day = days.get(i);
            day.setFlag(true);//休息
        }
        // 展示当月休息日
        YearMonth yearMonth = YearMonth.parse(s); // 年月对象格式
        int month = yearMonth.lengthOfMonth(); // 月的长度
        System.out.println("当月一共多少天：" + month);
        ArrayList<Day> restDay = new ArrayList<>();
        for (int i = days.size() - month; i < days.size(); i++) {
//            days.get(i).setFlag(true);
            System.out.println(days.get(i));
            if (days.get(i).isFlag()) {
                restDay.add(days.get(i));
            }
//            restDay.add(days.get(i));
        }
        //找出星期几和周末
        System.out.println("---" + str + "周末情况：");
        restDay.stream().filter(d -> d.getDate().getDayOfWeek().getValue() == 6 || d.getDate().getDayOfWeek().getValue() == 7)
                .forEach(d -> System.out.print(d + (d.getDate().getDayOfWeek().getValue() == 6 ? "周六" : "周日 ")));


    }

}
