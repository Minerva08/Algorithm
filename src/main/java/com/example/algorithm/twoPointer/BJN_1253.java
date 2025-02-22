package com.example.algorithm.twoPointer;

import java.io.*;
import java.util.*;

public class BJN_1253 {

    /**
     * 투포인터 - 구간합구하기
     *
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[length];

        for(int i=0; i<length; i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(arr);

        int count = 0;


        for(int i=0; i<arr.length; i++){
            int target = arr[i];

            int start = 0;
            int end = arr.length-1;

            while(start<end ){

                if (start == i) { // 타겟 값은 제외
                    start++;
                    continue;
                }
                if (end == i) { // 타겟 값은 제외
                    end--;
                    continue;
                }

                if(arr[start]+arr[end]==target){
                    count++;
                    break;
                }
                if(arr[start]+arr[end]>target){
                    end--;
                }
                if(arr[start]+arr[end]<target){
                    start++;
                }

            }


        }

        System.out.println(count);


    }



}
