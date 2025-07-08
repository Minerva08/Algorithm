package com.example.algorithm.dp.t_d;

import java.io.*;
import java.util.*;

public class BJN_1010 {
    /**
     *
     * 입력
     * 3
     * 2 2
     * 1 5
     * 13 29
     *
     *
     * 로직
     * 서쪽에서 연결한 동쪽 사이트의 최신값 이후 사이트들 중 연결
     * 다리가 서로 겹칠 수 없다
     * -> 서쪽 사이트 중 동쪽 사이트를 선택하는 조합 서쪽C동쪽
     *
     * 조합 == 파스칼의 삼각형
     *
     * nCr = (n-1)C(r-1) + (n-1)C(r)
     *
     *
     *
     * 결과
     * 다리를 지을 수 있는 경우의 수
     * */
    static long[][] dp = new long[31][31];
    static long[] resultArr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int caseCnt = Integer.parseInt(st.nextToken());

        resultArr = new long[caseCnt];

        for (int x = 0; x < 30; x++) {
            Arrays.fill(dp[x], -1L);
        }

        for(int i=0; i<caseCnt; i++){
            st= new StringTokenizer(br.readLine());

            int westCnt=  Integer.parseInt(st.nextToken());
            int eastCnt = Integer.parseInt(st.nextToken());

            resultArr[i] = dfs(westCnt,eastCnt);

        }

        for (long l : resultArr) {
            System.out.println(l);
        }


    }

    public static long dfs(int west,int east){
        if(west==0 || west==east){
            return dp[east][west] = 1;
        }

        if(dp[east][west]!=-1){
            return dp[east][west];
        }
        return dp[east][west] = dfs(east-1,west-1)+dfs(east-1,west);

    }


}
