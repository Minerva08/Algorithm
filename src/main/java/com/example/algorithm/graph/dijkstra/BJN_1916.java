package com.example.algorithm.graph.dijkstra;

import java.util.*;
public class BJN_1916 {

    static int[] dist;
    static int[] visited;

    public static class Node implements Comparable<Node> {
        int idx;
        int dist;

        public Node(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n){
            return Integer.compare(this.dist, n.dist);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cityCnt = sc.nextInt();

        dist = new int[cityCnt+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        visited = new int[cityCnt+1];

        int busCnt = sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();

        for(int i=0; i<=cityCnt; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<busCnt; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int dist = sc.nextInt();
            graph.get(start).add(new Node(end,dist));
        }


        int startCity = sc.nextInt();
        int destination =sc.nextInt();

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(startCity,0));
        dist[startCity]=0;

        while(!queue.isEmpty()){

            int curIdx = queue.poll().idx;

            if(visited[curIdx]==0){
                visited[curIdx]=1;

                for(Node next: graph.get(curIdx)){
                    if(dist[next.idx] > dist[curIdx]+next.dist){
                        dist[next.idx]= dist[curIdx]+next.dist;
                        queue.offer(new Node(next.idx, dist[next.idx]));
                    }
                }
            }

        }


        System.out.println(dist[destination]);



    }

}
