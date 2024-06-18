package com.Timer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;

public class TimeTask extends TimerTask {
    // 高考开始时间
    private LocalDateTime startTime;

    // 构造器，对高考的开始时间进行初始化
    public TimeTask() {
        String s = "2025-06-07 09:00:00";
        // 补全代码
        DateTimeFormatter dtf = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss");//日期格式化时间器（自定义） ps;yyyy-MM解析不了
        startTime = LocalDateTime.parse(s, dtf);
    }

    // 每一秒执行一次该方法
    @Override
    public void run() {
        // 补全代码：完成倒计时效果
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, startTime);
        //toHoursPart() jdk11才引入
        System.out.println(duration.toDays() + "天" + duration.toHoursPart() + "时" + duration.toMinutesPart() + "分" + duration.toSecondsPart() + "秒");
    }

}
