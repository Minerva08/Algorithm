package com.example.beakjun.sumArr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SumArr_10986 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arrSize = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        long[] sumArr = new long[arrSize];

        st = new StringTokenizer(br.readLine());

        for(int i =0; i<arrSize;i++){

            if(i==0){
                sumArr[0] = Integer.parseInt(st.nextToken());
            }else{
                sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
            }
        }

        long[] namugiArr = new long[num];

        long result = 0l;

        for(int i =0; i<sumArr.length;i++){
            long namugi = sumArr[i] % num;
            namugiArr[(int) namugi]++;
            if (namugi == 0) {
                result++;
            }

        }

        for(int i=0;i<namugiArr.length; i++){
            if(namugiArr[i]!=0){
                result += combination(namugiArr[i]);
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }


    public static long combination(long n) {
        return (n * (n - 1)) / 2;  // nC2 계산
    }
}
