package com.example.algorithm.dp.t_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJN_9095 {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringBuilder sb = new StringBuilder();

        // 최대 11까지로 문제에서 제한 (n ≤ 11)
        memo = new int[12];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dfs(n)).append('\n');
        }

        System.out.print(sb);
    }

    public static int dfs(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        if (memo[n] != -1) {
            return memo[n];
        }

        return memo[n] = dfs(n - 1) + dfs(n - 2) + dfs(n - 3);
    }
}
