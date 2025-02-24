package com.example.algorithm.binarySearch;

import java.io.*;
import java.util.*;

public class BJN_2776 {
    /**
     * 1. 입력
     *      시도횟수
     *      note1 크기
     *      note1 숫자
     *      note2 크기
     *      note2 숫자
     *      ....
     *
     * 2. 로직
     *      2-1. note1 Set 생성
     *      2-2. note1 배열로 변환 + 오름차순정렬
     *      2-3. for note2
         *      2-3-1. 이진탐색
         *              while(left<=right)
         *              if(target = note2) return 1;
     *                  else if(target<note1[mid])
     *                      right = mid-1;
     *                  else
     *                      left = mid-1;
     *
     * */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int tryCnt = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < tryCnt; j++) {

            st = new StringTokenizer(br.readLine());
            int note1Size = Integer.parseInt(st.nextToken());
            Set<Integer> note1Set = new HashSet<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < note1Size; i++) {
                note1Set.add(Integer.parseInt(st.nextToken()));
            }

            int[] note1 = note1Set.stream().mapToInt(Integer::intValue).sorted().toArray();

            st = new StringTokenizer(br.readLine());
            int note2Size = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < note2Size; i++) {
                int exist = binarySearch(Integer.parseInt(st.nextToken()),note1);
                sb.append(exist).append("\n");

            }

        }

        System.out.println(sb.toString());
    }

    static int binarySearch(int qNum, int[] noteArr){

        int left = 0;
        int right = noteArr.length-1;

        while (left <= right) {
            int midIndex = (left + right) / 2;

            int midNum = noteArr[midIndex];


            if(midNum==qNum){
                return 1;
            } else if(qNum<midNum){
                right = midIndex-1;
            } else{
                left = midIndex+1;
            }

        }
        return 0;

    }

}
