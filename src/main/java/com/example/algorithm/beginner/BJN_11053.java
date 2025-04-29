package com.example.algorithm.beginner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJN_11053 {
    /**
     * 알고리즘
     * - LIS (Longest Increasing Subsequence)
     * - 증가하는 부분 수열 중 최대 길이 찾기
     * - DP + Binary Search (Lower Bound 활용)
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> subNums = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int idx = lowerBound2(subNums, arr[i]);

            if (idx < subNums.size()) {
                subNums.set(idx, arr[i]); // 기존 값을 대체
            } else {
                subNums.add(arr[i]); // 새로운 값 추가
            }
        }

        System.out.println(subNums.size()); // LIS 길이 출력
    }

    // 🔹 Lower Bound 구현 (target 이상이 처음 나오는 위치 찾기)
    static int lowerBound(List<Integer> subNums, int target) {
        int left = 0, right = subNums.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (subNums.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left; // 삽입 위치 반환
    }

    static int lowerBound2(List<Integer> subNums, int target) {
        int left = 0, right = subNums.size();
        int bound = subNums.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (subNums.get(mid) >= target) {
                bound = Math.min(bound, mid);
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return bound; // 삽입 위치 반환
    }
}
