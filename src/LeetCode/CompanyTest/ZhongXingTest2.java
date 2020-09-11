package LeetCode.CompanyTest;

import java.util.Scanner;

public class ZhongXingTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int len = sc.nextInt();
            int[] a = new int[len];

            for(int ii = 0; ii < len; ii ++){
                a[ii] = sc.nextInt();
            }

            if(len <= 2){
                System.out.println(0);
            }else if(len == 3){
                int count = 0;
                for(int j = -1; j <= 1; j++){

                }
            }else if(len >= 4){

            }
        }
    }

    public static int recur(int[] a, int index, int count){
        if(judge(a)){
            return count;
        }else{

        }
        return -1;
    }

    public static boolean judge(int[] a){
        int d = a[0] - a[1];
        boolean flag = true;
        for(int i = 1; i < a.length - 1; i++){
            if(a[i] - a[i + 1] == d){
                flag &= true;
            }else{
                flag &= false;
            }
        }

        return flag;
    }
}
