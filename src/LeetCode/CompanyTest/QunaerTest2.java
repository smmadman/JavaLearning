package LeetCode.CompanyTest;

import java.util.Scanner;

public class QunaerTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String s1 = sc.nextLine();
        String[] str1 = s1.split(" ");
        String s2 = sc.nextLine();
        String[] str2 = s2.split(" ");

        String Sb1 = "";
        String Sb2 = "";

        for(String e : str1){
            Sb1 += e;
        }
        for(String e : str2){
            Sb2 += e;
        }
        if(Sb1.length() > n){
            Sb1 = Sb1.substring(0, n);
        }
        if(Sb2.length() > n){
            Sb2 = Sb2.substring(0, n);
        }

        int ans = longest(Sb1, Sb2);
        ans = ans > n ? n : ans;
        System.out.println(ans);



//        StringBuilder sb1 = new StringBuilder();
//        StringBuilder sb2  =new StringBuilder();
//        for(String e : str1) sb1.append(e);
//        for(String e : str2) sb2.append(e);
//        int ans = longest(sb1.toString(), sb2.toString());
//        System.out.println(ans);
    }

    static int longest(String str1, String str2){
        int m = str1.length(), n = str2.length();
        if(m == 0 || n == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char c1 = str1.charAt(i), c2 = str2.charAt(j);
                if(c1 == c2){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }
}
