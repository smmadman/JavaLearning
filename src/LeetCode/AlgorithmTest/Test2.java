package LeetCode.AlgorithmTest;

public class Test2 {
    public static void main(String[] args) {
        int i = SolutionXXX.maxSubArray(new int[]{-1, -1, -1, 1, 1, -1, -1, 1, 1, 1, -1, -1});
        System.out.println(i);
    }
}

class SolutionXXX {
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
