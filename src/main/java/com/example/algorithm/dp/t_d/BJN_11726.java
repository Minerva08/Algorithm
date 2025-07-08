package com.example.algorithm.dp.t_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJN_11726 {
    static int[] memo ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        memo = new int[n+1];


        Arrays.fill(memo,-1);
        memo[1]=1;
        memo[2]=2;

        int result = dfs(n);
        System.out.print(result%10007);



    }
    public static int dfs(int n){
        if(memo[n]!=-1){
            return memo[n];
        }
        memo[n] = dfs(n-1)+dfs(n-2);
        return memo[n];
    }

}
