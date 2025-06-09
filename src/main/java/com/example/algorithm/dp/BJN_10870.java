package com.example.algorithm.dp;

import java.io.*;
import java.util.*;

public class BJN_10870 {


    /**
     *
     * 피보나치 점화식
     *
     * p[3] = p[2]+p[1]
     * p[4] = p[3]+p[2]
     * p[5] = p[4]+p[3]
     *
     * 고정 초기화값
     * p[0] = 0
     * p[1] = 1
     *
     * */
    static int[] dp ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        if (num == 0) {
            System.out.println(0);
            return;
        } else if (num == 1) {
            System.out.println(1);
            return;
        }

        dp = new int[num+1];

        Arrays.fill(dp,-1);

        dp[0] = 0;
        dp[1] = 1;

        long startTopDown = System.nanoTime();
        int resultTopDown = topDown(num);
        long endTopDown = System.nanoTime();
        System.out.println("TopDown Time: " + (endTopDown - startTopDown) + "ns");
        System.out.println("topDown-DFS : "+resultTopDown);

        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;

        System.out.println("bottomUp-for : "+bottomUpFor(num));

        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;

        System.out.println("bottomUp-While : "+bottomUpWhile(num));



        Arrays.fill(dp,-1);

        long startbottomUpOptimized = System.nanoTime();
        bottomUpOptimized(num);
        long endbottomUpOptimized = System.nanoTime();
        System.out.println("bottomUpOptimized Time: " + (endbottomUpOptimized - startbottomUpOptimized) + "ns");


    }

    public static int topDown(int n){
        // dfs 구현
        // 위 -> 아래
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n] = topDown(n-1)+topDown(n-2);
    }

    public static int bottomUpFor(int n){
        // 아래 - > 위
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static int bottomUpWhile(int n){
        // 아래 - > 위
        int i = 2;
        while(i<=n){
            dp[i] = dp[i-1]+dp[i-2];
            i++;
        }
        return dp[n];
    }

    public static int bottomUpOptimized(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

}
