package com.example.algorithm.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJN_11561 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCnt = Integer.parseInt(st.nextToken());

        long[] max = new long[testCnt];

        for(int i=0; i<testCnt; i++){
            st =  new StringTokenizer(br.readLine());

            long stoneCnt = Long.parseLong(st.nextToken());

            if(stoneCnt==1){
                max[i]=1;
            }
            if(stoneCnt==2){
                max[i]=2;
            }

            long start = 0;

            long firstJump = (start+stoneCnt)/2;


            while(start<firstJump){

                long nowPoint = start;
                long passed = 0;

                while(true){

                    nowPoint+=(firstJump+passed);
                    passed++;

                    if(nowPoint==stoneCnt) {
                        max[i] = passed;
                        firstJump/=2;
                        break;
                    }else if(nowPoint>stoneCnt && max[i]>=passed){
                        firstJump += 1;
                        break;
                    }else if(nowPoint>stoneCnt && max[i]<passed){
                        firstJump-=1;
                        break;
                    }
                }

            }

        }

        for(int i=0; i<testCnt; i++){
            System.out.println("최대 징검 다리 개수:"+max[i]);

        }


    }

}
