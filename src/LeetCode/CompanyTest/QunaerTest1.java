package LeetCode.CompanyTest;

import java.math.BigInteger;
import java.util.Scanner;

public class QunaerTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int m = sc.nextInt();
        int n = sc.nextInt();
        
        BigInteger Amn = new BigInteger("1");
        for(int i = 0; i < n; i++){
            BigInteger temp = new BigInteger(String.valueOf(m - i));
            Amn = Amn.multiply(temp);
        }
        
        BigInteger Tmn = new BigInteger("1");
        for(int i = n; i > 0; i--){
            Tmn = Tmn.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println(Amn.divide(Tmn));
    }


}
