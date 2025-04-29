package com.example.algorithm.twoPointer;

import java.util.*;
public class BJN_2559 {

    /**
     *
     * k일 동안 온도 합의 최대값
     *
     * 1. 입력
     *    10 2
     *    3 -2 -4 -9 0 3 7 13 8 -3
     *
     * 2. 로직
     *      int sum =0;
     *
     *      for(int end =0; end<n; end++){
     *          sum+=arr[end];
     *          while(start < end){
     *              if(end>start+2){
     *                  sum-=arr[start];
     *                  start++;
     *              }
     *          }
     *      }
     * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int k = sc.nextInt();
        int[] degrees = new int[size];


        for(int i = 0; i < size; i++){
            degrees[i] = sc.nextInt();
        }

        long sum =0;
        int start = 0;
        long sumMax = Long.MIN_VALUE;


        for (int end = 0; end < size; end++) {
            sum += degrees[end];  // end 인덱스를 추가
            while ((end - start + 1 )> k) {
                sum -= degrees[start];  // start 인덱스를 빼기
                start++;
            }
            if ((end - start )== (k-1)) {
                sumMax = Math.max(sumMax, sum);  // k일 동안의 합을 구하고 최대값 갱신
            }
        }

        System.out.println(sumMax);
    }
}
