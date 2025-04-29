package com.example.algorithm.graph.DFS.backtracking;

import java.util.*;
import java.io.*;

public class BJN_2529 {

    static int n;
    static String[] sign;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        sign = new String[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sign[i] = st.nextToken();
        }

        // DFS 탐색을 0부터 9까지 모든 숫자에 대해 시작
        for (int i = 0; i < 10; i++) {
            int[] usedArr = new int[10]; // 숫자 사용 여부 배열
            usedArr[i] = 1; // 현재 숫자는 이미 사용했다고 표시

            dfs(i, 0, usedArr, new StringBuilder().append(i));
        }

        // 결과값 출력 (최대값과 최소값)
        String min = Collections.min(result);
        String max = Collections.max(result);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int beforeNum, int signIdx, int[] used, StringBuilder sb) {
        // 모든 부등호를 만족했으면 결과를 리스트에 추가
        if (signIdx >= n) {
            result.add(sb.toString());
            return;
        }

        String signFlag = sign[signIdx]; // 현재 부등호

        // 가능한 모든 숫자에 대해 탐색
        for (int i = 0; i < 10; i++) {
            if (used[i] == 1) { // 이미 사용된 숫자는 건너뛰기
                continue;
            }

            // 부등호에 맞는 숫자를 선택
            if ((signFlag.equals("<") && beforeNum < i) || (signFlag.equals(">") && beforeNum > i)) {
                used[i] = 1; // 숫자 사용 표시
                sb.append(i); // 숫자를 문자열에 추가

                // 다음 부등호로 탐색
                dfs(i, signIdx + 1, used, sb);

                // 백트래킹: 문자열과 배열을 원상복구
                used[i] = 0; // 숫자 사용 해제
                sb.deleteCharAt(sb.length() - 1); // 마지막 숫자 제거
            }
        }
    }
}
