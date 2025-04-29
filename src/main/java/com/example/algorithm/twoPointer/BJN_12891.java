package com.example.algorithm.twoPointer;
import java.util.*;
import java.util.Map.Entry;

public class BJN_12891 {


    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        int totalLength = sc.nextInt();
        int subLength = sc.nextInt();

        char[] arr = sc.next().toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        map.put('A',sc.nextInt());
        map.put('C',sc.nextInt());
        map.put('G',sc.nextInt());
        map.put('T',sc.nextInt());

        int cnt = 0;
        int start = 0;
        for(int end=0; end<totalLength; end++){
            map.put(arr[end],map.get(arr[end])-1);

            while((end-start+1)>subLength){
                map.put(arr[start],map.get(arr[start])+1);
                start++;
            }

            if((end-start+1)==subLength){
                boolean enough = true;
                for (Entry<Character, Integer> c : map.entrySet()) {
                    if(c.getValue()>0){
                        enough = false;
                        break;
                    }
                }
                if(enough){
                    cnt++;
                }
            }


        }


        System.out.println(cnt);
    }

}
