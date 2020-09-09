package LeetCode.AlgorithmTest;

import java.util.Scanner;

public class ZhongxingTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = sc.nextInt();

        int[] dan = new int[n];

        int val = n - count + 1;

        for(int i = 1; i <= n; i++){
            dan[i - 1] = i;
        }

        dan[0] = dan[val - 1];
        dan[val - 1] = 1;

        for(int i : dan){
            System.out.print("" + i + " ");
        }
    }

}
