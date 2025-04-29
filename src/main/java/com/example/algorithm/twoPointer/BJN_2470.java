package com.example.algorithm.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJN_2470 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int size = Integer.parseInt(st.nextToken());
        int[] arr = new int[size];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        int left = 0;
        int right = size-1;
        int result = Integer.MAX_VALUE;

        int liquid1 = 0;
        int liquid2 = 0;

        while(left<right){

            int temp = (arr[left]+arr[right]);

            if(temp>0){
                if(result>temp){
                    result=temp;
                    liquid1 = Math.min(arr[left],arr[right]);
                    liquid2 = Math.max(arr[left],arr[right]);
                }
                right -= 1;

            }

            if(temp<=0){

                temp*=-1;

                if(result>temp){
                    result=temp;
                    liquid1 = Math.min(arr[left],arr[right]);
                    liquid2 = Math.max(arr[left],arr[right]);
                }
                left +=1;

            }

        }

        System.out.println(liquid1+" "+ liquid2);
    }

}
