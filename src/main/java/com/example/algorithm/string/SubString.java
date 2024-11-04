package com.example.algorithm.string;

public class SubString {

    public static void main(String[] args) {
       int result =  solution("10203","15");
        System.out.println(result);
    }

    public static int solution (String t, String p){
        int answer = 0;
        int tSize = t.length();
        int pSize = p.length();
        long pLong = Long.parseLong(p);

        for(int i=0; i<=(tSize-pSize);i++){
            String str = "";
            for(int j=i;j<(i+pSize);j++){
                str+=String.valueOf(t.charAt(j));
            }
            if(Long.parseLong(str)<=pLong){
                answer++;
            }
        }
        return answer;
    }
}
