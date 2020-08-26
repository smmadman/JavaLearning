package LeetCode.AlgorithmTest;

import org.junit.Test;

import java.util.Scanner;

public class HuaweiTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ints = sc.nextLine();

        String[] nums = ints.split(" ");

        long[] numbers = new long[nums.length];

        for(int i = 0; i < nums.length; i++){
            numbers[i] = Integer.parseInt(nums[i]);
        }

        for(int i = 0; i < numbers.length; i++){
            long temp = numbers[i];
            for(int j = 0; j < 16; j++){
                int temp2 = 3 << j * 2;
                if((temp != (temp | temp2)) & (temp != (temp & (~temp2)))){
                    temp = temp ^ temp2;
                }else{
                    continue;
                }
            }
            numbers[i] = temp;
        }

        if(numbers.length == 1){
            int mask = 3;
            long temp0 = mask & numbers[0];

            numbers[0] = numbers[0] >> 2;
            temp0 = mask << 30;

            numbers[0] = numbers[0] | temp0;

        }else{
            int mask = 3;
            long temp0 = mask & numbers[numbers.length - 1];
            temp0 <<= 30;

            for(int i = numbers.length - 1; i > 0; i--){
                numbers[i] >>= 2;
                long tempEve = numbers[i - 1] & mask;
                tempEve <<= 30;

                numbers[i] |= tempEve;
            }

            numbers[0] >>= 2;
            numbers[0] |= temp0;;
        }

        for(long i : numbers){
            System.out.println(i);
        }
    }

}


