package com.example.algorithm.BruteForce;

import java.io.*;
import java.util.*;

public class P_Permutation {
    static int[] cards;

    static Set<Integer> nums = new HashSet();

    static int depth = 0;

    static Boolean[] used;


    // 순열
    // 카드로 만들 수 있는 모든 숫자 구하기
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 카드 개수
        int cardCnt = Integer.parseInt(st.nextToken());

        cards = new int[cardCnt];

        int answer = 0;

        for(int i=0 ;i <cardCnt; i++){
            st= new StringTokenizer(br.readLine());

            cards[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=0; i< cards.length; i++){
            depth=0;
            used = new Boolean[cardCnt];
            Arrays.fill(used,false);

            nums.add(cards[i]);
            used[i]=true;
            dfs(cards[i]);

        }
        System.out.println("개수 :"+nums.size());

        for (Integer num : nums) {
            System.out.println("생성 : "+num);
        }

        for (Integer num : nums) {
            int cnt = 0;

            for(int i=2; i<Math.sqrt(num); i++){
                if(num%i==0){
                    cnt++;
                }
            }

            if(cnt==0 && num!=0 && num !=1){
                System.out.println(num);
                answer++;
            }
        }

    }

    public static void dfs(int num){
        if(depth==nums.size()){
            return;
        }

        depth++;

        for(int i=0; i<cards.length; i++){
            if(!used[i]){
                used[i]=true;
                String cardNum = new StringBuilder().append(num).append(cards[i]).toString();
                nums.add(Integer.parseInt(cardNum));
                dfs(Integer.parseInt(cardNum));
                used[i]=false;

            }

        }


    }


}
