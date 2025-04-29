package com.example.algorithm.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class BJN_31562 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int knownCnt = Integer.parseInt(st.nextToken());

        int tryCnt = Integer.parseInt(st.nextToken());


        HashMap<String, String> song = new HashMap<>();

        String[] result = new String[tryCnt];

        for(int i=0; i<knownCnt; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            String title = st.nextToken();

            String a = "";
            for(int j=0; j<7;j++){
                a+=st.nextToken();
            }
            song.put(title, a);

        }

        for(int i=0; i<tryCnt; i++){
            st = new StringTokenizer(br.readLine());

            String intro="";
            for(int j=0; j<3; j++){
                intro += st.nextToken();

            }
            int cnt = 0;
            String title="";
            for (Entry<String, String> entry : song.entrySet()) {

                if(entry.getValue().substring(0,3).equals(intro)){
                    title = entry.getKey();
                    cnt++;
                }
            }
            if(cnt==0){
                result[i]="!";
            }
            else if(cnt==1){
                result[i]=title;
            }
            else if(cnt>=2){
                result[i] = "?";
            }


        }

        for (String s : result) {
            System.out.println(s);
        }


    }

}
