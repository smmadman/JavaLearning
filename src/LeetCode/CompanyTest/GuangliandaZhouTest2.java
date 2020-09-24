package LeetCode.CompanyTest;

import java.util.Scanner;

public class GuangliandaZhouTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        int actionNum = Integer.parseInt(arr[0]);
        int T = Integer.parseInt(arr[1]);
        double[] V = new double[actionNum];
        int[] P = new int[actionNum];

        for(int i = 0; i < actionNum; i++){
            String tempStr = sc.nextLine();
            String[] tempArr = tempStr.split(" ");
            V[i] = Double.parseDouble(tempArr[0]);
            P[i] = Integer.parseInt(tempArr[1]);
        }

        int[][] dp = new int[P.length + 1][T + 1];
        for(int i = 0; i < P.length; i++){
            for(int j = 0; j <= T; j++){
                for(int k = 0; k * V[i] <= j; k++){
                    dp[i + 1][j] = Math.max(dp[i+1][j], dp[i][(int)(j-k*V[i])] + k * P[i]);
                }
            }
        }
        System.out.println(dp[P.length][T]);
    }
}
