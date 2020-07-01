package Structure_Algorithm.Structure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CompletePolandNotationCalculator {

    public static void main(String[] args) {
        String infixExpression = "(30+4)*5-6";//正常中缀表达式
        String infixExpression2 = "4*5-8+60+8/2";
        String infixExpression3 = "((23-24)+26*22-88)*54-87-74*((30+4)*5-6)";

        System.out.println(caculate(infixExpression));
        System.out.println(caculate(infixExpression2));
        System.out.println(caculate(infixExpression3));
    }

    public static List<String> toInfixExpressionList(String str){ //将中缀表达式放入list中
        List<String> ls = new ArrayList<String>();
        int index = 0;
        String s;
        char c;
        do{
            if((c=str.charAt(index)) < 48 || (c=str.charAt(index)) > 57){
                ls.add("" + c);
                index++;
            }else{
                s = "";
                while(index < str.length() && (c=str.charAt(index)) >= 48 && (c=str.charAt(index)) <= 57){
                    s += c;
                    index++;
                }
                ls.add(s);
            }
        }while (index < str.length());
        return ls;
    }

    public static List<String> convertInfixToSuffix(List<String> InfixList){//将中缀表达式转为后缀表达式
        Stack<String> s1 = new Stack<String>(); //运算符栈
        Stack<String> s2 = new Stack<String>(); //中间结果栈

        for (String element: InfixList){
            if (element.matches("\\d+")){// 遇到操作数，匹配多位数
                s2.push(element);
            }else if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")){//遇到操作符
                if(s1.empty()){
                    s1.push(element);
                }else if(s1.peek().equals("(")){
                    s1.push(element);
                } else if(priorityCalculate(element, s1.peek())){
                    s1.push(element);
                }else{
                    boolean flag = true;
                    do {
                        String temp = s1.pop();
                        s2.push(temp);

                        if(s1.empty()){
                            flag = false;
                            s1.push(element);
                        }else if(s1.peek().equals("(")){
                            flag = false;
                            s1.push(element);
                        }else if(priorityCalculate(element, s1.peek())){
                            flag = false;
                            s1.push(element);
                        }
                    }while (flag);
                }
            }else if(element.equals("(")){//遇到左括号
                s1.push(element);
            }else if(element.equals(")")){//遇到右括号
                String temp = s1.pop();
                while(!temp.equals("(")){
                    s2.push(temp);
                    temp = s1.pop();
                }
            }else{//遇到其他不合规则符号
                throw new RuntimeException("Invalid op!");
            }
        }

        while(!s1.empty()){//将s1中所有值push到s2中(完成表达式)
            s2.push(s1.pop());
        }

        while(!s2.empty()){//再将s2中所有值push到s1中(完成表达式的逆序)
            s1.push(s2.pop());
        }

        List<String> suffixList = new ArrayList<>();

        while(!s1.empty()){//将逆序之后的表达式放入列表中
            suffixList.add(s1.pop());
        }

        return suffixList;

    }

    public static boolean priorityCalculate(String op1, String op2){// op1 > op2 true; op1 <= op2 false;
        int op1_p = 0;
        int op2_p = 0;

        if(op1.equals("*")  || op1.equals("/")){
            op1_p = 1;
        }

        if(op2.equals("*")  || op2.equals("/") ){
            op2_p = 1;
        }

        return op1_p > op2_p;
    }

    public static int calculateSuffix(List<String> ls){//计算后缀表达式
        //创建栈，一个即可
        Stack<String> stack = new Stack<String>();

        //遍历ls
        for(String element: ls){
            if(element.matches("\\d+")){ //正则表达式，匹配多位数
                stack.push(element);
            }else{ //如果是运算符

                //pop出两个数
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());

                int result = 0;

                if(element.equals("+")){
                    result = num1 + num2;
                }else if(element.equals("-")){
                    result = num1 - num2;
                }else if(element.equals("*")){
                    result = num1 * num2;
                }else if(element.equals("/")){
                    result = num1 / num2;
                }else{
                    throw new RuntimeException("运算符有误");
                }

                //计算之后吧result入栈
                stack.push(""+result); // 简便的将整数转换为字符串的操作
            }
        }

        //for循环结束之后留在栈中的结果即为最后结果
        return Integer.parseInt(stack.pop());
    }

    public static int caculate(String infixExpression){
        List<String> infixList = toInfixExpressionList(infixExpression);
        System.out.println("中缀表达式列表：" + infixExpression);
        List<String> suffixList = convertInfixToSuffix(infixList);
        System.out.println("后缀表达式列表：" + suffixList);
        return calculateSuffix(suffixList);
    }
}
