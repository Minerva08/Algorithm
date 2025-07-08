package com.example.algorithm.dp.b_u;

import java.io.*;
import java.util.*;

public class BJN_17485 {

    /**
     * 입력
     * 6 4
     * 5 8 5 1
     * 3 5 8 4
     * 9 77 65 5
     * 2 1 5 2
     * 5 98 1 5
     * 4 95 67 58
     *
     *
     * 로직
     *    지구 -> 달 까지  이동 최소 비용
     *    탐색 방향이 일정 : 위-> 아래
     *    현 위치에서 이동 가능한 방향 : 왼쪽 대각선 아래, 아래, 오른쪽 대각선 아래
     *    -> 모든 방향 아님
     *    So Bottom-up -> 작은 경우부터 전체로 순회
     *
     *    int[][][] dp = new int[n][m][3]
     *    추적 상태 : x위치, y위치, 이동 방향, 이동 비용
     *
     *    for x축 1부터 시작 -> 0은 이전 방향이 없으므로
     *      for y축
     *         for 방향들
     *         ---> ⭐️점화식 : 현재위치로 오는 경우 HOW (최소 단위)
     *                 현재 : 이전 위치 비용 + ( 왼쪽 아래/아래/오론쪽 아래 이동 )+  현재 위치 비용
     *
     *
     * 결과
     *
     *
     *
     * */

    static int n,m;

    // x축 위치,  y축 위치, 이동 방향 상태 메모제이션
    static int[][][] dp;

    // 위치 별 이동 비용 저장
    static int[][] grid;

    // 이동 방향
    // 0: 왼쪽 대각선 아래
    // 1: 아래
    // 2: 오른쪽 대각선 아래
    static int[] dirs = new int[]{-1,0,1};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int boundY = m - 1;

        grid = new int[n][m];
        dp = new int[n][m][3];

        for(int i=0; i<n;  i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n;  i++){
            for(int j=0; j<m; j++){
                Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }

        for (int j = 0; j < m; j++) {
            for (int d = 0; d < 3; d++) {
                dp[0][j][d] = grid[0][j];
            }
        }



        //dp 시작
        // 첫번째 행이 모든 열에서 시작 가능
        // 이동 방향 dirs : 외쪽 대각선 아래, 아래, 오른쪽 대각선 아래

        //점화식 : 현위치 = 이전위치(비용,기저방향) + 왼쪽/아래/오른쪽(단 이전 위치의 이동방향과 동일X)
        //초기화 : 첫번째 행 비용 == grid
        //초기화 : 첫번째 행 기저 방향 == 0

        // 단 이전의 이동 방향 중복 불가 -> 선택한 이동 방향 dp 저장
        // 최소 이동 비용으로 dp update

        for(int i=1; i<n; i++){
            for(int j=0; j<m;  j++){//현재
                int prevX=i-1, prevY;//과거
                for (int prev=0;prev<3; prev++) {
                    prevY = j-dirs[prev];

                    if(prevY<0 || prevY>boundY){
                        continue;
                    }

                    for(int cur=0; cur<3;cur++){
                        if( prev == cur) continue;

                        dp[i][j][cur] = Math.min(dp[i][j][cur], dp[prevX][prevY][prev] + grid[i][j]);


                    }


                }

            }
        }


        int result = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            for (int dir = 0; dir < 3; dir++) {
                result = Math.min(result, dp[n-1][j][dir]);
            }
        }

        System.out.println(result);


    }

}
