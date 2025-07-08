package com.example.algorithm.dp.t_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJN_1937_2 {

    /**
     * 입력
     *
     * 4
     * 14 9 12 10
     * 1 11 5 4
     * 7 15 2 13
     * 6 3 16 8
     *
     *
     * 로직
     *   움직일수 있는 최대 경로 비용
     *
     *   조건: 비용이 큰 위치로만 이동 가능
     *   시작점, 도착점 지정 X -> 모든 경우 탐색 (Dfs+TopDown)
     *   이동 방향 : 상,하,좌,우
     *
     *
     *   메모제이션
     *   int[][]  dp
     *   -> x,y 위치 / 위치별 비용
     *   -> dp[다음위치] = max(dp[다음위치],dp[현위치]+이동위치)
     *
     * 결과
     *   메모제이션 최대값
     *
     *
     *
     *
     * */



    static int size;
    static int[][] grid;
    static int[][] dp;
    static int result;

    static int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    // 판다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        grid = new int[size][size];
        dp = new int[size][size];

        for(int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
              result= Math.max(result ,dfs(i,j));
            }
        }
        System.out.println(result);

    }


    public static int dfs(int nowX, int nowY){

        if(dp[nowX][nowY]!=0){
            return dp[nowX][nowY];
        }

        for (int[] dir : dirs) {
           int nextX =  dir[0]+nowX;
           int nextY = dir[1]+nowY;

           if(nextX<0 || nextX>=size || nextY<0 || nextY>=size){
               continue;
           }
            if(grid[nowX][nowY]<grid[nextX][nextY]){
                dp[nowX][nowY] = Math.max(dfs(nextX,nextY)+1,dp[nowX][nowY]);
            }
        }

        return dp[nowX][nowY];


    }


}
