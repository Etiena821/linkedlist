package com.linkedlist;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        list.reverse();
        System.out.println(list.size());


        System.out.println(list.getKthFromTheLast(4));
        System.out.println(Arrays.toString(list.toArray()));


    }
}
