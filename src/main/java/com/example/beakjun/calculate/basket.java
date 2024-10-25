package com.example.beakjun.calculate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class basket {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int basketSize = Integer.parseInt(st.nextToken());
        int[] baskets = new int[basketSize+1];
        for(int i=1; i<=basketSize; i++){
            baskets[i]=i;
        }
        int cnt = Integer.parseInt(st.nextToken());

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // Reverse the elements between start and end
            while (start < end) {
                int temp = baskets[start];
                baskets[start] = baskets[end];
                baskets[end] = temp;
                start++;
                end--;
            }
        }

        for(int i=1; i<baskets.length;i++){
            System.out.print(String.valueOf(baskets[i])+' ');
        }


    }
}
