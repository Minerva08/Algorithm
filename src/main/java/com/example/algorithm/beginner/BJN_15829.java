package com.example.algorithm.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJN_15829 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        int[] alphabetArr =  new int[size];

        for(int i=0; i<s.length(); i++){

            alphabetArr[i] = ((s.charAt(i)-'a')+1)%27;
        }

        long sum = 0;
        for(int i=0; i<size; i++){
            int num = alphabetArr[i];
            double pow = Math.pow(31, i);
            sum+= (long) (num*pow);
        }
        System.out.println(sum);
    }

}
