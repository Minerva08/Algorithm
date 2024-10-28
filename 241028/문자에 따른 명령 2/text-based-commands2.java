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
        int initY = 0;
        int initdir = 3;
        
        String str = st.nextToken();
        char[] moveArr = str.toCharArray();

        int dirX = 0;
        int dirY = 0;

        for(int i=0; i<moveArr.length; i++){

            int dirNum = convertDir(initdir, initX,initY, moveArr[i]);

            if(dirNum<4){
                dirX = dx[dirNum];
                dirY = dy[dirNum];
            }else{
                initX = dirX*1;
                initY = dirY*1;
            }
            initdir = dirNum;
        } 
        System.out.print(initX+" "+initY);

    }

    public static int convertDir(int initdir, int initX, int initY,char moveDir){
        
        if(moveDir=='L') {
            return (initdir==0)?3:(initdir-1);
        }
        if(moveDir=='R'){
            return (initdir==3)?0:(initdir+1);

        }
        
        return 4;
        

    }
}