package com.example.algorithm.unionFind;

import java.util.*;

public class BJN_1012 {

    static int[] parents;
    static int M;
    static int N;
    static int K;

    static int getIndex(int y, int x) {
        return y * M + x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            M = sc.nextInt(); // 열 (가로)
            N = sc.nextInt(); // 행 (세로)
            K = sc.nextInt();

            parents = new int[M * N];
            boolean[][] field = new boolean[N][M];

            for (int i = 0; i < M * N; i++) {
                parents[i] = i;
            }

            List<int[]> cabbages = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[y][x] = true;
                cabbages.add(new int[]{y, x});
            }

            int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상,하,좌,우

            for (int[] pos : cabbages) {
                int y = pos[0];
                int x = pos[1];

                int from = getIndex(y, x);

                for (int[] d : dir) {
                    int ny = y + d[0];
                    int nx = x + d[1];

                    if (ny >= 0 && ny < N && nx >= 0 && nx < M && field[ny][nx]) {
                        int to = getIndex(ny, nx);
                        union(from, to);
                    }
                }
            }

            // 루트 개수 세기
            Set<Integer> roots = new HashSet<>();
            for (int[] pos : cabbages) {
                roots.add(find(getIndex(pos[0], pos[1])));
            }

            System.out.println(roots.size());
        }
    }

    public static void union(int from, int to){
        int px = find(from)  ;
        int py = find(to);
        if (px != py) {
            parents[py] = px;
        }
    }

    public static int find(int x){
        if(parents[x]!=x){
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
}
