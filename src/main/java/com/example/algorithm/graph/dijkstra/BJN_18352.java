package com.example.algorithm.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJN_18352 {

    public static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int start, int cost) {
            this.index = start;
            this.cost = cost;
        }

        @Override
        public int compareTo (Node node) {
            return Integer.compare(this.cost, node.cost);
        }
    }

    static ArrayList<ArrayList<Node>> graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        int INF = Integer.MAX_VALUE;

        boolean[] visited = new boolean[node+1];// 방문 여부

        int[] dist = new int[node+1];
        Arrays.fill(dist, INF);  // 모든 거리를 무한대로 초기화

        dist[start]=0;

        graph = new ArrayList<>(node+1);
        for(int i=0; i<=node; i++){
            graph.add(new ArrayList<>());

        }


        for(int i=0;i<edge; i++){
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()),1));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));


        while (!pq.isEmpty()) {
            int nowVertex = pq.poll().index;

            if (visited[nowVertex]) continue;  // 이미 방문한 정점이면 넘어감
            visited[nowVertex] = true;  // 방문 처리

            // 현재 정점과 연결된 정점들 탐색
            for (Node next : graph.get(nowVertex)) {
                if (dist[next.index] > dist[nowVertex] + next.cost) {
                    dist[next.index] = dist[nowVertex] + next.cost;  // 거리 업데이트
                    pq.offer(new Node(next.index, dist[next.index]));  // 우선순위 큐에 추가
                }
            }

        }

        int cnt = 0;


        for (int i=0;i<=node; i++) {
            if(dist[i]==k){
                System.out.println(i);
                cnt++;
            }else if(i==node&&cnt==0){
                System.out.println(-1);
            }
        }



    }
}
