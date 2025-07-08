package com.example.algorithm.dp.t_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJN_1937 {

    // 판다
    static int size;
    static int[][] grid;
    static int[][] dp;

    static int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        grid = new int[size][size];
        dp = new int[size][size];

        for(int i=0; i<size; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                result = Math.max(result,dfs(i, j));
            }
        }

        System.out.println(result);



    }

    public static int dfs(int x, int y){

        if(dp[x][y]!=0){
            return dp[x][y];
        }

        dp[x][y] = 1;

        for (int[] dir : dirs) {
            int nextX = x+dir[0];
            int nextY = y+dir[1];

            if(nextX<0 || nextX>=size || nextY<0 || nextY>=size){
                continue;
            }
            if(grid[x][y]<grid[nextX][nextY]){
                dp[x][y] = Math.max(dfs(nextX,nextY)+1,dp[x][y]);
            }

        }

        return dp[x][y];
    }

}
