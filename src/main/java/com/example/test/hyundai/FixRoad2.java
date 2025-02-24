package com.example.test.hyundai;


public class FixRoad2 {

    public static void main(String[] args) {
        int[] holeArr = {3,5,7,8,9};
        int patchCnt = 3;
        int left =1;
        int right = holeArr[holeArr.length-1];
        int patchLength =  holeArr[holeArr.length-1];

        int result = binarySearch(holeArr,left,right,patchCnt);
        System.out.println("패치 최소 길이 : "+result);

    }

    public static int binarySearch(int[] holeArr,int left,int right,int patchCnt){

        if(left>right){
            return -1;
        }

        int useCnt=0;
        int midPathLength = (left+right)/2;
        int i = 0;
        int n = holeArr.length;

        // 구멍을 덮을 때까지 반복
        while (i < n) {
            useCnt++; // 새로운 패치 사용
            int maxCoverPosition = holeArr[i] + midPathLength - 1; // 현재 패치로 덮을 수 있는 최대 위치

            // 현재 패치로 덮을 수 있는 구멍의 끝까지 이동
            while (i < n && holeArr[i] <= maxCoverPosition) {
                i++;
            }

        }


        // 패치 개수를 초과할 경우 실패
        if(useCnt>patchCnt){
            return binarySearch(holeArr,midPathLength+1,right,patchCnt);
        }else{
            int bestLength = binarySearch(holeArr, left, midPathLength - 1, patchCnt); // 패치 길이를 줄임
            return bestLength == -1 ? midPathLength : Math.min(bestLength, midPathLength); // 최적의 패치 길이를 반환
        }


    }

}
