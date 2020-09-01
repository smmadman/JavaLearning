package LeetCode.AlgorithmTest;

import java.util.Scanner;

public class LangchaoTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int[] hh = new int[n + 1];

        int max = 0;
        for(int i = 1; i < n; i++){
            hh[arr[i]] = hh[arr[i] - 1] + 1;
            max = Math.max(max, hh[arr[i]]);
        }

        System.out.println(n - max);
    }
}
