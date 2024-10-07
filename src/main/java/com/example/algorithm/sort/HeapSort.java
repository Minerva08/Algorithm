package com.example.algorithm.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        heapSort(arr);
        System.out.println("힙 정렬 (내림차순): " + Arrays.toString(arr));
    }
    public static void heapSort(int[] arr) {
        // 1단계: 최소 힙을 구성한다.
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(i, arr.length,arr);
        }

        // 2단계: 최소 힙에서 최솟값을 배열 뒤로 보내면서 내림차순으로 정렬한다.
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);  // 배열의 첫 번째 요소(최솟값)와 마지막 요소를 교체
            heapify( 0, i,arr);  // 남은 부분을 다시 최소 힙으로 정렬
        }
    }

    public static void heapify(int parentIdx,int size, int[] arr){
        int smallest = parentIdx;
        int left = parentIdx*2+1;
        int right = parentIdx*2+2;

        if(left < size && arr[smallest] > arr[left] ){
            smallest=left;
        }

        if(right < size && arr[smallest] > arr[right] ){
            smallest=right;

        }

        if(parentIdx!=smallest){
            swap(arr,parentIdx,smallest);
            heapify(smallest,size,arr);
        }

    }

    private static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
