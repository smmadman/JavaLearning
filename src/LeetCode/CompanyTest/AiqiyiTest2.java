package LeetCode.CompanyTest;

import java.util.Scanner;

public class AiqiyiTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];

        for(int i = 0; i < strArr.length; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }

        int value = 0, vote = 0;

        for(int i = 0; i < arr.length; i++){
            if(vote == 0) value = arr[i];
            else{
//                if(arr[i] == value) vote++;
//                else vote --;
                vote += arr[i] == value ? 1 : -1;
            }
        }

        System.out.println(value);


    }
}
