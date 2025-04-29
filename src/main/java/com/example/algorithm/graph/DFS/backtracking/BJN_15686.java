package com.example.algorithm.graph.DFS.backtracking;

import java.util.*;

public class BJN_15686 {
    static int M, size;
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> house = new ArrayList<>();
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int num = sc.nextInt();
                if (num == 1) house.add(new int[]{i, j});
                if (num == 2) chickens.add(new int[]{i, j});
            }
        }

        dfs(0, 0, new ArrayList<>());

        System.out.println(minResult);
    }

    public static void dfs(int n, int start, List<int[]> selectedChickens) {
        if (n == M) {
            int cityMin = 0;
            for (int[] h : house) {
                int minDist = Integer.MAX_VALUE;
                for (int[] ch : selectedChickens) {
                    int dist = Math.abs(h[0] - ch[0]) + Math.abs(h[1] - ch[1]);
                    minDist = Math.min(minDist, dist);
                }
                cityMin += minDist;
            }
            minResult = Math.min(minResult, cityMin);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selectedChickens.add(chickens.get(i));
            dfs(n + 1, i + 1, selectedChickens);
            selectedChickens.remove(selectedChickens.size() - 1);
        }
    }
}
