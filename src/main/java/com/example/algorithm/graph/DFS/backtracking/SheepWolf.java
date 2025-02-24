package com.example.algorithm.graph.DFS.backtracking;

import java.util.*;

public class SheepWolf {

    static int maxSheep = 0;

    public static int solution(int[] info, int[][] edges) {
        List<Integer>[] tree = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]); // 부모 → 자식
        }

        // DFS 탐색 시작 (루트 노드 0부터 시작, 양 1마리 보유)
        dfs(0, 1, 0, new HashSet<>(List.of(0)), info, tree);
        return maxSheep;
    }

    private static void dfs(int node, int sheep, int wolf, Set<Integer> possibleNodes, int[] info, List<Integer>[] tree) {
        // 최대 양 개수 갱신
        maxSheep = Math.max(maxSheep, sheep);

        // 늑대가 양보다 많아지면 탐색 종료
        if (sheep <= wolf) return;

        // 현재 탐색 가능한 노드 리스트 (복사본 생성)
        Set<Integer> nextNodes = new HashSet<>(possibleNodes);
        nextNodes.remove(node); // 현재 노드는 제외

        // 현재 노드의 자식 노드를 추가
        nextNodes.addAll(tree[node]);

        // 가능한 모든 노드로 이동 시도
        for (int next : nextNodes) {
            if (info[next] == 0) { // 양이면
                dfs(next, sheep + 1, wolf, nextNodes, info, tree);
            } else { // 늑대면
                dfs(next, sheep, wolf + 1, nextNodes, info, tree);
            }
        }
    }

    public static void main(String[] args) {
        int result = solution(
            new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
            new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}
        );
        System.out.println(result); // 결과: 5
    }
}
