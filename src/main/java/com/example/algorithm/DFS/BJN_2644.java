package com.example.algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJN_2644 {
    static int[] visited;
    static int edge = 0;
    static int node = 0;
    static int startNode = 0;
    static int endNode = 0;
    static int[][] graph ;
    static int step = -1;


    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        node = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        startNode = Integer.parseInt(st.nextToken());
        endNode = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        edge = Integer.parseInt(st.nextToken());

        graph = new int[node+1][node+1];
        visited = new int[node+1];


        for(int i=0; i<edge; i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1][node2] = 1;
            graph[node2][node1] = 1;

        }

        dfs(startNode,0);

        System.out.println(step);


    }

    public static void dfs(int node, int chone){
        System.out.println("dfs: "+node+" , "+chone);
        visited[node]=1;

        if(node==endNode){
            System.out.println("endNode : "+node);
            step = chone;
            return;
        }

        for(int j=0; j<graph[node].length;j++){
            if(graph[node][j]==1 && visited[j]!=1){
                System.out.println("for: "+node+" , "+j);
                dfs(j,chone+1);
            }

        }
    }

}
