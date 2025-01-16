package com.example.algorithm.Greedy;

import java.util.*;
import java.io.*;


public class BJN_27961 {
    // 목표 고양이 수를 만족 하는 최소 횟수 구하기
    // n = 고양이 수

    // 방법1 : 생성(단 한마리)
    // 방법2 : 복제(최대 전체 고양이 수)


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 생성 횟수
        int createCnt = 0;

        // 복제 횟수
        int copyCnt = 0;

        //목표 고양이 마리수
        long catCnt = Long.parseLong(st.nextToken());

        long nowCnt = 0L;
        createCnt++;
        nowCnt++;
        if(catCnt==0){
            System.out.println(0);
            return;
        }

        while(nowCnt<catCnt){
             nowCnt*=2;
             copyCnt++;
        }

        System.out.println("최소 만족 횟수 : "+(copyCnt+createCnt));

    }



}
