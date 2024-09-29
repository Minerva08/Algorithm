package com.example.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumArr_111659 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int suNum = Integer.parseInt(stringTokenizer.nextToken());
        int qNum= Integer.parseInt(stringTokenizer.nextToken());

        long[] sum = new long[suNum+1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=1; i<suNum; i++){
            sum[i]= sum[i-1]+Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int q =0; q<qNum; q++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i= Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            try{
                System.out.println( sum[j]-sum[i-1]);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("OutOfIndex error");
            }
        }

    }


}
