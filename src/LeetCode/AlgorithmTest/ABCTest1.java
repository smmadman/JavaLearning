package LeetCode.AlgorithmTest;

import java.util.Arrays;
import java.util.Scanner;

public class ABCTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String  str = sc.nextLine();
        String[] strArr = new String[25];

        int count = 0;

        int i = 1;

        while(i <= Math.pow(10, 9)){
            strArr[count++] = String.valueOf(i);
            i *= 3;
        }

        for(int j = 0; j <= count; j++){
        }
    }
}
