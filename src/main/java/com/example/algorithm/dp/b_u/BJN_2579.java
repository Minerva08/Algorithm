package com.example.algorithm.dp.b_u;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJN_2579 {

    /**
     *
     * 입력
     * 6
     * 10
     * 20
     * 15
     * 25
     * 10
     * 20
     *
     *
     *
     * 로직
     *    BottomUP
     *    계단 이동 방향 : 1칸 이동, 2칸 이동
     *    목적 : 시작 -> 도착 수의 누적합 최대값
     *    단, 연속 3칸 불가
     *       -> (전) 2칸 + 현재 + (후)1칸/2칸
     *       -> (전) 1칸 + 현재 + (후) 2칸
     *
     *    메모제이션 dp
     *    int[][] dp = new int[n+1][2]
     *    추적 변수: 계단 위치 / 이동 기저 상태(1칸 이동:1, 2칸 이동:0)
     *
     *    ⭐️초기값
     *      1칸 = dp[1][0] = stair[1]
     *      2칸 = dp[1][1] = 0
     *      -----------------------------
     *      1+1 칸 = dp[2][1] = stair[1]+stair[2]
     *      2칸 = dp[2][0] = stair[2];
     *
     * 결과
     *
     *
     * */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        int[] steps = new int[size+1];
        for(int i=1; i<=size;i++){
            st = new StringTokenizer(br.readLine());
            steps[i]=Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[size+1][2];
        for(int i=0; i<=size;i++){
            dp[i]=new int[2];
        }
        if(size>=1){
            dp[1][0] = 0;
            dp[1][1] = steps[1];
        }

        if(size>=2){
            dp[2][0] = steps[2];
            dp[2][1] = steps[1]+steps[2];
        }

        int now=3;
        while(now<size){


            dp[now][1] = dp[now-1][0]+steps[now];

            dp[now][0] = Math.max(dp[now-2][0]+steps[now], dp[now-1][1]+steps[now]);



        }


    }

}
