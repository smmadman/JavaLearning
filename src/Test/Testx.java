package Test;
import java.util.HashMap;
import java.util.Map;

public class Testx {

    public static void main(String[] args) {
        String s = "abc";
        //System.out.println(new change().change(s));
    }
    /**
     * 用哈希表实现一个映射，数字10个、小写字母26、大写字母26
     * 一共62个字符
     * 就用2个字母代表26进制的算法，A-Z表示0-25，只用前62个
     */
    static Map<Character, String> map;

    static {
        map = new HashMap<>(62);
        for(int i = 0; i < 26; i++){
            char tmp1 = (char)('A' + i);
            map.put(tmp1, "A" + tmp1);
            char tmp2 = (char)('a' + i);
            map.put(tmp2, "B" + tmp1);
        }

        for (int i = 0; i < 10; i++) {
            char tmp3 = (char) ('0' + i);
            map.put(tmp3, "C" + (char) ('A' + i));
        }

    }

    public String change(String s){
        if(s == null) return null;
        if(s.length() == 0){
            return "";
        }
        StringBuilder ans = new StringBuilder(2 * s.length());
        for (int i = 0; i < s.length(); i++) {
            ans.append(map.get(s.charAt(i)));
        }
        return ans.toString();
    }



}
