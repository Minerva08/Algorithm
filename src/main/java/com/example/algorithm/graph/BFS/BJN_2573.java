package com.example.algorithm.graph.BFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJN_2573 {
    // 바닷물에 의해 빙산이 녹고 있다
    // 빙산이 둘 이상으로 나누어지기 위해 걸리는 햇수는?

    public static class IceBugNode {
        int x,y;

        public IceBugNode(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] dir = new int[][]{{1,0},{0,-1},{-1,0},{0,1}};
    static int[][] graph;
    static int[][] melted;
    static int[][] visited;
    static int width;
    static int height;

    static int iceGroup=0;

    static Queue<IceBugNode> bfsQueue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //init graph
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        graph = new int[height][width];
        visited = new int[height][width];
        int year = 0;

        for(int i=0; i<height; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<width; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        iceGroup=0;
        while(iceGroup<=1){
            int count =0;
            melted =new int[height][width];
            visited = new int[height][width];

            // 빙산을 녹이기 전의 상태 복사하여 새롭게 녹이기
            int[][] nextGraph = new int[height][width];


            // 녹은 후 빙산 덩어리 bfs로 찾기
            for(int i=0; i<height;i++){
                for(int j=0; j<width; j++){
                    if(graph[i][j]>0 && visited[i][j]==0){

                        bfs(i, j);
                        iceGroup++;
                    }

                }
            }

            if (count == 0) {
                System.out.println(0);
                return;
            }
            if (count > 1) {
                System.out.println(year);
                return;
            }
            year++;



            // 빙산 녹이기
            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){
                    // 이 부부을 추가했어
                    if(graph[i][j]>0){
                        melted[i][j] = 1;

                        int seaCount = 0;

                        for(int k=0; k<dir.length; k++){
                            int dirX = dir[k][0]+i;
                            int dirY = dir[k][1]+j;

                            if(dirX>=0 && dirY>=0 && dirX<height && dirY<width ){
                                if(graph[dirX][dirY]==0 && melted[dirX][dirY]==0){
                                    seaCount++;
                                }
                            }
                        }
                        nextGraph[i][j] = Math.max(0, graph[i][j] - seaCount);
                    }

                }
            }

            // 빙산 업데이트
            graph = nextGraph;

        }
    }

    public static void bfs(int x, int y){

        bfsQueue = new LinkedList<>();
        bfsQueue.add(new IceBugNode(x, y));
        visited[x][y]=1;


        while (!bfsQueue.isEmpty()) {
            IceBugNode current = bfsQueue.poll(); // 큐에서 노드를 꺼내서 탐색 시작
            int curX = current.x;
            int curY = current.y;

            for (int k = 0; k < dir.length; k++) {
                int dirX = curX + dir[k][0];
                int dirY = curY + dir[k][1];

                if (dirX >= 0 && dirX < height && dirY >= 0 && dirY < width) {
                    if (graph[dirX][dirY] > 0 && visited[dirX][dirY] == 0) {
                        visited[dirX][dirY] = 1; // 새롭게 방문한 위치 표시
                        bfsQueue.add(new IceBugNode(dirX, dirY));
                    }
                }
            }
        }

    }

}
