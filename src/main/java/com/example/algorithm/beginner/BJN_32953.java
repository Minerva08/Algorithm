package com.example.algorithm.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class BJN_32953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subjectCnt = Integer.parseInt(st.nextToken());
        int min =  Integer.parseInt(st.nextToken());

        HashMap<Integer,Integer> attend = new HashMap<>();

        for(int i=0; i<subjectCnt;i++){

            st = new StringTokenizer(br.readLine());
            int peoples = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<peoples;j++){

                int studentNum = Integer.parseInt(st.nextToken());

                if(attend.containsKey(studentNum)) {
                    attend.compute(studentNum, (k, attendCnt) -> (attendCnt + 1));
                }else{
                    attend.put(studentNum,1);
                }
            }

        }

        int cnt =0;
        for (Entry<Integer, Integer> integerIntegerEntry : attend.entrySet()) {
            if(integerIntegerEntry.getValue()>=min){
                cnt++;
            }
        }
        System.out.print(cnt);

    }

}
