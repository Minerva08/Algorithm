import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};

        int initX = 0;
        int initY=0;
        int initdir = 3;
        
        int dirNum = convertDir(initdir,st.nextToken());
        
        
        initX = dx[dirNum];
        initY = dy[dirNum];
        System.out.print(initX+" "+initY); 
        

    }

    public static int convertDir(int initdir, String dir){
        
        if(dir.equals("LF")) {
            return (initdir==0)?3:(initdir-1);
        }
        return (initdir==3)?0:(initdir+1);


    }
}