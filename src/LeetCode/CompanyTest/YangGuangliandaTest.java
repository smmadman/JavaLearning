package LeetCode.CompanyTest;


import java.util.Arrays;
import java.util.Scanner;

public class YangGuangliandaTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[4];
        for(int i = 0; i < 4; i++){
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        int res = method(nums);
        if(res == -1) System.out.println(res);
        else System.out.println(res * 4);
    }

    public static int method(int[] nums){
        int sunnum = nums[0] + nums[1] + nums[2] + nums[3];
        int avg = sunnum / 4;

        int sub = 0;
        for(int i = avg; i > -1; i--){
            sub = 0;
            for(int item : nums) if(item > i) sub += (item - i);

            int count = 0;
            for(int item : nums){
                if( i > item) count += (i - item) * 2;
            }

            if(sub == count) return i;
        }
        return -1;
    }
}
