package com.example.algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJN_1374 {

    static class Lecture implements Comparable<Lecture>{
        int no;
        int start;
        int end;

        public Lecture(int no, int start, int end){
            this.no = no;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {

            if(this.start == o.start)
                return this.end - o.end;
            return this.start - o.start;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Lecture[] arr = new Lecture[cnt];

        for(int i=0; i<cnt; i++){
            arr[i] = new Lecture(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());

        }

        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < cnt; ++i) {
            if (pq.isEmpty()) {
                pq.add(arr[i].end);
            } else {
                int endTime = pq.peek();
                if (arr[i].start < endTime) {
                    pq.add(arr[i].end);
                } else {
                    pq.poll();
                    pq.add(arr[i].end);
                }
            }
        }

        System.out.println(pq.size());

    }

}
