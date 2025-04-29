package com.example.algorithm.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJN_5052 {

    static class Node{
        Node[] children = new Node[10];
        boolean isEnd = false;
    }

    public static class Trie{
        Node rootNode = new Node();

        public void insert(String str){
            Node currentNode = this.rootNode;

            for(int i=0; i<str.length(); i++){
                int index = Integer.parseInt(String.valueOf(str.charAt(i)));

                if(currentNode.children[index]==null){
                    currentNode.children[index] = new Node();

                }

                currentNode = currentNode.children[index];

                if(i==(str.length()-1)){
                    currentNode.isEnd=true;
                }

            }


        }

        public boolean prefixSearch(String str){
            Node currentNode = this.rootNode;

            for(int i=0; i<str.length(); i++){
                int index = Integer.parseInt(String.valueOf(str.charAt(i)));

                if(currentNode.children[index]!=null){
                    currentNode = currentNode.children[index];

                    if(currentNode.isEnd && i<(str.length()-1)){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCnt = Integer.parseInt(st.nextToken());
       String[] arr =  st.nextToken().split(",");
        for (String s : arr) {
            System.out.println(s);
        }

        String[] result = new String[testCnt];
        Arrays.fill(result,"YES");


        for(int i=0; i<testCnt; i++){

            Trie trie = new Trie();
            st = new StringTokenizer(br.readLine());
            int phoneNumCnt = Integer.parseInt(st.nextToken());
            String[] phoneNumArr = new String[phoneNumCnt];

            for(int j=0; j<phoneNumCnt; j++){
                st = new StringTokenizer(br.readLine());

                String phoneNum = st.nextToken();
                phoneNumArr[j] = phoneNum;
                trie.insert(phoneNum);

            }

            for(int k=0; k<phoneNumCnt; k++){
                boolean duplicate = trie.prefixSearch(phoneNumArr[k]);

                if(duplicate){
                    result[i] = "NO";
                    break;
                }

            }
        }

        for (String s : result) {
            System.out.println(s);
        }




    }

}
