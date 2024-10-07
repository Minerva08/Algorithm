package com.example.algorithm;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {4,7,2,8,3,3,5};

        int left=0;
        int right=arr.length;
        int target = 5;

        int result = binary(arr, left, right, target);
        System.out.println("Target : "+target);
        System.out.println(result+"번째 : "+arr[result]);

    }

    public static int binary(int[] arr, int left, int right, int target){
        Arrays.sort(arr);

        int mid = (left+right)/2;

        if(left > right){
            return -1;
        }

        if(arr[mid] == target){
            return mid;
        }

        if(arr[mid] > target){
            right=mid-1;
            return binary(arr,left,right,target);
        }else{
            left=mid+1;
            return binary(arr,left,right,target);
        }
    }

}
