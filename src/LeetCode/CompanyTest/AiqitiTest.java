package LeetCode.CompanyTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AiqitiTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Map<Character, Integer> map = new HashMap<>();
        int temp = -1;
        int res = 1;
        for(int i = 0; i < str.length(); i++){
            char tempChar = str.charAt(i);

            if(!map.containsKey(tempChar)) map.put(tempChar, i);
            else{
                int lastIndex = map.get(tempChar);
                map.put(tempChar, i);
                if(lastIndex > temp){
                    res = Math.max(i - lastIndex, res);
                }else{
                    temp = i;
                }
            }
        }

        System.out.println(res);
    }



}
