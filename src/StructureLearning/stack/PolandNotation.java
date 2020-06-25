package StructureLearning.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//前中后表达式：Prefix/Infix/Suffix Expression

public class PolandNotation {
    public static void main(String[] args) {// 重点在中缀表达式转后缀表达式
        String suffixExpression = "30 4 + 5 * 6 - ";// (30+4)*5-6的后缀表达式
        String suffixExpression2 = "4 5 * 8 - 60 + 8 2 / +";// 4*5-8+60+8/2的后缀表达式
        String suffixExpressionTest = "1 2 3 + 4 * 5 - + ";

        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList=" + rpnList);
        System.out.println("result: " + calculate(rpnList));

        List<String> rpnList2 = getListString(suffixExpression2);
        System.out.println("rpnList2=" + rpnList2);
        System.out.println("result: " + calculate(rpnList2));

        List<String> rpnListTest = getListString(suffixExpressionTest);
        System.out.println("rpnListTest=" + rpnListTest);
        System.out.println("result: " + calculate(rpnListTest));

    }

    //将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression){ // 泛型，之后补充看看
        String[] split = suffixExpression.split(" ");//分割
        List<String> list = new ArrayList<String>();
        for(String element: split){
            list.add(element);
        }
        return list;
    }

    //完成逆波兰表达式的运算
    public static int calculate(List<String> ls){
        //创建栈，一个即可
        Stack<String> stack = new Stack<String>();

        //便利ls
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
}
