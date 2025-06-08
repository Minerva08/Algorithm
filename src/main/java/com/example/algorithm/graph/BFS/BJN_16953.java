package com.example.algorithm.graph.BFS;

import java.io.*;
import java.util.*;

public class BJN_16953 {

    static class Node {
        long num;
        int step;

        public Node(long num, int step) {
            this.num = num;
            this.step = step;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        Set<Long> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(a, 1));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.num == b) {
                System.out.println(cur.step);
                return;
            }

            if (cur.num > b || !visited.add(cur.num)) {
                continue;
            }

            queue.offer(new Node(cur.num * 2, cur.step + 1));
            queue.offer(new Node(cur.num * 10 + 1, cur.step + 1));
        }

        System.out.println(-1);
    }
}
