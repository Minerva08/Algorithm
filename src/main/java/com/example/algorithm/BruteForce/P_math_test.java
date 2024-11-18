package com.example.algorithm.BruteForce;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;


public class P_math_test {

    static int[] first = {1,2,3,4,5};
    static int[] second = {2,1,2,3,4,2,5};
    static int[] third = {3,3,1,1,2,2,4,4,5,5};


    public static void main(String[] args) {

        int[] result = solution(new int[]{1,3,2,4,2});
        Arrays.stream(result).forEach(System.out::print);

    }



    public static int[] solution(int[] answers) {
        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % first.length]) scores[0]++;
            if (answers[i] == second[i % second.length]) scores[1]++;
            if (answers[i] == third[i % third.length]) scores[2]++;
        }

        int maxValue = Arrays.stream(scores).max().orElse(0);

        return IntStream.range(0, scores.length)
            .filter(i -> scores[i] == maxValue)
            .map(i -> i + 1)
            .toArray();

    }
}
