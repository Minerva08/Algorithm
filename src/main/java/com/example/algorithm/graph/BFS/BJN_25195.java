package com.example.algorithm.graph.BFS;

import java.util.*;
import java.io.*;

public class BJN_25195 {
    static ArrayList<ArrayList<Integer>> graph;
    static Boolean canAvoid = false;
    static int[] visited ;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        visited = new int[node+1];
        queue = new LinkedList<>();


        graph = new ArrayList<>(node+1);
        for(int i=0; i<=node;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edge; i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
        }

        st = new StringTokenizer(br.readLine());
        int gomCnt = Integer.parseInt(st.nextToken());
        List<Integer> gomArr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<gomCnt;i++){
            gomArr.add(Integer.parseInt(st.nextToken()));
        }

        queue.add(1);

        while(!queue.isEmpty()){
            int now = queue.poll();
            visited[now]=1;

            if(gomArr.contains(now)){
                continue;
            }

            if(graph.get(now).isEmpty()){
                canAvoid = true;
                continue;
            }

            for (Integer connect : graph.get(now)) {
                if(visited[connect]==0){
                    queue.add(connect);
                }
            }

        }
        System.out.println( canAvoid?"yes":"Yes");


    }


}
