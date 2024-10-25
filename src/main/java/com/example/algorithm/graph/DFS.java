package com.example.algorithm.graph;

import java.util.*;

public class DFS {

    static boolean[] visited;
    static int answer=0;
    static int n = 7;
    static int[][] graph = new int[n+1][n+1];

    public static void main(String[] args){

        int[][] network = {{1,2},{2,3},{1,5},{5,2},{5,6},{4,7}};
        int result = solution(network,n);
        System.out.println("result= "+result);

    }

    public static int solution(int[][] network, int n){
        for (int[] computer : network) {
            graph[computer[0]][computer[1]]=1;
            graph[computer[1]][computer[0]]=1;
        }
        visited = new boolean[n+1];
        Arrays.fill(visited,false);

        dfs(1);

        return (answer-1);
    }

    public static void dfs(int idx){
        visited[idx] = true;
        answer++;

        for(int i=1; i<=n; i++){
            if(!visited[i] && graph[idx][i]==1){
                dfs(i);
            }
        }

    }
}
