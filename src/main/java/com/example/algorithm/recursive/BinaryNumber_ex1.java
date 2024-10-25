package com.example.algorithm.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinaryNumber_ex1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int value=0;

        for(int i=0; i<size; i++){
             value += (int) Math.pow(2,i);
        }

        for(int i=1; i<=value;i++){
            String binaryStr = toBinary(i);
            String result = String.format("%0" + size + "d", Integer.parseInt(binaryStr));
            if(!result.contains("00")){
                System.out.println(result);

            }

        }


    }

    public static String toBinary(int num){
        if(num==1) return "1";
        if(num==0) return "0";
        return toBinary(num/2)+(num%2);

    }

}
