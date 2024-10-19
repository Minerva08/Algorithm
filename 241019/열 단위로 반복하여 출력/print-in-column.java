import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());

        for(int i=0; i<cnt; i++){
            for(int j=1; j<=cnt;j++){
                System.out.printf(String.valueOf(i+1));

            }
            System.out.println();
        }

    
    }
}