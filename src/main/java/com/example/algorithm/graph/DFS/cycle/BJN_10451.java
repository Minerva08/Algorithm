package com.example.algorithm.graph.DFS.cycle;

import java.io.*;
import java.util.*;

public class BJN_10451 {

    static int size;

    static List<List<Integer>> nodes;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tryCnt = Integer.parseInt(st.nextToken());

        int[] result = new int[tryCnt];

        for(int i=0; i<tryCnt; i++){
            st = new StringTokenizer(br.readLine());

            int resultCnt = 0;
            size = Integer.parseInt(st.nextToken());
            nodes = new ArrayList<>();
            nodes.add(new ArrayList<>());
            visited = new boolean[size+1];


            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=size; j++){
                nodes.add(new ArrayList<>());
                nodes.get(j).add(Integer.parseInt(st.nextToken()));
            }

            for(int k = 1; k <= size; k++) {
                if(!visited[k]) {
                    resultCnt++;
                    dfs(k);
                }
            }
            result[i] = resultCnt;

        }

        Arrays.stream(result).forEach(System.out::println);

    }

    public static void dfs(int now){
        if(visited[now]){
            return;
        }
        visited[now] = true;
        for (Integer node : nodes.get(now)) {
            if(!visited[node]){
                dfs(node);
            }
        }
    }

}
