package com.example.algorithm.binarySearch;

import java.util.Arrays;

public class Immigration {

    public static void main(String[] args) {
        int[] times = new int[]{7,10};
        int people = 6;

        long solution = solution(times, people);
        System.out.println("result : "+solution);


    }

    public static long solution(int[] times, int people){

        long result = 0;
        long left = 1;


        long maxTime =  Arrays.stream(times).max().getAsInt();

        long right = ((long)people / times.length) * maxTime;



        while(left<=right){
            long mid = (left+right)/2;
            long cnt = 0;

            for(int i = 0; i<times.length; i++) {
                cnt += (mid/times[i]);
            }

            if(cnt>= (long) people){
                result = mid;
                right=mid-1;
            }else{
                left=mid+1;
            }

        }


        return result;
    }

}
