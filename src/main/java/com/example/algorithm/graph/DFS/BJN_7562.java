package com.example.algorithm.graph.DFS;

import static java.lang.Integer.MAX_VALUE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJN_7562 {

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int answer;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());

        for (int i = 0; i < cnt; i++) {
            answer = MAX_VALUE;
            st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken());

            // 방문 여부 체크를 위한 2차원 boolean 배열 초기화
            visited = new boolean[size][size];

            st = new StringTokenizer(br.readLine());
            int[] startPoint = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            st = new StringTokenizer(br.readLine());
            int[] endPoint = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            dfs(startPoint, endPoint, 1, 0, 2, 1, size, 0);
            dfs(startPoint, endPoint, 1, 0, 1, 2, size, 0);
            dfs(startPoint, endPoint, 1, 2, 2, 1, size, 0);
            dfs(startPoint, endPoint, 1, 2, 1, 2, size, 0);
            dfs(startPoint, endPoint, 3, 0, 2, 1, size, 0);
            dfs(startPoint, endPoint, 3, 0, 1, 2, size, 0);
            dfs(startPoint, endPoint, 3, 2, 2, 1, size, 0);
            dfs(startPoint, endPoint, 3, 2, 1, 2, size, 0);

            System.out.println(answer);
        }
    }

    public static void dfs(int[] start, int[] end, int sn, int lf, int snMove, int lfMove, int size, int step) {
        if (start[0] == end[0] && start[1] == end[1]) {
            answer = Math.min(answer, step);
            return;
        }

        if (step >= answer || start[0] < 0 || start[0] >= size || start[1] < 0 || start[1] >= size || visited[start[0]][start[1]]) {
            return;
        }

        // 현재 위치를 방문했음으로 표시
        visited[start[0]][start[1]] = true;

        // 다음 위치로 이동
        int[] startPoint = new int[]{start[0] + (dx[lf] * lfMove), start[1] + (dy[sn] * snMove)};

        dfs(startPoint, end, 1, 0, 2, 1, size, step + 1);
        dfs(startPoint, end, 1, 0, 1, 2, size, step + 1);
        dfs(startPoint, end, 1, 2, 2, 1, size, step + 1);
        dfs(startPoint, end, 1, 2, 1, 2, size, step + 1);
        dfs(startPoint, end, 3, 0, 2, 1, size, step + 1);
        dfs(startPoint, end, 3, 0, 1, 2, size, step + 1);
        dfs(startPoint, end, 3, 2, 2, 1, size, step + 1);
        dfs(startPoint, end, 3, 2, 1, 2, size, step + 1);

        // 백트래킹을 위해 방문 여부를 해제
        visited[start[0]][start[1]] = false;
    }
}
