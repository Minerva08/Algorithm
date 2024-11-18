package com.example.algorithm.BruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carpet {

    /**
     * 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
     * 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
     * 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
     */
    public static void main(String[] args) {
        solution(24,24);
    }

    public static int[] solution(int brown, int yellow) {

        int total = brown+yellow;

        List<Integer> totalYagsu = new ArrayList<>();
        List<Integer> yellowYagsu = new ArrayList<>();

        // 약수 탐색을 제곱근까지만 수행
        for (int i = 1; i * i <= total; i++) {
            if (total % i == 0) {
                totalYagsu.add(i); // 작은 약수 추가
            }
        }

        // 약수 탐색을 제곱근까지만 수행
        for (int i = 1; i * i <= yellow; i++) {
            if (yellow % i == 0) {
                yellowYagsu.add(i); // 작은 약수 추가
            }
        }


        //카펫의 가로, 세로 크기
        int[] answer = new int[2];

        for(int i=0; i<totalYagsu.size();i++){
            if(totalYagsu.get(i)<3){
                continue;
            }
            int width = Math.max(totalYagsu.get(i),(total/totalYagsu.get(i)));
            int height = Math.min(totalYagsu.get(i),(total/totalYagsu.get(i)));

            for(int j=0; j<yellowYagsu.size();j++){
                int yellowHeight = Math.min(yellowYagsu.get(j),(yellow/yellowYagsu.get(j)));
                int yellowWidth = Math.max(yellowYagsu.get(j),(yellow/yellowYagsu.get(j)));

                if(((height-2) == yellowHeight) && ((width-2) ==yellowWidth)){
                    answer[0] = width;
                    answer[1] = height;
                    return answer;
                }

            }

        }
        return answer;
    }

}
