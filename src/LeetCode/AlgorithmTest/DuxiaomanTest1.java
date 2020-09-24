package LeetCode.AlgorithmTest;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuxiaomanTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        Map<Character, Integer> colorSet = new HashMap();
        for(int i = 0; i < s.length(); i++){
            char tempChar = s.charAt(i);

            if(!colorSet.containsKey(tempChar)){
                colorSet.put(tempChar, 1);
            }else{
                int tempInt = colorSet.get(tempChar);
                colorSet.put(tempChar, tempInt + 1);
            }
        }

        int count = 0;

        for(int i = 0; i < t.length(); i++){
            char tempChar = t.charAt(i);

            if(!colorSet.containsKey(tempChar)){
                continue;
            }else if(colorSet.get(tempChar) == 0){
                continue;
            }else{
                int tempInt = colorSet.get(tempChar);
                tempInt --;
                colorSet.put(tempChar, tempInt);
                count++;
            }
        }

        System.out.println(count);
    }
}
