package com.javase.collection.list;

import java.util.LinkedList;

/**
 * @Author: gs_wang
 * @Date: 2024/06/16/下午5:12
 * @Description: LinkedList 实现队列、栈
 */
public class ListTest {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        // 入队
        queue.addLast("第一个");
//        queue.push();
        queue.addLast("第二个");
        queue.addLast("第三个");
        queue.addLast("第四个");
        System.out.println(queue);
        // 出队
        System.out.println(queue.removeFirst());
        System.out.println(queue);

        System.out.println("-------------------");

        LinkedList<String> stack = new LinkedList<>();
        // 入栈
//        stack.addFirst("第一个");
//        stack.addFirst("第二个");
//        stack.addFirst("第三个");
//        stack.addFirst("第四个");
        stack.push("第一个");
        stack.push("第二个");
        stack.push("第三个");
        stack.push("第四个");
        System.out.println(stack);
        // 出栈
//        System.out.println(stack.removeFirst());
        System.out.println(stack.pop());
        System.out.println(stack);
        stack.add(2,"插入");
        System.out.println(stack);


    }
}
