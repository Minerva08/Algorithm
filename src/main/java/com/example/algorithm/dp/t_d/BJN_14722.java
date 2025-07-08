package com.example.algorithm.dp.t_d;

import java.io.*;
import java.util.*;

public class BJN_14722 {
    /**
     * 입력
     * 4
     * 0 1 2 2
     * 1 1 1 1
     * 2 2 2 2
     * 0 0 1 0
     *
     *
     * 로직
     *    Top-Down(dfs)-> 최대 마실수 있는 우유 개수(최종 결과 중요)
     *    조건1. 우유 마시는 순서 : 딸기(0) -> 초코(1) -> 바나나(2) 로테이션
     *    조건2. 영학이가 우유를 미신다 / 마시지 않는다
     *
     *    int[][][] dp = new int[n+1][n+1][3]
     *    0 set
     *    추적 상태 : 마신 우유종류, 위치, 마신 우유 개수
     *
     *    초기화
     *        딸기우유 마심 O-> dp[1][1][0] = 1;
     *        딸기우유 마심 X -> dp[1][1][0] = 0
     *
     *    int drinkCnt = dfs(int nowX,int nowY, int milkCnt)
     *
     *
     *
     * 결과
     *
     *
     *
     * */

    static int n;
    static int[][] grid;
    static int[][][] dp;
    static int[][] dirs = new int[][]{{1,0},{0,1}}; // 남/동 이동방향


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];

        dp = new int[n][n][3];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], -1); // 초기화: 아직 탐색 안함
            }
        }

        if(grid[0][0]==0){
            int result = dfs(0,0,0);
            System.out.println(result);

        }


    }

    public static int dfs(int x, int y, int milkType){
        // 0->1
        // 1->2
        // 2->0


        if(dp[x][y][milkType]!=0){
            return dp[x][y][milkType];
        }


        int max = 0;

        // 현재 우유 마실 수 있는 경우
        if (grid[x][y] == milkType) {
            int nextMilk = (milkType + 1) % 3;
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                max = Math.max(max, dfs(nx, ny, nextMilk) + 1); // 마시고 다음
            }
        }

        // 마시지 않는 경우 (그대로 유지)
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            max = Math.max(max, dfs(nx, ny, milkType));
        }

        return dp[x][y][milkType];
    }

}
