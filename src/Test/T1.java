package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        //接收输入 放入t中
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> t = new ArrayList<List<Integer>>();
        for(int i=1; i<=n; i++){
            List<Integer> temp = new ArrayList<>();
            for(int ii=0;ii<i;ii++){
                temp.add(sc.nextInt());
            }
            t.add(temp);
        }

        //计算，结果在res中
        if(t == null || t.size() == 0){
            System.out.println(0);
        }
        int row = t.size();
        int column =t.get(row - 1).size();
        int[][] dp = new int[row][column];
        dp[0][0] = t.get(0).get(0);
        int res = -1;
        for(int i=1; i<row; i++){
            for (int j=0; j<=i; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + t.get(i).get(j);
                }else if(j == i){
                    dp[i][j] = dp[i-1][j-1] + t.get(i).get(j);
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + t.get(i).get(j);
                }
            }
        }
        for(int i=0; i<column; i++){
            res = Math.max(res, dp[row-1][i]);
        }
        System.out.println(res);
    }
}
