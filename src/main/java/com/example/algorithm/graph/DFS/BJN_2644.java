package com.example.algorithm.graph.DFS;

import java.io.*;
import java.util.*;

public class BJN_2644 {
    static int[] visited;
    static int edge = 0;
    static int node = 0;
    static int startNode = 0;
    static int endNode = 0;
    static ArrayList<ArrayList<Integer>> graph ;
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

        visited = new int[node+1];

        graph = new ArrayList<>(edge + 1);
        for (int i = 0; i <= edge; i++) {
            graph.add(new ArrayList<>());
        }


        //그래프 초기화 + 추가
        for(int i=0; i<edge; i++){
            graph.add(new ArrayList<>());

            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);

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

        for(int j : graph.get(node)){
            if(visited[j]==0){
                dfs(j,chone);
            }
        }
        System.out.println("END - "+node);
    }

}
