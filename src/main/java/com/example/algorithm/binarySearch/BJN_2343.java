package com.example.algorithm.binarySearch;

import java.util.*;
import java.io.*;
public class BJN_2343 {

    /**
     *
     * 이진탐색
     * 1. 입력
     *      강의 개수 N, 블루레이 M
     *      강의 리스트(입력순서 == 진행순서)
     *
     * 2. 로직
     *      int[] lessons = new int[N]
     *      left = 1  right = lessons[N-1]
     *
     *
     *      while(left<=right){
     *          List<Integer> blueray = new ArrayList<Integer>
     *          int sum=0;
     *          int bluerayNum=0;
     *          int mid = left+right/2;
     *
     *          2-1. for 강의 리스트
     *          if(sum>mid){
     *              bluray[blueRayNum] = sum;
 *                  bluerayNum++;
     *          }
     *          int maxSize = blueray.stream().max().getAsInt();
     *
     *          2-2. if(maxSize>mid ){  크면
     *                  left = mid +1;
     *
     *          }
     *          if(maxSize<=mid || blueray.size()<N-1){ 작으면
     *                 right=mid-1;
     *
     *           }
     *
     *      }
     *
     *
     * 3. 출력
     *    블루레이 Max
     *
     *
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lessons = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            lessons[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = Arrays.stream(lessons).sum();
        int result = Integer.MAX_VALUE;

        while(left<=right){

            int sum=0;
            int mid = (left+right)/2;
            List<Integer> blueList = new ArrayList<>();
            boolean isOver = false;

            for(int j=0; j<N; j++){
                int summarry = sum+lessons[j];
                if(summarry>mid){
                    if(blueList.size()<M){
                        blueList.add(sum);
                        sum=0;
                        j--;

                    }else{
                        isOver=true;
                        break;
                    }
                } else{
                    sum = summarry;
                    if(j==(N-1)){
                        blueList.add(sum);
                    }

                }
            }

             int maxSize = Collections.max(blueList);


            if(isOver || blueList.size()>M){
                left = mid +1;

            }else if(maxSize<=mid){

                result=Math.min(result,maxSize);
                right=mid-1;

            }else{
                left=mid+1;
            }

        }

        System.out.println(result);

    }

}
