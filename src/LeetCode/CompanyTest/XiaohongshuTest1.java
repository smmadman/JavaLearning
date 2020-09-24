package LeetCode.CompanyTest;

import com.alibaba.druid.sql.visitor.functions.Char;

import javax.print.attribute.HashPrintJobAttributeSet;
import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class XiaohongshuTest1 {
    public static void main(String[] args) {

    }
    static int findMin(int[] tree) {
        Set<Integer> set = new TreeSet<>();

        for(int i = 0; i <= 22; i++){
            set.add(i);
        }
        for(int i = 0; i < tree.length; i++){
            if(set.contains(tree[i])) set.remove(tree[i]);
        }

        Iterator iterator = set.iterator();

        return (int) iterator.next();
    }
    static int solution(String s) {
//        Map<Character, ArrayList<Integer>> map = new HashMap<>();
//        for(int i = 0; i < s.length(); i++){
//            char key = s.charAt(i);
//            if(map.containsKey(key)) map.get(key).add(i);
//            else map.put(key, new ArrayList<Integer>(i));
//        }
//        Set set = map.keySet();
//        Iterator it = set.iterator();
//        while(it.hasNext()){
//            char key = (char) it.next();
//            List valueList = map.get(key);
//
//            while()
//        }

        if(s == null || s.length() == 0){
            return 0;
        }else if(s.length() == 1){
            return 1;
        }
        int res = 0;
        int index = 0;
        while(index < s.length()){
            int temp = s.lastIndexOf(s.charAt(index));
            if(temp == -1){
                res ++;
                index++;
            }else{
                res++;
                index = temp + 1;
            }
        }

        return res;
    }
}
