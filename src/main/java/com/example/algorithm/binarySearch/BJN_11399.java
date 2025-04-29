package com.example.algorithm.binarySearch;


import java.util.*;

public class BJN_11399 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr =  new int[n];

        for(int i=0; i<n;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int time = 0;
        int sum=0;
        for(int i=0; i<n; i++){
            time+=arr[i];
            sum += time;
        }

        System.out.println(sum);



    }

}
