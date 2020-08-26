package LeetCode.AlgorithmTest;

import org.junit.Test;

import java.util.Scanner;

public class HuaweiTest {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        String ints = sc.nextLine();
//
//        String[] nums = ints.split(" ");

        String[] nums = {"1", "2"};

        int[] numbers = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            numbers[i] = Integer.parseInt(nums[i]);
        }

        for(int i = 0; i < numbers.length; i++){
            int temp = numbers[i];
            for(int j = 0; j < 16; j++){
                int temp2 = 3 << j;
                if((temp != (temp | temp2)) && (temp != (temp & (~temp2)))){
                    temp = temp ^ temp2;
                }else{
                    continue;
                }
            }
            numbers[i] = temp;
        }

        for(int i : numbers){
            System.out.println(i);
        }
    }

    @Test
    public void test(){
        System.out.println(1 & 3);
        System.out.println(Integer.toHexString(65536));
    }
}


