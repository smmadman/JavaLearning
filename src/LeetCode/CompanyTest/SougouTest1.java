package LeetCode.CompanyTest;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SougouTest1 {
    public static void main(String[] args) {
        System.out.println(numberofprize(9, 3, 3));
    }

    public static int numberofprize (int a, int b, int c) {
        // write code here
        int[] array = new int [3];

        array[0] = a;
        array[1] = b;
        array[2] = c;

        Arrays.sort(array);

        int temp = array[0];

        for(int i = 0; i < array.length; i++){
            array[i] -= temp;
        }

        while(array[2] >= array[1] + 2){

            array[2] -= 2;
            array[0] += 1;

            Arrays.sort(array);
        }

        while(array[1] > array[0]){
            array[2] --;
            array[1] --;
            array[0] ++;


            Arrays.sort(array);
            if(array[2] + array[1] - array[0] * 2 < 2){
                break;
            }


        }

        return array[0] + temp;
    }
}
