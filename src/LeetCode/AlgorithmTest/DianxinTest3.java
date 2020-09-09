package LeetCode.AlgorithmTest;

import java.util.Scanner;

public class DianxinTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] strArr = str.split(",");

        int[] arr = new int[strArr.length];
        for(int i = 0; i < strArr.length; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }

        if(arr == null || arr.length == 0){
            System.out.println(0);
        }
        if(arr.length == 1){
            System.out.println(arr[0]);
        }

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++){
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }

        System.out.println(dp[arr.length - 1]);

    }
}
