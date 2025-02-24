package com.example.test.hyundai.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Hyundai_2025_1_1 {

    /*
    * 1. 입력
    *    노드 개수, 엣지 개수
    *    노드 연결 상태
    *
    * 2. 로직
    *    2-1. (BFS) 노드의 구성 확인 끊어진 분리된 노드의 존재 여부 및 구성
    *       2-1-1. Queue
    *    2-2. 구성된 노드의 최대 구하기
    *    2-3.(DFS) 각 모든 노드를 시작 노드로 시도
    *       2-3-1. 각 노드 별 선택 노드의 합 최대 UPDATE
    *       2-3-2. 이미 방문한 노드를 다시 만날 경우 사이클이 존재하는 것으로 판단
    *
    * 3. 결과
    *   최대 노드 수 반환
    *
    * */


    static int nodeCnt;
    static boolean[] visited;
    static List<Set<Integer>> linkedNodeList = new ArrayList<>();
    static List<Integer>[] graph;
    static Queue<Integer> bfsQueue;
    static int maxCnt = 0;
    static int tempMax=0;
    static int totalMax = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        nodeCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());
        visited = new boolean[nodeCnt+1];

        graph = new ArrayList[nodeCnt + 1];

        for(int i =0; i<nodeCnt+1; i++){
           graph[i] = new ArrayList<>();
        }

        for(int i =0; i<edgeCnt; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);

        }

        // linkedNodeList
        bfsQueue = new LinkedList<>();

        for(int i=1; i<=nodeCnt; i++){
            if(!visited[i]){
                bfsQueue.offer(i);
                bfs();
            }

        }

        for (Set<Integer> integers : linkedNodeList) {
            if(integers.size()==1){
                totalMax++;
            }else{

                for (Integer node : integers) {
                    tempMax=0;

                    dfs(node,Set.of(node), new HashSet<>(), new boolean[nodeCnt+1]);
                    maxCnt = Math.max(maxCnt,tempMax);
                }
                totalMax+=maxCnt;
            }


        }
        System.out.println("result : "+totalMax);

    }

    static void dfs(int index,Set<Integer> selected, Set<Integer> children, boolean[] visited){

        tempMax = Math.max(tempMax, selected.size());

        Set<Integer> selectedNodes = new HashSet<>(selected);
        Set<Integer> possibleNodes = new HashSet<>(children);

        visited[index] = true;

        for (Integer next : graph[index]) {
            if(!visited[next]){
                possibleNodes.add(next);
            }
        }
        possibleNodes.remove(index);


        for (Integer next : possibleNodes) {
            boolean connected = false;
            for (Integer node : selectedNodes) {
                if(graph[node].contains(next)){
                    connected = true;
                }
            }

            if(!selectedNodes.contains(next) && !connected){
                selectedNodes.add(next);
            }

            dfs(next,selectedNodes,possibleNodes,visited);

        }


    }


    static void bfs(){

        Set<Integer> linkedSet = new HashSet<>();
        while(!bfsQueue.isEmpty()){
            int current = bfsQueue.poll();

            if(!visited[current]){
                visited[current]= true;
                linkedSet.add(current);
                for(int next : graph[current]){
                    bfsQueue.offer(next);

                }
            }

        }

        linkedNodeList.add(linkedSet);
    }
}
