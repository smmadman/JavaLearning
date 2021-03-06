package LeetCode.jianzhioffer;

import java.util.HashSet;
import java.util.Set;

/**
 *找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */

public class Offer03_findRepeatNumber {
    public static void main(String[] args) {

    }

    public static int findRepeatNumber(int[] nums){// 5%
        int length = nums.length;

        for(int i = 0; i < length - 1; i ++){
            for(int j = i + 1; j < length; j ++){
                if(nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }

        return -1;
    }

    public static int findRepeatNumber2(int[] nums){// 50% 用集合
        Set<Integer> set = new HashSet();
        int repeat = -1;
        for(int i=0; i<nums.length; i++){
            if(!set.add(nums[i])){
                repeat = nums[i];
                break;
            }
        }
        return repeat;
    }

    public int findRepeatNumber3(int[] nums) {// 100%
        // 如果没有重复数字，那么正常排序后，数字i应该在下标为i的位置，
        // 所以思路是重头扫描数组，遇到下标为i的数字如果不是i的话，（假设为m),那么我们就拿与下标m的数字交换。
        // 在交换过程中，如果有重复的数字发生，那么终止返回ture

        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }


}
