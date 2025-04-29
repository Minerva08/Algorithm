package com.example.algorithm.graph.dijkstra;

import java.util.*;
import java.io.*;

public class BJN_1504 {

    public static class Node implements Comparable<Node>{

        int index;
        int cost;

        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node){
            return Integer.compare(this.cost, node.cost);
        }
    }

    static int nodeCnt;
    static int edgeCnt;
    static ArrayList<ArrayList<Node>> graph;
    static int[] visited;


    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nodeCnt = Integer.parseInt(st.nextToken());
        edgeCnt =  Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for(int i=0; i<=nodeCnt ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<edgeCnt; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end,cost));
            graph.get(end).add(new Node(start, cost));
        }


        st = new StringTokenizer(br.readLine());

        int newStartNode1 = Integer.parseInt(st.nextToken());
        int newStartNode2 = Integer.parseInt(st.nextToken());


        int[] dist = new int[nodeCnt+1];
        visited=new int[nodeCnt+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int sum = 0;

        int[] shortest =dijkstra(new PriorityQueue<>(),dist,1);

        int[] steps = new int[3];
        if(shortest[newStartNode1]>=shortest[newStartNode2]){
            steps[0]=newStartNode2;
            steps[1]=newStartNode1;
            steps[2] = nodeCnt;
        }else{
            steps[0]=newStartNode1;
            steps[1]=newStartNode2;
            steps[2] = nodeCnt;
        }


        sum+=shortest[steps[0]];

        for(int i=0; i<steps.length-1; i++){
            visited=new int[nodeCnt+1];
            int[] fastest = dijkstra(new PriorityQueue<>(),new int[nodeCnt+1],steps[i]);

            sum+=fastest[steps[i+1]];


        }

        System.out.println(sum==0?-1:sum);

    }


    public static int[] dijkstra(PriorityQueue<Node> pq, int[] dist, int start){

        pq.offer(new Node(start,0));
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;

        while(!pq.isEmpty()){
            int cur = pq.poll().index;

            if(visited[cur]==1){
                continue;
            }
            visited[cur]=1;

            for(Node next : graph.get(cur)){
                if(dist[next.index] > dist[cur]+next.cost){
                    dist[next.index] = dist[cur]+next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }

            }
        }

        return dist;

    }
}
