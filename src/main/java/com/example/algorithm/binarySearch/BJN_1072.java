package com.example.algorithm.binarySearch;
import java.util.*;
import java.io.*;

public class BJN_1072 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long totalGame = Integer.parseInt(st.nextToken());
        long winGame = Integer.parseInt(st.nextToken());

        double currentRate = Math.floor((double) (winGame * 100l) /totalGame);

        long left = 1;
        long right = 1000000000;

        long result = 0;

        if(totalGame==winGame){
            System.out.print(-1);

        }else{
            while(left<=right){

                long mid = (left+right)/2;

                double new_rate = Math.floor((double) ((winGame + mid) * 100l) /(totalGame+mid));

                if(new_rate>currentRate){
                    result = mid;
                    right=mid-1;
                    // 추가된 경기에서의 승률이 기존 승률 보다 크면
                    // 추가된 mid를 줄여서 다시 해보기
                    // 그래서 mid -1;

                }else{
                    left=mid+1;
                }
            }

            System.out.println(result);
        }

    }
}
