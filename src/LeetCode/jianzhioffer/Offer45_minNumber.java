package LeetCode.jianzhioffer;

import java.util.Arrays;

public class Offer45_minNumber {
    public static void main(String[] args) {

    }

    public static String minNumber(int[] nums){
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (a, b)->{return (a + b).compareTo(b + a);});
        StringBuilder sb = new StringBuilder();

        for(String str : strs){
            sb.append(str);
        }

        return sb.toString();
    }
}
