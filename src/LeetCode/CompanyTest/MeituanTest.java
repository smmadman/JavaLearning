package LeetCode.CompanyTest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MeituanTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        int count = 0;

        for(int i = start; i <= end; i++){
            if(judgeDiff(i) && judgeSum(i)) {
                count ++;
                System.out.println(i);
            }
        }
        System.out.println(count);
    }

    public static boolean judgeDiff(int x){
        Set<Integer> set = new HashSet<>();
        int temp = x;
        while(temp > 0){
            int temp1 = temp % 10;
            if(!set.add(temp1)){
                return false;
            }
            temp = temp / 10;
        }
        return true;
    }

    public static boolean judgeSum(int x){
        int A = 0, B = 0, C = 0, D = 0, E = 0, F = 0;
        int temp = x;
        F = temp % 10;
        temp = temp / 10;
        E = temp % 10;
        temp = temp / 10;
        D = temp % 10;
        temp = temp / 10;
        C = temp % 10;
        temp = temp / 10;
        B = temp % 10;
        temp = temp / 10;
        A = temp % 10;

        if(A == 0 || C == 0 || E == 0) return false;

        if(A * 10 + B + C * 10 + D == E * 10 + F) return true;
        else return false;
    }
}
