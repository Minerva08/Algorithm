package com.example.algorithm.graph.dijkstra;

import java.io.*;
import java.util.*;

public class BJN_2211 {

    /**
     * 컴퓨터간 통신 최단거리
     */

    static int computer;
    static int connection;

    public static class Node implements Comparable<Node> {

        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.cost, node.cost);
        }


    }

    static ArrayList<ArrayList<Node>> graph;


    public static void main(String[] arg) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        computer = Integer.parseInt(st.nextToken());
        connection = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(computer + 1);

        for (int i = 0; i <= (computer); i++) {
            graph.add(new ArrayList<>());

        }

        for (int i = 0; i < connection; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));

        }

        boolean[] visited = new boolean[computer + 1];  // 방문 여부

        int[] dist = new int[computer + 1];  // 최소 거리 배열
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);  // 모든 거리를 무한대로 초기화
        dist[1] = 0;  // 시작점(1번 정점) 거리 0으로 초기화

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        int[] parent = new int[computer+1];

        while (!pq.isEmpty()) {
            int nowVertex = pq.poll().index;

            if (visited[nowVertex]) {
                continue;  // 이미 방문한 정점이면 넘어감
            }
            visited[nowVertex] = true;  // 방문 처리

            // 현재 정점과 연결된 정점들 탐색
            for (Node next : graph.get(nowVertex)) {
                if (dist[next.index] > dist[nowVertex] + next.cost) {
                    dist[next.index] = dist[nowVertex] + next.cost;  // 거리 업데이트
                    parent[next.index] = nowVertex;

                    pq.offer(new Node(next.index, dist[next.index]));  // 우선순위 큐에 추가
                }
            }

        }

        ArrayList<String> result = new ArrayList<>();

        for(int i=2; i<parent.length;i++){
            if(parent[i]!=0){
                result.add(i+" "+parent[i]);

            }
        }
        System.out.println(result.size());
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }


    }

}
