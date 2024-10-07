package com.example.algorithm;

import java.util.*;

public class Min_Max {

    public static void main(String[] args) {
        String result = solution(" 1 3 -2 5");
        System.out.printf("result : "+result);
    }

    static String solution(String s) {

        String[] parts = s.trim().split("\\s+");

        int[] intArr = Arrays.stream(parts)
            .mapToInt(Integer::parseInt)
            .toArray();

//        int[] intArr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        OptionalInt max = Arrays.stream(intArr).max();
        OptionalInt min = Arrays.stream(intArr).min();


        StringBuilder sb = new StringBuilder().append(min.getAsInt()).append(" ").append(max.getAsInt());
        return sb.toString();
    }

}
