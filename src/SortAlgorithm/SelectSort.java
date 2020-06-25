package SortAlgorithm;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class SelectSort {
    public static void main(String[] args) {
        multipleTimeTest(100000);
    }

    public static void multipleTimeTest(int number){
        int [] array = new int[number];

        for(int i=0; i<number; i++){
            array[i] = (int) (Math.random() * number);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("Before sorting: " + date1Str);

        int[] sorted_arr = selectSort(array);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("After sorting: " + date2Str);

    }

    public static void inputSort(){
        Scanner sc = new Scanner(System.in);
        int account = sc.nextInt();
        int[] array = new int[account];

        for(int i=0;i<account;i++){
            array[i] = sc.nextInt();
        }

        System.out.println("原始数组为：");
        System.out.println(Arrays.toString(array));

        int[] sortedArr = selectSort(array);

        System.out.println("排序后数组为：");
        System.out.println(Arrays.toString(sortedArr));
    }

    public static int[] selectSort(int[] arr){
        int account = arr.length;

        for(int i=0; i<account; i++){
            int min = arr[i];
            int index = i;
            for(int ii=i+1; ii<account; ii++){
                if(arr[ii] < min){
                    min = arr[ii];
                    index = ii;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        return arr;
    }
}
