package com.example.algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJN_2847 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;

        int trier = Integer.parseInt(st.nextToken());

        int[] points = new int[trier];

        for(int i=0; i<trier; i++){
            st = new StringTokenizer(br.readLine());
            points[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=(trier-1); i>0; i--){
            if(points[i]<=points[i-1]){
                while(points[i]<=points[i-1]){
                    points[i-1]--;
                    result ++;
                }
            }
        }

        System.out.println(result);


    }

}
