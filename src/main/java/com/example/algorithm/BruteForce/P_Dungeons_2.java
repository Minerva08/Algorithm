package com.example.algorithm.BruteForce;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P_Dungeons_2 {

    /**
     * 완전탐색 = dfs
     *
     * 1. 모든 경우의 수 탐색 - dfs
     * 2. 조건에 맞지 않는 경우 소거
     * */

    static int steps=0;

    static int dungeonsCnt;

    public static void main(String[] args) {

        int result = solution( 80,new int[][]{{80,20},{50,40},{30,10}});
        System.out.print("결과 : "+result);

    }


    public static int solution(int k, int[][] dungeons) {

        dungeonsCnt = dungeons.length;


        for(int i=0; i<dungeonsCnt; i++){

            int[] visited = new int[dungeonsCnt];
            int cnt = 0;
            int p = k;

            dfs(dungeons,i,visited,cnt,p);
        }


        return steps;

    }

    public static void dfs(int[][] dungeons, int i,int[] visited, int cnt, int p){
        if(cnt>dungeonsCnt){
            return;
        }

        if(dungeons[i][0]<=p && dungeons[i][1]<=p){
            visited[i] = 1;
            p-=dungeons[i][1];
            cnt ++;

            if(Integer.compare(cnt,steps)==1){
                steps = cnt;
            };

            for(int j=0; j<dungeons.length; j++){
                if(visited[j]==1){
                    continue;
                }

                if(p>=dungeons[j][0] && p>=dungeons[j][1]){

                    dfs(dungeons,j,visited,cnt, p);


                }

            }
            visited[i]=0;

        }


    }

}
