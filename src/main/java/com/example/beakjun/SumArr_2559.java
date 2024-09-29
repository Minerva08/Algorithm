package com.example.beakjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SumArr_2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int duration = Integer.parseInt(st.nextToken());
        int perDay = Integer.parseInt(st.nextToken());

        long[] sum = new long[duration+1];
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=duration; i++){
            sum[i]= sum[i-1]+Integer.parseInt(st.nextToken());
        }

        long answer = Long.MIN_VALUE;

        for (int i = perDay; i <= duration; i++) {
            answer = Math.max(answer,  sum[i] - sum[i - perDay]);

        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

}
