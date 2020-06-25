package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exception {
    public static void main(String args[]) {
        int arr[] = {1,1,2,2,2,3,4,5,6,7,7,7,8,8};
        List<Integer> same = new ArrayList<Integer>();
        same = split_arr(arr);

        int base_same = calculate_samenumber(same);
        int base_dif = arr.length - base_same;
        System.out.println(base_dif);
        System.out.println(calculate_expection(4));
    }

    private static List<Integer> split_arr(int[] scores) {
        List<Integer> same_index = new ArrayList<Integer>();

        if(scores[0] == scores[1]){
            same_index.add(0);
        }

        for (int i = 1; i < scores.length-1; i++) {

            if(scores[i-1] == scores[i] && scores[i] == scores[i+1]){
                continue;
            }else if(scores[i-1] < scores[i] && scores[i] == scores[i+1]){
                same_index.add(i);
            }else if(scores[i-1] == scores[i] && scores[i] < scores[i+1]){
                same_index.add(i);
            }else if(scores[i-1] < scores[i] && scores[i] < scores[i+1]){
                continue;
            }
        }

        if(scores[scores.length-2] == scores[scores.length-1]){
            same_index.add(scores.length-1);
        }

        return same_index;
    }

    public static int calculate_samenumber(List<Integer> same){
        int base_same = 0;
        int times = 0;
        int temp = 0;

        for (Integer a: same){
            switch (times){
                case 0:
                    temp = a;
                    times ++;
                    break;
                case 1:
                    temp = a-temp+1;
                    base_same += temp;
                    temp = 0;
                    times --;
                    break;
            }

        }
        return base_same;
    }

    public static double calculate_expection(int n){
        if(n==2){
            return 1;
        }else if(n == 3){
            return 1;
        }

        double expection_sum = 0;
        expection_sum += n* (1.0/doFactorial(n));// 完全相同完全不同单独计算

        for(int i=1; i<n;i++){//i 不同的个数
            double mul_temp = 1;
            double result = (n-i)*doFactorial(i);
            for(int ii=0; ii<=i; ii++){
                mul_temp*=1.0/(n-i);
            }
            result = result*mul_temp;
            expection_sum += result;
        }

        return expection_sum;
    }

    public static int doFactorial(int n){
        if(n<0){
            return -1;//传入的数据不合法
        }
        if(n==0){
            return 1;
        }else if(n==1){//递归结束的条件
            return 1;
        }else{
            return n*doFactorial(n-1);
        }
    }

}
