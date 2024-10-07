package com.example.algorithm.recursive;

import java.util.HashMap;

public class Combination {
    private static HashMap<String, Integer> memozation = new HashMap<>();

    public static void main(String[] args){
        int n = 5;
        int r = 3;
        int result = combi(n,r);


        System.out.println(n+"C"+r+":"+result);
    }

    public static int combi(int n, int r){
        if(n==r || r == 0){
            return 1;
        }

        String key = n+"C"+r;
        if(memozation.containsKey(key)){
            return memozation.get(key);
        }
        int result = combi(n-1,r)+combi(n-1,r-1);

        memozation.put(key,result);

        return result;

    }

}
