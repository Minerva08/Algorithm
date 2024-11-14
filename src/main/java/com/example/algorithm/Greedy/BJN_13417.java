package com.example.algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJN_13417 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int trierCnt = Integer.parseInt(st.nextToken());
        StringBuilder total = new StringBuilder();

        for(int i=0; i<trierCnt; i++){
            StringBuilder stb = new StringBuilder();

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            char[] Narr = new char[N];

            st = new StringTokenizer(br.readLine());

            for(int j = 0;j<N;j++){
                Narr[j]= st.nextToken().toCharArray()[0];

            }


            stb.append(Narr[0]);

            for(int k=1;k<Narr.length;k++){

                if(Narr[k]<=stb.charAt(0)){
                    stb.insert(0,Narr[k]);
                }else{
                    stb.append(Narr[k]);
                }
            }
            total.append(stb).append("/");
        }


        for(int i=0; i<trierCnt;i++){
            System.out.println(total.toString().split("/")[i]);

        }
    }

}
