package com.example.algorithm.twoPointer;

import java.util.*;

public class BJN_29700 {

    /**
     * 이차원 배열에서 슬라이딩 윈도우
     *
     *
     * 1. 입력
     *      M(세로) N(가로) k(사람 수)
     *      이차원 배열
     *      3 5 3
     *      11000
     *      01010
     *      10000
     *
     *
     * 2. 로직
     *    int cnt = 0;
     *
     *    for(i~M){
     *        for(end<N){
     *            if(arr[i][end]==0){
     *               while(end-start+1>k){
     *                   start++;
     *               }
     *               if(end-start+1==k){
     *                   cnt++;
     *               }
     *            }
     *
     *        }
     *    }
     *
     *
     * 3. 출력
     *
     *    System.out.println(cnt);
     *
     *
     * */

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] arr = new int[m][n];

        for(int i=0; i<m; i++){
            char[] c = sc.next().toCharArray();
            for(int j=0; j<n; j++){
                arr[i][j] = c[j]-'0';
            }
        }

        int cnt = 0;
        for(int i=0; i<m; i++){

            int start = 0;
            int seatCnt = 0;

            for(int end=0; end<n; end++){
                if(arr[i][end]==0){
                    seatCnt++;
                    while(end-start+1>k){
                        if(arr[i][start]==1){
                            start++;
                        }
                    }
                    if(end-start+1==k && seatCnt==k){
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);


    }

}
