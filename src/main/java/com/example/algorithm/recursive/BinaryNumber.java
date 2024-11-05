package com.example.algorithm.recursive;

import java.io.*;
import java.util.*;

public class BinaryNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int value=0;

        for(int i=0; i<size; i++){
             value += (int) Math.pow(2,i);
        }

        for(int i=1; i<=value;i++){
            String str = "";
            str = binary(i, str);

            StringBuffer sb = new StringBuffer(str);
            int reverse = Integer.parseInt(sb.reverse().toString());
            String result = String.format("%0" + size + "d", reverse);

            if(!result.contains("00")){
                System.out.println("result: "+ String.format("%0"+size+"d", reverse));

            }

        }


    }

    public static String binary(int i, String str){

        if(i/2==0){
            return str +i%2 + "0";
        }
        str += String.valueOf(i%2);

        return binary(i / 2,str);

    }

}
