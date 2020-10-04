package LeetCode.jianzhioffer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WanmeiTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Map<Character, Integer> map = new LinkedHashMap<>();

        for(int i =0; i < str.length(); i++){
            char tempC = str.charAt(i);
            if(map.containsKey(tempC)){
                int tempInt = map.get(tempC);
                map.put(tempC, tempInt + 1);
            }else{
                map.put(tempC, 1);
            }
        }

        String res = "";

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) res = res + entry.getKey();
        }
        System.out.println(res);
    }
}
