package com.javase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: gs_wang
 * @Date: 2024/06/18/上午10:12
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        String userStrs = "10001:张三:男:1990-01-01" +
                "#10002:李四:女:1989-01-09#10003:王五:男:1999-09-09" +
                "#10004:刘备:男:1899-01-01#10005:孙悟空:男:1900-01-01" +
                "#10006:张三:女:1999-01-01#10007:刘备:女:1999-01-01" +
                "#10008:张三:女:2003-07-01#10009:猪八戒:男:1900-01-01";
        String[] strings = userStrs.split("[:#]");
//        System.out.println(Arrays.toString(strings));
        ArrayList<User> users = new ArrayList<>();
        int idx = 0;
        while (idx < strings.length) {
            User user = new User();
            user.setId(Long.parseLong(strings[idx++]));
            user.setName(strings[idx++]);
            user.setGender(strings[idx++]);
//            String[] temp = strings[idx++].split("-");
//            user.setBirthday(LocalDate.of(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
            user.setBirthday(LocalDate.parse(strings[idx++]));
            users.add(user);
//            idx++;
        }
        users.forEach(user -> System.out.println(user.toString()));
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (User user : users) {
            if(hashMap.containsKey(user.getName())){
                hashMap.put(user.getName(), hashMap.get(user.getName()) + 1);
            }else{
                hashMap.put(user.getName(), 1);
            }
//            hashMap.put(user.getName(), hashMap.get(user.getName()) + 1);
        }
        hashMap.forEach((k, v) -> System.out.println(k + ": " + v+"次"));
    }

}
