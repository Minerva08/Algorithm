package com.example.algorithm.dp.b_u;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJN_1463 {
    static int[] memo ;
    // 숫자별 도달 가능한 최소 횟수 저장

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        memo = new int[n+1];

        memo[1] = 0;
        int now =1;

        while(now<n){
            int next = now+1;
            memo[next] = memo[now]+1;

            if(next%2==0){

                memo[next] = Math.min(memo[next],memo[next/2]+1);
            }
            if(next%3==0){
                memo[next] = Math.min(memo[next],memo[next/3]+1);

            }
            now++;

        }
        System.out.println(memo[n]);



    }

}
