package com.example.algorithm.binarySearch;

import java.io.*;
import java.util.*;

public class BJN_1654 {
    /**
     * 1. 입력
     *      기존 랜선 개수K, 만들려는 개수N
     *      각 랜선 길이
     *
     * 2. 로직
     *      2-1. 제일 짧은 랜선 길이
     *      2-2. 이진탐색
     *          left = 0
     *          right = 제일 짧은 랜선 길이
     *          result
     *          while( left<=right){
     *              int mid = (left  + right) /2
     *              int cnt
     *              for(기존 랜선){
     *                  cnt+=랜선/mid
     *              }
     *              if(cnt<N){
     *                 left = mid+1;
     *
     *              }else {
     *                  result = Math.max(mid, result);
     *                 right  = mid-1;
     *              }
     *          }
     *
     *  3. 출력
     *     최대 랜선 길이 반환
     *
     *
     * */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader    (System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lenArr = new int[K];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            lenArr[i]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lenArr);

        long left = 1;
        long right = lenArr[K-1];
        long result = 0;
        while(left<=right){
            long mid = left + (right - left) / 2;
            long cnt=0;

            for (int i : lenArr) {
                cnt+=(i/mid);
            }

            if(cnt<N){
                right = mid-1;
            }else{
                result = Math.max(result,mid);
                left = mid+1;

            }
        }

        System.out.println(result);


    }

}
