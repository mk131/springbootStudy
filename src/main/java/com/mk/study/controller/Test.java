package com.mk.study.controller;

/**
 * @author mk
 */
public class Test {
    public static void main(String[] args) {

        String s = test2(10);


    }

    public static String test2(int a) {
        if (a == 1) {
            return "0";
        } else {
            a=a-1;
            test2(a);
            System.out.println("1");
        }

        return "0";

    }


}
