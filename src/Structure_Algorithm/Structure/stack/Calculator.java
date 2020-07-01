package Structure_Algorithm.Structure.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3-4";

        CalculatorStack numStack = new CalculatorStack(10);
        CalculatorStack operStack = new CalculatorStack(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while(true) {
            ch = expression.substring(index, index+1).charAt(0);
            if(operStack.isOper(ch)) {
                if(!operStack.isEmpty()) {
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {

                        operStack.push(ch);
                    }
                }else {
                    operStack.push(ch);
                }
            } else {
                keepNum += ch;
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        while (!operStack.isEmpty()) {

            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }

        int res2 = numStack.pop();
        System.out.printf("expression %s = %d", expression, res2);
    }
}

class CalculatorStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public CalculatorStack(int MaxSize){
        this.maxSize = MaxSize;
        stack = new int[MaxSize];
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("The stack is full.");
            return;
        }

        top ++;
        stack[top] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("ERROR:The stack is empty.");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public int peek(){
        return stack[top];
    }

    public void showStack(){
        if(isEmpty()){
            System.out.println("The stack is empty.");
            return;
        }
        for (int i=top; i>=0; i--){
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public int priority(int oper) {
        if(oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }


}