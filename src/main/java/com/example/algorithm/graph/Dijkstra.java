package com.example.algorithm.graph;

import java.util.*;

public class Dijkstra {

    public static void main(String[] arg){
        int[][] road = {{1,4,2},{1,2,1},{2,3,3},{5,2,2},{5,3,1},{5,4,1}};
        int result = solution(5, road, 3);
        System.out.println("정점수 : "+result);
    }


    public static int solution(int N, int[][] road, int K) {
        int answer=0;

         class Node implements Comparable<Node>{
            int index;
            int cost;

            public Node(int index, int cost){
                this.index = index;
                this.cost=cost;
            }

            @Override
            public int compareTo(Node node){
                return Integer.compare(this.cost,node.cost);
            }
        }

        ArrayList<Node>[] graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();  // 각 정점에 대해 ArrayList 초기화
        }

        // Build the graph from the road data
        for (int[] r : road) {
            int from = r[0];  // 출발지
            int to = r[1];    // 목적지
            int weight = r[2]; // 거리(가중치)

            // Add both directions since this is an undirected graph
            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        boolean[] check = new boolean[N+1];  // 방문 여부
        int[] dist = new int[N+1];  // 최소 거리 배열
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);  // 모든 거리를 무한대로 초기화
        dist[1] = 0;  // 시작점(1번 정점) 거리 0으로 초기화

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));  // 시작점 1번에서 출발

        while (!pq.isEmpty()) {
            int nowVertex = pq.poll().index;

            if (check[nowVertex]) continue;  // 이미 방문한 정점이면 넘어감
            check[nowVertex] = true;  // 방문 처리

            // 현재 정점과 연결된 정점들 탐색
            for (Node next : graph[nowVertex]) {
                if (dist[next.index] > dist[nowVertex] + next.cost) {
                    dist[next.index] = dist[nowVertex] + next.cost;  // 거리 업데이트
                    pq.offer(new Node(next.index, dist[next.index]));  // 우선순위 큐에 추가
                }
            }
        }

        // 최소거리 출력
        for (int i = 1; i <= N; i++) {  // dist[1]부터 출력
            if (dist[i] <= K) {
                answer++;  // 도달할 수 없는 경우 0 출력
            }
        }

        return answer;
    }

}
