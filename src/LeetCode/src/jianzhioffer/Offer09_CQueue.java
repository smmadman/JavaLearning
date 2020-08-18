package jianzhioffer;

import java.util.Stack;

/**
 *用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class Offer09_CQueue {
}

class CQueue {
    Stack<Integer> a = new Stack<Integer>();
    Stack<Integer> b = new Stack<Integer>();
    public CQueue() {
    }

    public void appendTail(int value) {
        this.a.push(value);
    }

    public int deleteHead() {
        if(a.size() == 0){
            return -1;
        }

        while(a.size() > 0){
            b.push(a.pop());
        }

        int result = b.pop();

        while(b.size() > 0){
            a.push(b.pop());
        }

        return result;
    }
}
