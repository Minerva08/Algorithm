package com.example.algorithm.BruteForce;

import java.util.*;

public class P_Dictionary {

    static char[] alphabet = new char[] {'A','E','I','O','U'};;
    static int[] used= new int[alphabet.length];;
    static Set<String> words;
    static int depth;

    public static void main(String[] args){
       words= new HashSet<>();
       Arrays.fill(used,0);

        for(int i=0; i<alphabet.length; i++){
            String alpha = String.valueOf(alphabet[i]);
            words.add(alpha);
            depth++;
            dfs(alpha);
            depth=0;
            Arrays.fill(used,0);
        }


        System.out.println("개수 : "+words.size());
        for (String word : words) {
            System.out.println(word);
        }

    }

    public static void dfs(String alpha){
        if(depth==5){
            return;
        }

        depth++;

       for(int i=0; i<alphabet.length;i++){

           if(used[i]==0){
               used[i] = 1;
               String sb = alpha + alphabet[i];
               words.add(sb);
               used[i]=0;
               dfs(sb);

           }

       }
       depth--;
    }




}
