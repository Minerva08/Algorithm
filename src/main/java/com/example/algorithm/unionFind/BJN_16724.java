package com.example.algorithm.unionFind;

import java.io.*;
import java.util.*;

public class BJN_16724 {

    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Map<Character, Integer> dirMap = Map.of(
        'U', 0,
        'D', 1,
        'L', 2,
        'R', 3
    );

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        char[][] map = new char[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            char[] dirArr = st.nextToken().toCharArray();
            for (int j = 0; j < width; j++) {
                map[i][j] = dirArr[j];
            }
        }

        parent = new int[height * width];
        for (int i = 0; i < height * width; i++) parent[i] = i;

        // 유니온 파인드 연산으로 간선 처리
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int from = i * width + j;
                int dir = dirMap.get(map[i][j]);
                int ni = i + dirs[dir][0];
                int nj = j + dirs[dir][1];

                // 범위 벗어나는 경우는 무시
                if (ni < 0 || ni >= height || nj < 0 || nj >= width) continue;

                int to = ni * width + nj;
                union(from, to);  // 간선 연결
            }
        }

        // 각 루트를 찾아서 사이클 개수를 세기
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < height * width; i++) {
            roots.add(find(i));  // 각 칸의 최종 루트를 넣음
        }

        // 루트의 개수 출력
        System.out.println(roots.size());
    }

    // 유니온: 부모 병합
    static void union(int from, int to) {
        int px = find(from);
        int py = find(to);
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
