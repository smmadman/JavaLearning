package LeetCode.CompanyTest;

import java.util.Scanner;

public class YituMianshi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        if(count % 2 != 0) System.out.println(-1);

        int a = count / 8; // 记录8个一袋的袋数
        int b = count % 8; // 记录不能放入8个一袋的最后的余数；

        if(a == 0){
            System.out.println(count % 6 == 0 ? 1 : 0);
        }

        if(a >= 3){
            for(int i = 1; i <= 3; i++){
                int temp = b + i * 8;
                if(temp % 6 == 0){
                    System.out.println(a - i + temp / 6);
                    return;
                }
            }

            System.out.println(-1);
        }else{
            for(int i = 1; i <= a ; i++){
                int temp = b + i * 8;
                if(temp % 6 == 0){
                    System.out.println(a - i + temp / 6);
                    return;
                }
            }
            System.out.println(-1);
        }
    }
}
