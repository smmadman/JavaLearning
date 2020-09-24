package LeetCode.CompanyTest;

import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class XiaomiTest2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String str = sc.nextLine();

            if(str.length() % 2 == 1) {
                System.out.println(false);
                break;
            }

            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');

            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < str.length(); i++){
                char theChar =  str.charAt(i);
                if(stack.empty()){
                    stack.push(theChar);
                }else if(theChar == '(' || theChar == '{' || theChar == '['){
                    stack.push(theChar);
                }else{
                    if( map.get(theChar) == stack.peek()){
                        stack.pop();
                    }
                }
            }
            System.out.println(stack.empty());
        }
    }
}
