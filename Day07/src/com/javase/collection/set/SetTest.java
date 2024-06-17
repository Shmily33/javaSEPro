package com.javase.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: gs_wang
 * @Date: 2024/06/17/下午9:00
 * @Description:
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("3726221951dg010416");
        set.add("37222219700211041x");
        set.add("37242219680208044x");
        set.add("354221968020850444");
        set.add("37262319800904575x");
        set.add("37222231af303a99673");
        set.add("3711fdg98603040033");
        set.add("373522198511190042");
        set.add("3755sdf1991112998x");
        String regex="([1-9]\\d{17})|([1-9]\\d{16}[xX])";
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            Matcher matcher = Pattern.compile(regex).matcher(it.next());
            if(!matcher.find()){
//                System.out.println(matcher.group());
                it.remove();
            }
        }
        System.out.println(set);
    }

}
