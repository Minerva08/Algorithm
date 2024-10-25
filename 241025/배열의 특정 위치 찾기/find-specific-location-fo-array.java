import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum =0;

        int avg = 0;

        for(int i=1; i<=10; i++){
            int value = Integer.parseInt(st.nextToken());
            if(i%2==0){
                sum+=value;
            }
            if(i%3==0){
                avg+=value;
            }
        }

        System.out.print(sum+" "+Math.round((avg/3)*100)/100.0);
    
    }
}