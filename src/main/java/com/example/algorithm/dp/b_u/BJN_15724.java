package com.example.algorithm.dp.b_u;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJN_15724 {

    static int[][] memo;
    static int[][] grid;

    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        memo = new int[n][m];

        for(int i=0; i<n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++){
                grid[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int tryCnt = Integer.parseInt(st.nextToken());
        result = new int[tryCnt];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1]
                    - memo[i - 1][j - 1] + grid[i][j];
            }
        }


        for(int i=0; i<tryCnt; i++){
            int startX = Integer.parseInt(st.nextToken())-1;
            int startY = Integer.parseInt(st.nextToken())-1;
            int endX = Integer.parseInt(st.nextToken())-1;
            int endY = Integer.parseInt(st.nextToken())-1;

            result[i]  =  memo[endX][endY] - memo[startX - 1][endY]
                - memo[endX][startY - 1] + memo[startX - 1][startY - 1];

        }

        for (int i : result) {
            System.out.println(i);
        }

    }


}
