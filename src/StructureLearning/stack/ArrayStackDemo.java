package StructureLearning.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
    ArrayStack stack = new ArrayStack(5);

    stack.stackTest();

    }
}


class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int MaxSize){
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

    public void stackTest(){
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop) {
            System.out.println("s(show): 显示栈");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到栈");
            System.out.println("g(get): 从栈取出数据");
            char key = scanner.next().charAt(0);
            int res;
            switch(key) {
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    this.push(value);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'g':
                    try {
                        res = this.pop();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception var8) {
                        System.out.println(var8.getMessage());
                    }
                    break;
                case 's':
                    this.showStack();
            }
        }
        System.out.println("程序退出~~");
    }
}