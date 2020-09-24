package LeetCode.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

public class Offer48_lengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s){
        Map<Character, Integer> map = new HashMap<>();

        int temp = -1;
        int res = 0;

        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(!map.containsKey(c)) map.put(c, i);
            else{
                temp = Math.max(map.get(c), temp);
                map.put(c, i);
            }
            res = Math.max(res, i - temp);
        }

        return res;
    }
}
