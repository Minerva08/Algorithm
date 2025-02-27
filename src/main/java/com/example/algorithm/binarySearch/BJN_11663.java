package com.example.algorithm.binarySearch;

import java.util.*;
import java.io.*;

public class BJN_11663 {

    /**
     *
     * 1. 입력
     *      점(N) 선분(M)
     *      선분시작점 종료점
     *
     *
     * 2. 로직
     *      2-1. 점 배열 생성 -> 정렬(오름차순)
     *      2-2. 선분 배열 int[][] -> [시작점, 종료점]
     *      2-3. for( 선분 배열)
     *
     *           int boundIndex(target,1(상한선)/0(하한선)) -> while(left<=right) target = 시작점
     *
     *           if(mid<target){
     *
     *              right = mid-1;
     *
     *           }else if(mid> target{
     *               left = mid+1;
     *           }else{
     *               bottom = mid
     *           }
     *
     *
     *
     * 3. 출력
     *      범위내 점 개수
     * */
    static int N;
    static int[] pointArr;



    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =    new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        pointArr = new int[N];
        int M = Integer.parseInt(st.nextToken());
        long[][] lineArr = new long[M][2];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)  {
            pointArr[i]= Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            lineArr[i][0] = start;
            lineArr[i][1] = end;
        }

        Arrays.sort(pointArr);


        for(int i=0; i<M; i++){

            long start = lineArr[i][0];
            long end = lineArr[i][1];

            Integer startIdx = bottomBound(start);
            Integer endIdx = topBound(end);

            System.out.println((endIdx-startIdx)+1);


        }

    }

    static int bottomBound(long target){
        int left = 0;
        int right = pointArr.length-1;
        int boudIndex =pointArr.length;
        while(left<=right){
            int mid = (left+right)/2;

            if(pointArr[mid]<target){
                left = mid+1;
            } else if(pointArr[mid]>=target){
                if(boudIndex>mid){
                    boudIndex = mid;
                }
                right = mid-1;
            }
        }

       return boudIndex;

    }

    static int topBound(long target){
        int left = 0;
        int right = pointArr.length-1;
        int boudIndex = -1;

        while(left<=right){
            int mid = (left+right)/2;

            if(pointArr[mid]<=target){
                if(boudIndex<mid){
                    boudIndex = mid;
                }
                left = mid+1;
            } else if(pointArr[mid]>=target){
                right = mid-1;
            }
        }
        return boudIndex;

    }
}
