package LeetCode.AlgorithmTest;

import java.util.Arrays;

public class SougouTest1_1 {
    public static void main(String[] args) {

    }

    public int numberofprize (int a, int b, int c) {
        int[] arr = new int[3];

        arr[0] = a;
        arr[1] = b;
        arr[2] = c;

        Arrays.sort(arr);

        if(arr[2] - arr[1] == (arr[1] - arr[0]) * 2){
            return arr[1];
        }else if(arr[2] - arr[1] > (arr[1] - arr[0]) * 2){
            arr[2] -= (arr[1] - arr[0]) * 2;
            arr[0] = arr[1];

            return arr[1] += (arr[2] - arr[1]) / 5;
        }else{
            int temp = arr[2] - arr[1];

            arr[0] += temp / 2;
            arr[2] = arr[1] + temp % 2;

            while(arr[1] > arr[0] + 1){

                arr[2] --;
                arr[1] --;
                arr[0] ++;
            }

            return arr[0];
        }

    }
}
