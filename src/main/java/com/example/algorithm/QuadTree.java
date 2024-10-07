package com.example.algorithm;

public class QuadTree {
    public static void main(String[] args) {
        int[] result = solution(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}});
        for (int i : result) {
            System.out.println("result :"+i);
        }
    }
    static int[] solution(int[][] arr) {

        int[] answer = new int[]{0,0};

        int size = arr[0].length;
        quadZip(arr,0,0,size,answer);

        return answer;
    }

    static int[] quadZip(int[][] arr, int x, int y, int size,int[] answer ){
//        if(size>=1){
            if(isZip(arr, x, y, size)){
                if(arr[x][y]==0){
                    answer[0]++;
                }else{
                    answer[1]++;
                }
                return answer;
            }

            //1사분면
            quadZip(arr,x,y,size/2,answer);

            //2사분면
            quadZip(arr,x+(size/2),y,size/2,answer);

            //3사분면
            quadZip(arr,x,y+(size/2),size/2,answer);

            //4사분면
            quadZip(arr,x+(size/2),y+(size/2),size/2,answer);

//        }

        return answer;

    }

    static Boolean isZip(int[][] arr,int x, int y, int size){
        for(int i=x; i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(arr[i][j] != arr[x][y]) return false;
            }
        }
        return true;
    }
}
