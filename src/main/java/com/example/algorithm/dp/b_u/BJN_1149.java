package com.example.algorithm.dp.b_u;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJN_1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] cost = new int[n][3];
        int[][] dp = new int[n][3];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for(int j=1; j<n; j++){
            dp[j][0] = Math.min(dp[j-1][1],dp[j-1][2])+cost[j][0];
            dp[j][1] = Math.min(dp[j-1][0],dp[j-1][2])+cost[j][1];
            dp[j][2] = Math.min(dp[j-1][0],dp[j-1][1])+cost[j][2];
        }

        int result = Math.min(Math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]);
        System.out.println(result);


    }

}
