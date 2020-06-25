package SortAlgorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class BubbleSort {
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

        int[] sorted_arr = bubbleSort(array);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("After sorting: " + date2Str);

    }

    public static void input_sort(){
        Scanner sc = new Scanner(System.in);

        int account = sc.nextInt();

        int[] array = new int[account];
        for(int i=0; i<account; i++){
            array[i] = sc.nextInt();
        }

        System.out.println("原数组：");
        System.out.println(Arrays.toString(array));

        int[] sorted_arr;
        sorted_arr = bubbleSort(array);

        System.out.println("排序后数组：");
        System.out.println(Arrays.toString(sorted_arr));
    }

    public static int[] bubbleSort(int[] arr){
        int account = arr.length;
        boolean flag = false;

        for(int i=0;i<account-1;i++){
            for(int ii=0; ii<account-(i+1); ii++){
                int temp = 0;
                if(arr[ii] > arr[ii+1]){
                    temp = arr[ii];
                    arr[ii] = arr[ii+1];
                    arr[ii+1] = temp;

                    flag = true;
                }
            }

            if(flag = false){
                return arr;
            }

            flag = false;
        }

        return arr;
    }
}
