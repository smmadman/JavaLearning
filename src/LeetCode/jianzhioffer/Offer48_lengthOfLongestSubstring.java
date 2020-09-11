package LeetCode.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

public class Offer48_lengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s){

        if(s.length() == 0){
            return 1;
        }

        Map<Character, Integer> map = new HashMap<>();

        int temp = 0;
        int res = 0;

        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(!map.containsKey(c)) map.put(c, i);
            else{
                temp = map.get(c);
                res = Math.max(res, i - temp);
                map.put(c, i);
            }
        }

        return res;
    }
}
