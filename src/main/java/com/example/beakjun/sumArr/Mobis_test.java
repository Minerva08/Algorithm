package com.example.beakjun.sumArr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Mobis_test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalFlag = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] flags = new int[totalFlag];
        for(int i=0; i<totalFlag; i++){

            flags[i] = st.nextToken().charAt(0) == 'R' ? 1:0;

        }

        int[] sumFlags = new int[totalFlag+1];
        for(int i=1;i<=totalFlag;i++){
            sumFlags[i] = sumFlags[i-1]+flags[i-1];

        }


        st = new StringTokenizer(br.readLine());
        int passFlag = Integer.parseInt(st.nextToken());

        int startPoint=0;
        int start =1;
        int end = 1;
        while (start<sumFlags.length && end<sumFlags.length){
            int endRed = sumFlags[end];
            int startRed= sumFlags[start];

            if (end-(start-1)==passFlag){
                boolean addOne = sumFlags[start - 1] != startRed;
                if(endRed-startRed+(addOne?1:0)>=2){
                    startPoint = (start);
                    bw.write(startPoint+" ");
                }
                end ++;
                continue;
            }
            if(end-(start-1) < passFlag){
                end ++;
                continue;
            }
            if(end-(start-1) > passFlag){
                start ++;
                continue;
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
