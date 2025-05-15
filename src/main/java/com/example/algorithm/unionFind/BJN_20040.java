package com.example.algorithm.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJN_20040 {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int pointCnt = Integer.parseInt(st.nextToken());
        int turnCnt = Integer.parseInt(st.nextToken());

        parents = new int[pointCnt];

        for (int i = 0; i < pointCnt; i++) {
            parents[i] = i;
        }

        for(int i=1; i<=turnCnt; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (!union(from, to)) {
                System.out.println(i); // 사이클 발생한 턴 번호 출력
                return;
            }

        }
        System.out.println(0);
    }

    public static boolean union(int from, int to){
        int px = find(from);
        int py = find(to);

        if (px == py) return false; // 사이클 발생

        parents[py] = px;
        return true;
    }

    public static int find(int n){
        if (parents[n] != n) {
            parents[n] = find(parents[n]);
        }
        return parents[n];
    }

}
