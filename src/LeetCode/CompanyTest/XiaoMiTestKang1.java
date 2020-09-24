package LeetCode.CompanyTest;

import java.util.Scanner;
import java.util.Stack;

public class XiaoMiTestKang1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String  s = sc.nextLine();
            char[] arr = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(int i = 0; i < s.length(); i++){
                char curChar = arr[i];
                if(curChar == '(' || curChar == '[' || curChar == '{'){
                    stack.add(curChar);
                }else if(curChar == ')'){
                    if(stack.isEmpty() || stack.peek() != '('){
                        flag = false;
                        break;
                    }else{
                        stack.pop();
                    }
                }else if(curChar == ']'){
                    if(stack.isEmpty() || stack.peek() != '['){
                        flag = false;
                        break;
                    }else{
                        stack.pop();
                    }
                }else if(curChar == '}'){
                    if(stack.isEmpty() || stack.peek() != '{'){
                        flag = false;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty() && flag){
                System.out.println(true);
            }else{
                System.out.println(false);
            }
        }
    }
}
