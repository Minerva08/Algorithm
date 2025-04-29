package com.example.algorithm.graph.dijkstra;

import java.util.*;
import java.io.*;
public class BJN_17270 {
    /**
     * 다익스트라
     *
     * 1. 성하-> 지헌, 성하<-지헌의 각 최단 경로 구하기
     * 2. 각 최단 경로에 포함 되는 중간 지점 구하기
     * 3. 지헌이 먼저 도착 하거나 지헌과 성하가 동시에 도착 할 수 있는 지점 (※ 지헌이 성하 보다 늦는 경우 제외)
     * 4. 만약 여러 지점이 있다면 지헌이에게 더 가까운 지점에서 만난다
     *
     * */


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
    static int[] distJ;
    static int[] distH;
    static int[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nodeCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());


        distH = new int[nodeCnt+1];
        Arrays.fill(distH,Integer.MAX_VALUE);

        distJ = new int[nodeCnt+1];
        Arrays.fill(distJ,Integer.MAX_VALUE);


        graph = new ArrayList<>();

        for (int i = 0; i <= nodeCnt; i++) {
            graph.add(new ArrayList<>());

        }

        for(int i=0; i<edgeCnt; i++){

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end,cost));
            graph.get(end).add(new Node(start,cost));

        }

        st = new StringTokenizer(br.readLine());

        int jStart = Integer.parseInt(st.nextToken());
        distJ[jStart] = 0;

        int hStart = Integer.parseInt(st.nextToken());
        distH[hStart] = 0;

        // 지헌과 성하의 시작 노드가 같다면 바로 출력
        if (jStart == hStart) {
            System.out.println(jStart);
            return;
        }


        visited = new int[nodeCnt+1];


        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(jStart,0));
        dijkstra(pq,distJ);


        pq.clear();

        pq.offer(new Node(hStart,0));
        dijkstra(pq,distH);

        HashMap<Integer,Integer> meetNode = new HashMap<>();
        int minCost = Integer.MAX_VALUE;


        for(int i=1; i<=nodeCnt; i++){
            if(distH[i]!=Integer.MAX_VALUE && distJ[i]!=Integer.MAX_VALUE){
                if(distJ[i]>distH[i]){
                    continue;
                }
                int totalCost = distH[i] + distJ[i];
                if (totalCost < minCost) {
                    minCost = totalCost;
                    meetNode.clear(); // 새로운 최소값 발견 시 기존 후보 제거
                    meetNode.put(i, totalCost); // 노드별 실제 비용 저장
                } else if (totalCost == minCost) {

                    meetNode.put(i, totalCost); // 같은 최소 비용인 경우 추가
                }
            }

        }


        int resultKey = -1; // 최종 약속 장소
        int minDistJ = Integer.MAX_VALUE; // 지헌이로부터 가장 가까운 거리

        for (Map.Entry<Integer, Integer> entry : meetNode.entrySet()) {
            int node = entry.getKey(); // 후보 장소 번호
            int totalCost = entry.getValue(); // 두 사람의 최단 거리 합

            // 지헌이로부터 더 가까운 장소를 찾거나, 동일한 경우 번호가 작은 장소를 선택
            if (distJ[node] < minDistJ || (distJ[node] == minDistJ && node < resultKey)) {
                minDistJ = distJ[node];
                resultKey = node;
            }
        }
        System.out.println(resultKey);


    }

    public static void dijkstra(PriorityQueue<Node> pq, int[] dist){
        Arrays.fill(visited, 0);

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.index]==1){
                continue;
            }
            visited[cur.index]=1;

            for(Node next: graph.get(cur.index)){
                if(dist[next.index] > dist[cur.index]+next.cost){
                    dist[next.index]= dist[cur.index]+next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

    }
}
