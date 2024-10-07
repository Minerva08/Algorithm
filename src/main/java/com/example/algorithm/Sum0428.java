package com.example.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class Sum0428 {
    public static void main(String[] args) {
        int result = solution(new int[]{5, 6, 7, 8, 9, 0});
        System.out.println(result);
    }

    static int solution(int[] numbers) {
        int[] numberArr = new int[]{0,1,2,3,4,5,6,7,8,9};
        List<Integer> boundList =  new ArrayList<>(Arrays.stream(numberArr)
                .boxed()
                .collect(Collectors.toList()));

        for(int i=0; i<numbers.length;i++){
            if(boundList.contains(numbers[i])){
                boundList.set(numbers[i],0);
            }
        }
        return boundList.stream().collect(Collectors.summingInt(Integer::intValue)).intValue();
    }
}
