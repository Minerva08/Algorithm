import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());

        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};

        int initx = 0;
        int inity = 0;

        for(int i=0; i<cnt; i++){
            st = new StringTokenizer(br.readLine());
            int dirNum = point(st.nextToken());
            int step = Integer.parseInt(st.nextToken());

            int moveX = step*dx[dirNum];
            int moveY = step*dy[dirNum];

            initx+=moveX;
            inity+=moveY;
            
        }
        System.out.print(initx+" "+inity);
    }
    public static int point(String dir){
        
        switch(dir){
            case "E":
                return 0;
            case "S":
                return 1;
            case "W":
                return 2;
            case "N":
                return 3;
        }
        return 5;
    }
}