package com.example.algorithm.recursive;

public class Recursive {

    public static void main(String[] args){
        recursive(6);
    }

    public static void recursive(int n){
        // 재귀 함수 종료 조건
        if(n==0) return;

        recursive(n-1);
        System.out.println(n);
    }
}
