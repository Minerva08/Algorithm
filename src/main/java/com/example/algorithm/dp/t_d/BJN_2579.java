package com.example.algorithm.dp.t_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJN_2579 {
    static int[] steps;
    static int stepCnt;

    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        stepCnt = Integer.parseInt(st.nextToken());
        steps = new int[stepCnt+1];

        for(int i=1; i<=stepCnt; i++){
            st = new StringTokenizer(br.readLine());
            steps[i] = Integer.parseInt(st.nextToken());

        }
        memo = new int[stepCnt+1][2];

        for(int i=0; i<=stepCnt; i++){
            memo[i]=new int[2];
        }

        dfs(0, 0,0);





    }

    public static int dfs(int now,int jumpCnt, int sequenceCnt){
        if(sequenceCnt==3 || now>sequenceCnt){
            return memo[jumpCnt-1][1];
        }

        if(memo[jumpCnt][1]!=0){

            int jumpNextStep = jumpCnt+1;

            return memo[jumpNextStep][1] = Math.max(memo[jumpCnt][1] + dfs(now+1,jumpCnt+1,sequenceCnt+1),memo[jumpCnt][1] + dfs(now+2,jumpCnt+1,0));


        }

        return memo[jumpCnt][1]=dfs(now+1,jumpCnt+1,sequenceCnt+1);


    }


}
