package com.example.algorithm.bellmanFord;

import java.io.*;
import java.util.*;

public class BJN_11657 {
    /**
     * 음의 가중치를 포함한 각 노드의 최단거리 구하기
     *
     * */

    static int N; // 도시 개수 == 엣지
    static int M; // 노선 수 == 노드

    static Edge[] eg;

    public static class Edge {
        int start;
        int end;
        long hour;

        public Edge(int start, int end, long hour) {
            this.start = start;
            this.end = end;
            this.hour = hour;
        }
    }

    static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long[] dist = new long [N+1];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;


        eg = new Edge[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long time = Integer.parseInt(st.nextToken());
            eg[i] = new Edge(from, to, time);
        }

        boolean isCycle = bellmanford(dist);

        if (isCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i < dist.length; i++) {
                if(dist[i] == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(dist[i]);
                }
            }
        }



    }

    public static boolean bellmanford(long[] dist) throws Exception{
        boolean isMinusCycle = false;


        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < M; j++) {
                Edge cur = eg[j];
                if (dist[cur.start] == Integer.MAX_VALUE) {
                    continue;
                }

                if (dist[cur.end] > dist[cur.start] + cur.hour) {
                    dist[cur.end] = dist[cur.start] + cur.hour;
                    if (i == N) {
                        isMinusCycle = true;
                        break;
                    }
                }
            }
        }


        return isMinusCycle;
    }

}
