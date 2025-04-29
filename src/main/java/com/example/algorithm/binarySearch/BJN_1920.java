package com.example.algorithm.binarySearch;

import java.util.*;
import java.io.*;

public class BJN_1920 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br. readLine());

        int size_a = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        long[] arr_a = new long[size_a];

        for(int i=0; i<size_a; i++){
            arr_a[i] = Long.parseLong(st.nextToken());

        }
        Arrays.sort(arr_a);

        st = new StringTokenizer(br.readLine());

        int size_b = Integer.parseInt(st.nextToken());

        long[] arr_b = new long[size_b];
        st = new StringTokenizer(br.readLine());


        for (int i=0; i<size_b; i++){

            arr_b[i] = binarySearch(arr_a,Long.parseLong(st.nextToken()));
        }

        Arrays.stream(arr_b).forEach(System.out::println);



    }

    public static int binarySearch(long[] arr,long target){
        long left = 0;
        long right = arr.length-1;

        while(left<=right) {
            long mid = (left + right) / 2;
            if (target > arr[(int) mid]) {
                left = mid+1;
            }else if(target==arr[(int) mid]){
                return 1;
            }else{
                right = mid-1;
            }
        }

        return 0;
    }

}
