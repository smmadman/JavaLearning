package LeetCode.CompanyTest;

import java.util.Arrays;

public class WubaTest1 {
    public static void main(String[] args) {

    }

    public static int firstMissingNumber(int[] nums){

        int[] nums2 = nums;
        Arrays.sort(nums2);
        int temp = 0;
        for(int i = 0; i < nums2.length; i++){
            if(nums2[i] < 0){
                continue;
            }else{
                if(nums2[i] == 0){
                    continue;
                }else{
                    if(nums2[i] == temp + 1){
                        temp ++;
                        continue;
                    }else{
                        return temp + 1;
                    }
                }
            }
        }

        if(nums2[nums2.length - 1] <= 0) return 1;
        return nums2[nums2.length - 1] + 1;
    }
}
