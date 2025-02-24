package com.example.algorithm.primeNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SieveOfEratosthenes {

    /**
     *
     * 소수 판별 알고리즘
     *
     * 에라토스테네스의 체
     *
     *
     *
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long num  = Long.parseLong(st.nextToken());

        Boolean[] isPrimeArr = new Boolean[(int) num];

        Arrays.fill(isPrimeArr,true);
        isPrimeArr[0] = isPrimeArr[1] = false;

        // N의 제곱근 이전값 까지만 나눈다
        for(int i=2; i<Math.sqrt(num); i++){
            // 1,0은 소수가 아니다

            // 그 중 1의 배수, 2의배수,3의 배수 삭제하기
            for (int j = i * i; j <= num; j += i) {
                isPrimeArr[j] = false;
            }

        }


        for (int i=0; i<isPrimeArr.length; i++){
            if(isPrimeArr[i]){
                System.out.println(i);
            }
        }


    }


}
