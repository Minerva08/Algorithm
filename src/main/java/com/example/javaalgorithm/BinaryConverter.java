package com.example.javaalgorithm;

import java.util.*;

public class BinaryConverter {
    public static void main(String[] args) {
        int[] result = solution("110010101001");
        for (int i : result) {
            System.out.println("result : "+i);
        }

    }

    static int[] solution(String s) {
        //   s = Integer.toBinaryString(temp);
        int cnt = 0;
        int removeZero=0;
        int[] result = new int[2];

        while (s.length()>1){
            int orgStrSize = s.length();
            s=s.replace("0","");
            int sSize = s.length();
            removeZero += (orgStrSize - sSize);
            List<Integer> binary = new ArrayList<>();

            while(sSize>0){
                binary.add(sSize%2);
                sSize/=2;

            }
            Collections.reverse(binary);
            StringBuilder sb = new StringBuilder();
            for (int bit : binary) {
                sb.append(bit);
            }
            s = sb.toString();
            cnt++;

        }
        result[0]=cnt;
        result[1]=removeZero;

        return result;

    }
}
