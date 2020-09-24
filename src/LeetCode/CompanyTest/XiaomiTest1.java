package LeetCode.CompanyTest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class XiaomiTest1 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Set<Character> set = new HashSet<>();

        for(int i = 0; i < str.length(); i++){
            char theC = str.charAt(i);

            if(set.contains(theC)){
                continue;
            }else{
                set.add(theC);
                stringBuilder.append(theC);
            }
        }

        System.out.println(stringBuilder.toString());

    }


}
