package LeetCode.CompanyTest;

public class WubaTestYang3 {
    public static int firstMissingNumber(int[] nums){
         int n = nums.length;
         int[] res = new int[n];
         for(int i = 0; i < n; i++){
             if(nums[i] > 0 && nums[i] <= n){
                 res[nums[i] - 1] = 1;
             }
         }

         for(int i = 0; i < n; i++){
             if(res[i] == 0){
                 return i + 1;
             }
         }
        return -1;
    }
}
