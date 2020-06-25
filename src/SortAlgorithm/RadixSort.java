package SortAlgorithm;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {25, 456, 10, 22, 453, 85, 652, 77, 213, 111, 3, 532, 57, 621, 214, 101, 232, 6111, 23, 65};

        radixSort2(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void radixSort2(int[] arr){ // 基数排序是典型的用空间换时间的算法
        int max = arr[0];

        for(int i = 1; i < arr.length; i++){  //获取数组最大值
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();


        int[][] bucket = new int[10][arr.length];  //定义桶
        int[] bucketElementCounts = new int[10];  //记录每个桶放入数据的个数


        for(int i = 0, n = 1; i < maxLength; i++, n *= 10){  // 循环最大数的位数轮
            // 将各个数放入桶中
            for(int j = 0; j < arr.length; j++){
                int digitOfElement = arr[j] / n % 10;

                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement] ++;
            }

            // 将桶中数拿出
            int index = 0;
            for(int k = 0; k < bucket.length; k++){
                if(bucketElementCounts[k] != 0){
                    for(int l=0; l<bucketElementCounts[k]; l++){
                        arr[index++] = bucket[k][l];
                    }
                }

                bucketElementCounts[k] = 0;
            }
        }
     }
}
