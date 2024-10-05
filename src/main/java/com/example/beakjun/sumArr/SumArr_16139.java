package com.example.beakjun.sumArr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SumArr_16139 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        st = new StringTokenizer(br.readLine());

        int tryCount = Integer.parseInt(st.nextToken());

        int[][] sumByAph = new int[str.length()+1][26];

        for(int i=1; i<=str.length(); i++){
            int charNum = str.charAt(i-1) - 'a';
            for(int j=0;j<26;j++ ){
               int beforeValue= sumByAph[i-1][j];
                sumByAph[i][j] =  ( j == charNum ? beforeValue+1 : beforeValue);

            }

        }


        while(tryCount --> 0){

            st = new StringTokenizer(br.readLine());

            int findChar = st.nextToken().charAt(0)-'a';
            int s = Integer.parseInt(st.nextToken())+1;
            int e = Integer.parseInt(st.nextToken())+1;

            int result = sumByAph[e][findChar] - sumByAph[s-1][findChar];

            bw.write(result+"\n");

        }

        bw.flush();

        bw.close();
        br.close();


    }


}
