package LeetCode.CompanyTest;

import java.util.Scanner;

public class DidiTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strN = sc.nextLine();
        int n = Integer.parseInt(strN);
        String str = sc.nextLine();
        int length = str.length();
        String res = "";
        if(length <= n){
            res = changeStr(str);
            System.out.println(res);
        }else{
            int times = length / n;
            for(int i = 0; i < times; i++){
                res += changeStr(str.substring(i * n, i * n + n));
            }
            int remain = length % n;
            res += changeStr(str.substring(length - remain, length));
            System.out.println(res);
        }
    }

    public static  String changeStr(String target){ // 反转输入的字符串
        String res = "";
        for(int i = target.length() - 1; i >= 0; i--){
            res += target.charAt(i);
        }
        return res;
    }

}
