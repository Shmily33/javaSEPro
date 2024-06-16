package com.javase.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: gs_wang
 * @Date: 2024/06/16/下午3:23
 * @Description: 使用正则表达式查找一段文本中的内容
 */
public class RegexTest {
    public static void main(String[] args) {
        String data = "来黑马程序员学习Java，\n" +
                "      电话：18666688888，18699997777\n" +
                "      或者联系邮箱：boniu@itcast.cn，\n" +
                "      座机电话：01036517895，010-98951256\n" +
                "      邮箱：bozai@itcast.cn，\n" +
                "      邮箱2：dlei0009@163.com，\n" +
                "      热线电话：400-618-9090 ，400-618-4000，4006184000，4006189090";
        // 1.定义爬取规则
        String regex = "(1[3-9]\\d{9})|(0\\d{2,7}-?[1-9]\\d{4,19})|" +
                "(\\w{2,}@(\\w{2,10}\\.){1,2})|(400-?\\d{3,7}-?\\d{3,7})";
        // 2.封装成Pattern对象
        Pattern pattern = Pattern.compile(regex);
        // 3.通过Pattern对象去获取查找内容的匹配器对象
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        String s2 = "我我我们喜喜喜喜喜喜欢欢欢欢欢欢欢欢欢编编编编编编编编编编编编程程程程程程程程程程程啊";
        /**
         * (.)一组： .匹配任意字符
         * \\1： 为这个组声明一个组号
         * + ：声明必须是重复的字
         * $1：可以取到第一组代表的那个重复的字
         * 在正则表达式中，使用 \\1 表示引用第一个捕获组的内容，而 \\2 则表示引用第二个捕获组的内容，以此类推。在给定的代码中，只使用了一个捕获组 (.)，因此只能使用 \\1 来引用它。
         * 捕获组是通过圆括号来创建的，每个圆括号内的内容都会被视为一个捕获组。在正则表达式替换的时候，可以使用这些捕获组的引用来进行替换操作。
         * 如果在正则表达式中有多个捕获组，并且需要引用它们，可以使用 \\1、\\2、\\3 等来分别引用第一、第二、第三个捕获组的内容
         */
        System.out.println(s2.replaceAll("(.)\\1+", "$1"));

    }
}
