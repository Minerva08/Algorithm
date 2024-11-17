package com.example.algorithm.graph.BFS;

public class BJN_25195_Node {

    static class Node implements Comparable<Node> {
        int index;
        int cost;
        public Node(int index,int cost){
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node){
            return Integer.compare(this.cost,node.cost);
        }
    }

    public static void main(String[] args) {

    }

}
