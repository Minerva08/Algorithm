package com.example.algorithm.binarySearch.boud;

import java.util.*;
import java.io.*;

public class BJN_10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int originSize = Integer.parseInt(st.nextToken());
        int[] originArr = new int[originSize];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<originSize; i++){
            originArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        int findCnt = Integer.parseInt(st.nextToken());
        int[] result = new int[findCnt];
        st = new StringTokenizer(br.readLine());

        Arrays.sort(originArr);


        for(int i=0; i<findCnt; i++){
            int target = Integer.parseInt(st.nextToken());
            int start = lowerBound(originArr, target);
            int end =  upperBound(originArr,target );
            result[i] = (end-start);
        }

        Arrays.stream(result).forEach(e->{System.out.print(e+" ");});

    }

    public static int lowerBound(int[] arr, int target ){
        int left = 0;
        int right = arr.length;

        while(left<right){
            long mid = (left+right)/2;
            if(arr[(int)mid]>=target){
                right = (int) mid;

            }else{
                left = (int)mid+1;
            }
        }

        return left;
    }

    public static int upperBound(int[] arr, int target){
        int left = 0;
        int right = arr.length;

        while(left<right){
            long mid = (left+right)/2;
            if(arr[(int)mid]>target){
                right = (int) mid;

            }else{
                left = (int)mid+1;
            }
        }

        return left;
    }

}
