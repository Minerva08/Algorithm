package com.example.algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BJN_31926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 10;

        long cnt = Long.parseLong(st.nextToken());

        while(cnt>1){
            cnt/=2;
            result++;
        }

        System.out.println(result);
    }

}
