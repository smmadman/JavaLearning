package LeetCode.CompanyTest;

import java.util.Scanner;

public class WubaTest2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = in.nextInt();
            }
        }

        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1){
                    res++;
                    recur(i, j, arr);
                }
            }
        }

        System.out.println(res);
    }

    public static void recur(int i, int j, int[][] arr){
        arr[i][j] = 0;
        if(i - 1 >= 0 && arr[i - 1][j] == 1){
            recur(i - 1, j, arr);
        }
        if(i + 1 < arr.length && arr[i + 1][j] == 1){
            recur(i + 1, j, arr);
        }
        if(j - 1 >= 0 && arr[i][j - 1] == 1){
            recur(i, j - 1, arr);
        }
        if(j + 1 < arr[0].length && arr[i][j + 1] == 1){
            recur(i, j + 1, arr);
        }
    }
}
