package com.example.algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJN_14916 {

    // 1. 가장 큰 단위의 동전 부터 사용하기
    // 2. 가장 큰 동전 지불 후 남은 동전을 다음 단위의 동전 사용하기
    // 3. 동전을 사용할 수 없으면 큰 단위 동전 하나씩 줄여보기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int change = Integer.parseInt(st.nextToken());


        int cnt = 0;


        if(change/5>0){
            cnt+=(change/5);
            if(change%5==0){
                System.out.println(cnt);
                return;
            }
            change=(change%5);

        }

        if(change%2==0){
          cnt+=(change/2);
          System.out.println(cnt);
          return;

        } else{

            while(cnt>0){
                cnt--;
                change+=5;

                if(change%2==0){
                    cnt += change/2;
                    System.out.println(cnt);
                    return ;
                }

            }
        }


        System.out.println(-1);





    }

}
