package LeetCode.jianzhioffer;

import java.util.Scanner;

public class WanmeiTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] strArr = str.split("_");

        if(str.length() == 0) {
            System.out.println("");
            return;
        }
        int count = 0;
        for(int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i) == '_') count++;
            else break;
        }

        String res = "";
        for(int i = 0; i < strArr.length; i++){
            if(i != strArr.length - 1){
                res = res + reverse(strArr[i]) + '_';
            }else{
                res = res + reverse(strArr[i]);
            }
        }

        for(int i = 0; i < count; i++)
            res = res + "_";

        int startIndex = 0, endIndex = 0;
        for(int i = 0; i < str.length(); i++){
            if(res.charAt(i) == '_') startIndex++;
            else break;
        }
        for(int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i) == '_') endIndex++;
            else break;
        }

        System.out.println(res.substring(startIndex, res.length() - endIndex));



    }
    public static String reverse(String str){
        if("" == str){
            return "";
        }else if(str.length() == 1){
            return str;
        }else{
            int n = str.length();
            String res = "";
            for(int i = n - 1; i >= 0; i--){
                res = res + str.charAt(i);
            }
            return  res;
        }
    }
}
