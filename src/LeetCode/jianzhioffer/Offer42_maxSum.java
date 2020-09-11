package LeetCode.jianzhioffer;

import java.util.Arrays;

public class Offer42_maxSum {
    public static void main(String[] args) {

    }

    public static int masSum(int[] nums){

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] += Math.max(0, dp[i - 1]);
        }

        Arrays.sort(dp);
        return dp[dp.length - 1];

    }
}
