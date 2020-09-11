package LeetCode.jianzhioffer;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.*;

public class Offer50_firstUniqChar {
    public static void main(String[] args) {
        firstUniqChar("leetcode");
    }

    public static char firstUniqChar(String s){
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }
}
