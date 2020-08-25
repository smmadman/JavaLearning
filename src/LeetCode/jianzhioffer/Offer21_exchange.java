package LeetCode.jianzhioffer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，
 * 所有偶数位于数组的后半部分。
 */
public class Offer21_exchange {
    public static void main(String[] args) {
        System.out.println(exchange(new int[]{1, 2, 3, 4}).toString());
    }

    public static int[] exchange(int[] nums){
        int length = nums.length;

        int i = 0;
        int j = length - 1;

        while(i < j){
            if(nums[i] % 2 == 0){
                while(i < j){
                    if(nums[j] % 2 == 1){
                        int temp = 0;
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;

                        j --;
                        break;
                    }else{
                        j--;
                    }
                }
            }
            i++;
        }
        return nums;
    }
}
