import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());        
        int sum = 0;
        
        for(int i=1; i<=10; i++){
            int value = Integer.parseInt(st.nextToken());

            if(i==3 || i==5 || i==10){

                sum+=value;
            }
        }
        System.out.println(String.valueOf(sum));
        
    }
}