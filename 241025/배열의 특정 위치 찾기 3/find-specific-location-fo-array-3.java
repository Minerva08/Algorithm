import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int value1 = Integer.parseInt(st.nextToken());

        int value2 = Integer.parseInt(st.nextToken());

        int value3 = Integer.parseInt(st.nextToken());
    
        int value4 = Integer.parseInt(st.nextToken());

        while(value4!=0){
            value1=value2;
            value2 = value3;
            value3 = value4;
            value4 = Integer.parseInt(st.nextToken());
            
        }

        System.out.println(value1+value2+value3);
    
    }


}