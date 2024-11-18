package com.example.algorithm.BruteForce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;


public class P_math_test2 {

    static int[] first = {1,2,3,4,5};
    static int[] second = {2,1,2,3,4,2,5};
    static int[] third = {3,3,1,1,2,2,4,4,5,5};
    

    public static void main(String[] args) {

        int[] result = solution(new int[]{1,3,2,4,2});
        Arrays.stream(result).forEach(System.out::print);

    }



    public static int[] solution(int[] answers) {

        int firstCnt = 0;
        int secondCnt = 0;
        int thirdCnt = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % first.length])
                firstCnt++;
            if (answers[i] == second[i % second.length])
                secondCnt++;
            if (answers[i] == third[i % third.length])
                thirdCnt++;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,firstCnt);
        map.put(2,secondCnt);
        map.put(3,thirdCnt);

       int maxPoint = map.entrySet().stream().mapToInt(Entry::getValue).max().getAsInt();
       return map.entrySet().stream().filter(e -> e.getValue()==maxPoint).mapToInt(Entry::getKey).toArray();

    }
}
