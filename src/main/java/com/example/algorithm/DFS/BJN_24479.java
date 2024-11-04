package com.example.algorithm.DFS;

import java.io.*;
import java.util.*;

public class BJN_24479 {
    static int[] visited;
    static int edge = 0;
    static int node = 0;
    static int startNode = 0;
    static int[][] graph;
    static int step = 1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        edge = Integer.parseInt(st.nextToken());
        node = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());

        graph = new int[edge+1][edge+1];
        visited = new int[edge+1];

        for(int i=0; i<node; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j=1; j<=node; j++){
                graph[start][end] = 1;
                graph[end][start] = 1;
            }
        }

        dfs(startNode);

        for(int i = 1; i<=edge; i++){
            System.out.println(visited[i]);

        }

    }

    public static void dfs(int i){
        visited[i]=step;
        step++;

        for(int j=1; j<=edge; j++){
            if(visited[j]==0 && graph[i][j]==1){
                dfs(j);
            }
        }

    }

}
