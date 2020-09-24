package LeetCode.AlgorithmTest;

import com.alibaba.druid.support.json.JSONUtils;

import java.util.Scanner;

public class AliTest {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        long n = sc.nextLong();
        for(long group = 0; group < n; group++){
            long N = sc.nextLong();
            long M = sc.nextLong();
            cal(N, M);
        }
    }

    public static void cal(long N, long M){
        if(N % 2 == 0 || M % 2 == 0){
            System.out.println("1/2");
        }else if(N == 1 && M == 1){
            System.out.println("0/1");
        }else if(N == 1 || M == 1){
            long temp1 = N == 1 ? N : M;
            System.out.println(temp1 - 1 + "/" + 2 * temp1);
        }else{
            long up = (N + 1) * (M - 1) + (N - 1) * (M + 1);
            long down = 4 * M * N;
            long s = 1;

            long num1 = up;
            long num2 = down;

            do{
                s = up % down;
                up = down;
                down = s;
            }while(down != 0);
            System.out.println(num1 / up + "/" + num2 / up);
        }
    }


}
