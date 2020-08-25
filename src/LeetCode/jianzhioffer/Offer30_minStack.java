package LeetCode.jianzhioffer;

import java.util.Stack;

public class Offer30_minStack {
    public static void main(String[] args) {

    }
}

/**
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */

/**
 * 定义B辅助栈，来一个新值时，A主栈来新值时
 * 若B为空则同时压入B，若B不为空则小于B栈顶值时压入B，保证B栈顶始终为A中最小元素
 * A的pop注意与B的pop同步（A pop出去的值等于B栈顶的值）
 * 保证B栈顶元素始终为栈A中的最小值
 */
class MinStack {
    Stack<Integer> A, B;
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    public void pop() {
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }
}
