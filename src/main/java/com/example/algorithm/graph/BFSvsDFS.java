package com.example.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFSvsDFS {

    static int[] dfsVisited;
    static int[] bfsVisited;
    static int edge = 0;
    static int node = 0;
    static int startNode = 0;
    static int endNode = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> bfsQueue = new LinkedList<>();
    static int step = 0;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());

        dfsVisited = new int[node+1];
        bfsVisited = new int[node+1];

        graph = new ArrayList<>(edge+1);
        for (int i = 0; i <edge; i++) {
            graph.add(new ArrayList<>());
        }

        //그래프 초기화 + 추가
        for(int i=0; i<edge; i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);

        }


        dfs(startNode);

        for(int i=0; i<dfsVisited.length;i++ ){
            if (dfsVisited[i] != 0) {
                System.out.print(dfsVisited[i] +" ");
            }
        }

        step=0;
        bfsQueue.add(startNode);

        while(!bfsQueue.isEmpty()){
            bfs(bfsQueue.poll());

        }

        for(int i=0; i<bfsVisited.length;i++ ){
            if (bfsVisited[i] != 0) {
                System.out.print(bfsVisited[i] +" ");
            }
        }



    }

    public static void dfs(int startNode){
        step++;

        dfsVisited[startNode] = step;

        for(int i=0; i<graph.get(startNode).size();i++){
            if(dfsVisited[graph.get(startNode).get(i)]==0){
                dfs(graph.get(startNode).get(i));
            }
        }

    }

    public static void bfs(int startNode){
        if(bfsVisited[startNode]==0){
            step++;
            bfsVisited[startNode] = step;
        }

        for(int i=0; i<graph.get(startNode).size();i++){
            if(bfsVisited[graph.get(startNode).get(i)]==0){
                bfsQueue.add(graph.get(startNode).get(i));
            }
        }

    }

}
