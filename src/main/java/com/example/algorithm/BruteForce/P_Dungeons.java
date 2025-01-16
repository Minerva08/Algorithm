package com.example.algorithm.BruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P_Dungeons {


    /**
     * 우선순위 큐  =  그리디에 적합
     *
     * 아래의 문제는 완전탐색 = dfs
     * */
    public static int p ;

    public static class Dungeon implements Comparable<Dungeon> {

        int min;
        int spend;


        public Dungeon(int min, int spend) {
            this.min = min;
            this.spend = spend;
        }

        @Override
        public int compareTo(Dungeon dungeon) {

            if (this.min < p && dungeon.min < p) {
                return this.spend - dungeon.spend;
            }
            return dungeon.min - this.min;

        }
    }

    public static void main(String[] args) {

        int result = solution( 80,new int[][]{{80,20},{50,40},{30,10}});
        System.out.print("결과 : "+result);



    }


    public static int solution(int k, int[][] dungeons) {
        p=k;
        int cnt = 0;

        Dungeon[] playList = new Dungeon[dungeons.length];

        for(int i=0; i< dungeons.length; i++){
            playList[i]= new Dungeon(dungeons[i][0], dungeons[i][1]);
        }

        Arrays.sort(playList);

        PriorityQueue<Dungeon> pq = new PriorityQueue<>();

        for (Dungeon dungeon : playList) {
            pq.add(dungeon);
        }


        while(!pq.isEmpty()){
            if(k<pq.peek().min || k<pq.peek().spend){
                break;
            }
            k-=pq.peek().spend;
            pq.poll();
            cnt ++;
        }
        return cnt;

    }

}
