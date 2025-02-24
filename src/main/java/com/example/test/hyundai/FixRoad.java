package com.example.test.hyundai;

import java.util.*;

public class FixRoad {
    private static boolean canCoverHoles(int[] holes, int patchLength, int patchCount) {
        int patchesUsed = 0;
        int i = 0;
        int n = holes.length;

        // 구멍을 덮을 때까지 반복
        while (i < n) {
            patchesUsed++; // 새로운 패치 사용
            int maxCoverPosition = holes[i] + patchLength - 1; // 현재 패치로 덮을 수 있는 최대 위치

            // 현재 패치로 덮을 수 있는 구멍의 끝까지 이동
            while (i < n && holes[i] <= maxCoverPosition) {
                i++;
            }

            // 패치 개수를 초과할 경우 실패
            if (patchesUsed > patchCount) {
                return false;
            }
        }
        return true;
    }

    // 이진 탐색을 사용하여 필요한 패치 길이의 최대값을 찾는 함수
    public static int findMaxPatchLength(int[] holes, int patchCount) {
        Arrays.sort(holes); // 구멍 위치 정렬
        int left = 1; // 최소 가능한 패치 길이
        int right = holes[holes.length - 1] - holes[0] + 1; // 최대 가능한 패치 길이

        // 이진 탐색으로 패치 길이 조정
        while (left < right) {
            int mid = (left + right) / 2;

            // 현재 길이로 덮을 수 있으면 더 작은 길이를 시도
            if (canCoverHoles(holes, mid, patchCount)) {
                right = mid; // 패치 길이 줄임
            } else {
                left = mid + 1; // 패치 길이 늘림
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] holes = {6, 7, 8, 9}; // 구멍 위치
        int patchCount = 3; // 사용 가능한 패치 개수

        // 최대 패치 길이 계산
        int maxPatchLength = findMaxPatchLength(holes, patchCount);

        // 결과 출력
        System.out.println("필요한 보수패치의 최대 길이: " + maxPatchLength); // 예상 결과는 3
    }

}
