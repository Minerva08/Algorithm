package com.example.algorithm.trie;

import java.util.*;

public class BJN_2179 {

    // 단어의 공통 접두사 길이를 계산하는 메서드
    private static int calculateCommonPrefixLength(String word1, String word2) {
        int minLength = Math.min(word1.length(), word2.length());
        int commonPrefixLength = 0;
        for (int i = 0; i < minLength; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                commonPrefixLength++;
            } else {
                break;
            }
        }
        return commonPrefixLength;
    }

    // DFS 탐색을 통해 가장 비슷한 단어 쌍을 찾는 메서드
    private static void dfs(List<String> words, int current, int maxPrefixLength, String[] resultPair, int[] bestPrefixLength) {
        if (current == words.size()) {
            return; // 종료 조건
        }

        for (int i = current + 1; i < words.size(); i++) {
            int commonPrefixLength = calculateCommonPrefixLength(words.get(current), words.get(i));

            // 접두사 길이가 더 길거나, 같은 길이일 경우 입력 순서대로 비교
            if (commonPrefixLength > maxPrefixLength) {
                maxPrefixLength = commonPrefixLength;
                resultPair[0] = words.get(current);
                resultPair[1] = words.get(i);
                bestPrefixLength[0] = maxPrefixLength;
            } else if (commonPrefixLength == maxPrefixLength) {
                int index1 = words.indexOf(resultPair[0]);
                int index2 = words.indexOf(resultPair[1]);
                int indexCurrent = words.indexOf(words.get(current));
                int indexI = words.indexOf(words.get(i));

                // 먼저 나온 단어 순서대로 resultPair에 설정
                if (indexCurrent < index1 || (indexCurrent == index1 && indexI < index2)) {
                    resultPair[0] = words.get(current);
                    resultPair[1] = words.get(i);
                }
            }
        }

        // DFS 재귀 호출
        dfs(words, current + 1, maxPrefixLength, resultPair, bestPrefixLength);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int n = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }

        int maxPrefixLength = 0; // 최대 접두사 길이
        String[] resultPair = new String[2]; // 결과 단어 쌍
        int[] bestPrefixLength = new int[1]; // 현재까지의 최대 접두사 길이

        // DFS 탐색을 시작
        dfs(words, 0, maxPrefixLength, resultPair, bestPrefixLength);

        // 결과 출력
        System.out.println(resultPair[0]);
        System.out.println(resultPair[1]);
    }
}
