package com.example.algorithm.binarySearch.boud;

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
     *           start = 선분 시작
     *           end = 선분 종료
     *
     *           상한 위치 = 상한(start,arr)
     *                    start 이상의 최소값
     *           하한 위치 = 하한(end,arr)
     *                    end 초과의 최소값
     *
     * 3. 출력
     *      범위내 점 개수 = (상한 위치 - 하한 위치)
     * */
    static int N;
    static int[] pointArr;

    public static class Line{

        long start;
        long end;

        public Line(long start, long end){
            this.start = start;
            this.end = end;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        pointArr = new int[N];
        int M = Integer.parseInt(st.nextToken());
        Line[] lineArr = new Line[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            pointArr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            lineArr[i] = new Line(start, end);
        }

        Arrays.sort(pointArr);

        for(int i=0; i<M;i++){
            long start = lineArr[i].start;
            long end = lineArr[i].end;

            long lowerIdx = bottomBound(start);
            long upperIdx = topBound(end);

            System.out.println((upperIdx-lowerIdx)+1);
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
