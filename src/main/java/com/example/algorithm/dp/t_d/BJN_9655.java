package com.example.algorithm.dp.t_d;

import java.util.*;

public class BJN_9655 {


    /**
     * 입력
     *    돌의 개수
     *
     * 로직
     *    돌이 0이 될때까지 재귀(dfs) -> 돌 <=0 이면 종료
     *    + 메모제이션[남은 돌 개수][차례(상근/창영)]
     *    상근 = 0(짝수개) / 창영 = 1(홀수개)
     *
     *
     * 결과
     *   남은 개수가 0일때의 차례인 사람이 승리
     *
     * */

        static Boolean[][] memo;

        // turn: true -> 상근, false -> 찬영
        static boolean dfs(int n, boolean turn) {
            if (n == 0) {
                // 돌을 가져갈 수 없으면 현재 차례 패배
                return false;
            }
            if (memo[n][turn ? 1 : 0] != null) {
                return memo[n][turn ? 1 : 0];
            }

            boolean canWin = false;

            // 1개 가져가서 상대가 지면 현재가 이김
            if (n - 1 >= 0 && !dfs(n - 1, !turn)) {
                canWin = true;
            }
            // 3개 가져가서 상대가 지면 현재가 이김
            if (n - 3 >= 0 && !dfs(n - 3, !turn)) {
                canWin = true;
            }

            memo[n][turn ? 1 : 0] = canWin;
            return canWin;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();

            memo = new Boolean[N + 1][2];
            boolean result = dfs(N, true);

            System.out.println(result ? "SK" : "CY");
        }

    }


