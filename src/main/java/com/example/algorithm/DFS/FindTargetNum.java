package com.example.algorithm.DFS;

public class FindTargetNum {

    static int sum;
    static int cnt;
    static int[] nums;
    static int size;

    public static void main(String[] args) {
        int result = solution(new int[]{1,1,1,1,1},3);
        System.out.println(result);
    }

    public static int solution(int[] numbers, int target) {
        int result = 0;
        sum = target;
        nums = new int[numbers.length];
        cnt = 0;

        for(int i=0; i<numbers.length; i++){
            nums[i] = numbers[i];
        }
        size = numbers.length;


        dfs(0,0);

        return cnt;
    }

    public static void dfs(int i,int result){

        if( i == size){
            if(sum==result){
                cnt++;

            }return;
        }

        dfs(i + 1, result + nums[i]);
        dfs(i + 1, result - nums[i]);



    }
}


