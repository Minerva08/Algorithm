package com.example.algorithm.graph;

import java.util.*;
import java.io.*;

public class BinaryGraph {
    static int nodeCnt;
    static int edgeCnt;


    public static class Node{
        int index;

        public Node(int index){
            this.index = index;
        }

    }

    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int testCase = Integer.parseInt(st.nextToken());
        String[] result = new String[testCase];

        for(int i=0; i<testCase; i++){


            st = new StringTokenizer(br.readLine());
            nodeCnt = Integer.parseInt(st.nextToken());
            edgeCnt = Integer.parseInt(st.nextToken());

            List<Node>[] graph = new List[nodeCnt+1];
            Boolean[] colors = new Boolean[nodeCnt+1];
            Arrays.fill(colors,null);

            for(int j=0; j<=nodeCnt; j++){
                graph[j]=new ArrayList<>();
            }

            for(int k=0;k<edgeCnt;k++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph[start].add(new Node(end));
                graph[end].add(new Node(start));
            }

            result[i] =  bfs(graph,colors)?"YES":"NO";

        }

        for (String s : result) {
            System.out.println(s);
        }


    }
    public static boolean bfs(List<Node>[] graph,Boolean[] colors){

        for(int i=1; i<=nodeCnt; i++){

            if(colors[i]==null){
                Queue<Node> pq  = new LinkedList<>();
                pq.offer(new Node(i));
                colors[i]=true;

                while(!pq.isEmpty()){
                    Node now = pq.poll();


                    for(Node connect : graph[now.index]){

                            if (colors[connect.index] == null){
                                colors[connect.index] = !colors[now.index];
                                pq.offer(connect);
                            }

                            if (colors[connect.index] == colors[now.index]) {
                                return false;
                            }

                    }

                }
            }


        }
        return true;

    }
}
