package com.example.algorithm.graph.BFS.nCr;

import java.util.*;

public class CodeTree_두수뽑기 {
        static int result,k=0;
        static int[] arr;


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            k = sc.nextInt();

            arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            dfs(0,0,new int[n],0);
            // Please write your code here.
            System.out.println(result);

        }



        public static void dfs(int cnt, int start ,int[] used,int sum){
            if(cnt==2){

                if(sum<=k){
                    result++;
                }
                return;
            }
            for(int i=start; i<arr.length; i++){
                int num = arr[i];
                if(used[i]==0){
                    used[i]=1;

                    dfs(cnt+1, i+1,used,(sum+num));
                    used[i]=0;
                }

            }
        }
    }