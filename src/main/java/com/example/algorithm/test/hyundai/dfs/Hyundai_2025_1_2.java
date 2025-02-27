package com.example.algorithm.test.hyundai.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Hyundai_2025_1_2 {

    /**
     *
     * 1. 입력
     *      목표점수 과녁크기
     *      과녁 점수(이차원 배열)
     *      화살개수 화살두께
     *
     *
     * 2. 로직
     *      2-1. 화살의 득점 경우의 수 완탐
     *      2-1-1. dfs
     *             각 화살별 배열 순회
     *
     *      2-2. 득점 환산
     *      2-2-1. 화살 두께 내 점수 득점
     *
     *
     *
     * 3. 출력
     *      3-1. 맞힌 과녁 목록
     *      3-2. 목표점수 달성 불가능 == -1
     * */

    static int[][] target;
    static int size =0;
    static int arrowCnt = 0;
    static int goalScore=0;
    static boolean exist = false;
    static List<Integer> result ;

    static int[] arrowTypes;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size =  Integer.parseInt(st.nextToken());
        goalScore = Integer.parseInt(st.nextToken());

        target = new int[size][size];

        for(int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++){
                target[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        st = new StringTokenizer(br.readLine());

        arrowCnt = Integer.parseInt(st.nextToken());
        arrowTypes = new int[arrowCnt];



        for(int i=0; i<arrowCnt; i++){
            arrowTypes[i] = Integer.parseInt(st.nextToken());

        }


        for(int  k=0; k<arrowCnt; k++){

            List<Integer> availableArrows = Arrays.stream(arrowTypes).boxed().collect(Collectors.toList());;
            System.out.println("화살 두께 : "+arrowTypes[k]);

            dfs(0,availableArrows,new ArrayList<>(),1,k);

        }

        if(exist){
            System.out.println("결과");
            for (int i : result) {
                System.out.print(i+" ");
            }
        }else{
            System.out.println("결과");
            System.out.println(-1);
        }

    }

    public static int getPoint(int x, int y, int thick){
        System.out.println("현위치: "+x+","+y);
        System.out.println("두께 : "+thick);

        int score = 0;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){

                double dist = Math.sqrt(Math.pow(i - x, 2) + Math.pow(j - y, 2));
                System.out.println(i+","+j+"와 거리 : "+dist);
                if(dist<=((double) thick /2)){
                    System.out.println("점수 :"+target[i][j]);
                    score +=target[i][j];
                }
            }
        }
        System.out.println("총 획득 점수 : "+score);
        return score;
    }

    static void dfs(int point,List<Integer> availableArrow, List<Integer> targetedArr , int turn, int arrowNum){
        System.out.println(turn+"번째 시도 : "+point);
        for (Integer i : targetedArr) {
            System.out.println(i);
        }

        if(point==5){
            System.out.println("555");
        }


        System.out.println("------");


        if(exist){
            return;
        }



        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){


                for(int k=0; k<availableArrow.size();k++){
                    List<Integer> newTargeted = new ArrayList<>(targetedArr);
                    newTargeted.add(target[i][j]);

                    List<Integer> newAvailable = new ArrayList<>(availableArrow);
                    newAvailable.remove(k);


                    int updatePoint = point+ getPoint(i,j,availableArrow.get(k));
                    if(point==5){
                        System.out.println("이후 값: " +updatePoint);
                    }

                    if(updatePoint==goalScore){
                        if(newAvailable.isEmpty() && arrowCnt==turn && newTargeted.size()==arrowCnt){
                            exist = true;
                            result = newTargeted;
                            return;
                        }
                    }
                    if(updatePoint<goalScore && turn<arrowCnt && newTargeted.size()<arrowCnt){
                        dfs(updatePoint,newAvailable,newTargeted, turn+1,k);

                    }


                }
            }
        }

    }

}
