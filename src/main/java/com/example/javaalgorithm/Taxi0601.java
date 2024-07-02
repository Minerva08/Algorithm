package com.example.javaalgorithm;

public class Taxi0601 {
    public static void main(String[] args) {
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        int solution = solution(6, 4, 6, 2, fares);
        System.out.println(solution);

    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {

        int[][] edge = new int[200][200];
        final int INF = 400000000;

        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                if(i==j){
                    edge[i][j]=0;
                }else{
                    edge[i][j]=INF;
                }
            }
        }

        for(int[] fare: fares){
            int departure = fare[0]-1;
            int arrival = fare[1]-1;
            edge[departure][arrival] = fare[2];
            edge[arrival][departure]=fare[2];
        }

        for(int k=0; k<n;k++ ){
            for(int i=0; i<n;i++){
                for(int j=0; j<n; j++){
                    edge[i][j] = Math.min(edge[i][j],edge[i][k]+edge[k][j]);
                }
            }
        }

        --s;
        --a;
        --b;


        int answer = INF;

        for(int k=0;k<n;k++){
            answer = Math.min(answer,edge[s][k]+edge[k][a]+edge[k][b]);
        }
        return answer;
    }
}
