package com.example.algorithm.bellmanFord;


import com.example.algorithm.bellmanFord.BJN_11657.Edge;
import java.io.*;
import java.util.*;

public class BJN_1865 {
    /**
     * 웜홀
     * 벨만 포드
     * */

    static List<String> answer;

    static int nCnt;
    static int mCnt;
    static int wCnt;

    static Node[] nodes;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int trier = Integer.parseInt(st.nextToken());
        answer = new ArrayList<>();


        for(int i=0;i<trier;i++){
            st = new StringTokenizer(br.readLine());


            nCnt = Integer.parseInt(st.nextToken());
            mCnt = Integer.parseInt(st.nextToken());
            wCnt = Integer.parseInt(st.nextToken());

            nodes = new Node[mCnt+wCnt];
            int l = 0;

            for(int j=0; j<mCnt;j++){
                st = new StringTokenizer(br.readLine());
                nodes[l] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
                l++;
            }

            for(int k=0;k<wCnt; k++){
                st = new StringTokenizer(br.readLine());
                nodes[l] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),-1*Integer.parseInt(st.nextToken()));
                l++;

            }

            int[] dist = new int[nCnt+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[1]=0;

            bellmanford(dist);

        }

        for (String s : answer) {
            System.out.println(s);
        }


    }

    public static void bellmanford(int[] dist){
        boolean isCycle = false;

        for (int i = 0; i <= nCnt; i++) {
            for (int j = 0; j < (mCnt+wCnt); j++) {
                Node cur = nodes[j];
                if (dist[cur.start] == Integer.MAX_VALUE) {
                    continue;
                }

                if (dist[cur.end] > dist[cur.start] + cur.time) {
                    dist[cur.end] = dist[cur.start] + cur.time;
                    if (i == nCnt) {
                        isCycle = true;
                        break;
                    }
                }
            }

        }
        answer.add(isCycle?"YES":"NO");

    }

    public static class Node{
        int start;
        int end;
        int time;

        public Node(int start, int end, int time){
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

}
