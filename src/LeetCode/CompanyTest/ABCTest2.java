package LeetCode.CompanyTest;

import java.util.Scanner;

public class ABCTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  str = sc.nextLine();
        str = str.substring(1, str.length() - 1);
        String[] strArr = str.split(",");
        float[] arr = new float[strArr.length];
        for(int i = 0; i < arr.length; i++){
            float temp = Float.parseFloat(strArr[i]);
            arr[i] = temp;
        }
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length - 1; i++){
            int count = 0;
            for(int ii = i + 1; ii < arr.length; ii++){
                count++;
                if(arr[ii] > arr[i]){
                    res[i] = count ;
                    break;
                }
            }
        }
        System.out.print("[");
        for(int i = 0; i < res.length; i++){
            if(i == res.length - 1){
                System.out.print(res[i]);
                continue;
            }else{
                System.out.print(res[i]+ ",");
            }
        }
        System.out.println("]");
    }
}
