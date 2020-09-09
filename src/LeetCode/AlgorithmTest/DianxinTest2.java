package LeetCode.AlgorithmTest;

import java.util.Scanner;

public class DianxinTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int n_2 = 0;
        int n_3 = 0;
        int n_5 = 0;
        int[] dp = new int[n];

        dp[0] = 1;

        for(int i = 1; i < n; i++){
            int n2 = dp[n_2] * 2, n3 = dp[n_3] * 3, n5 = dp[n_5] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) n_2++;
            if(dp[i] == n3) n_3++;
            if(dp[i] == n5) n_5++;
        }

        System.out.println(dp[n - 1]);
    }
}
