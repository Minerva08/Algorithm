import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        // 여기에 코드를 작성해주세요.

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int initX=0 ;
    int initY=0;
    int initDirNum = 3;
    int[] dx = new int[]{1,0,-1,0};
    int[] dy = new int[]{0,-1,0,1};

    String str = st.nextToken();

    char[] moveArr = str.toCharArray();

    for(int i=0; i<moveArr.length; i++){
        int dirNum = initDirNum;

        if(moveArr[i]=='F'){
            initX += dx[dirNum];
            initY += dy[dirNum];

        }else{
            if(moveArr[i]=='R'){
                dirNum = (dirNum+1)%4;
            }
            if(moveArr[i]=='L'){
                dirNum = (dirNum-1+4)%4;
            }

            initDirNum = dirNum;
        }

    }

    System.out.print(initX+" "+initY);
    
    }

}