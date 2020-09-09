package LeetCode.AlgorithmTest;

import java.util.Scanner;

public class XiechengTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String mingan = sc.nextLine();
        String sentence = sc.nextLine();
        String tihuan = sc.nextLine();

        String[] arr = sentence.split("|,");

        for(int i = 0; i < arr.length; i++){
            boolean flag = true;
            if(arr[i].length() == mingan.length()){
                char[] char_arr = arr[i].toCharArray();
                for(char c: char_arr){
                    if(!mingan.contains(String.valueOf(c))){
                        flag = false;
                        break;
                    }
                }

                if(flag == true){
                    arr[i] = tihuan;
                }
            }
            flag = true;
        }

        StringBuffer sb = new StringBuffer();
        for(String str: arr){
            sb.append(str + " ");
        }

        System.out.println(sb.toString().trim());
    }
}
