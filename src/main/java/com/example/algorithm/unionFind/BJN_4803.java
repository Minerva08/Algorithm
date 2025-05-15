package com.example.algorithm.unionFind;

import java.util.*;
import java.io.*;

public class BJN_4803 {

        static int[] parent;
        static boolean[] hasCycle;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int caseNum = 1;

            while (true) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken()); // 정점 수
                int m = Integer.parseInt(st.nextToken()); // 간선 수

                if (n == 0 && m == 0) break;

                parent = new int[n + 1];
                hasCycle = new boolean[n + 1];

                // 초기화: 자기 자신을 부모로 설정
                for (int i = 1; i <= n; i++) {
                    parent[i] = i;
                }

                // 간선 처리
                for (int i = 0; i < m; i++) {
                    st = new StringTokenizer(br.readLine());
                    int u = Integer.parseInt(st.nextToken());
                    int v = Integer.parseInt(st.nextToken());

                    int rootU = find(u);
                    int rootV = find(v);

                    if (rootU == rootV) {
                        // 같은 집합 -> 사이클 발생
                        hasCycle[rootU] = true;
                    } else {
                        // 병합
                        boolean cycle = hasCycle[rootU] || hasCycle[rootV];
                        union(u, v);
                        int newRoot = find(u);
                        hasCycle[newRoot] = cycle;
                    }
                }

                // 트리 개수 세기
                int treeCount = 0;
                Set<Integer> counted = new HashSet<>();
                for (int i = 1; i <= n; i++) {
                    int root = find(i);
                    if (!hasCycle[root] && !counted.contains(root)) {
                        treeCount++;
                        counted.add(root);
                    }
                }

                // 출력
                System.out.print("Case " + caseNum + ": ");
                if (treeCount == 0) {
                    System.out.println("No trees.");
                } else if (treeCount == 1) {
                    System.out.println("There is one tree.");
                } else {
                    System.out.println("A forest of " + treeCount + " trees.");
                }
                caseNum++;
            }
        }

        // 유니온: 부모 병합
        static void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[py] = px;
            }
        }

        // 파인드: 대표 루트 찾기 + 경로 압축
        static int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

