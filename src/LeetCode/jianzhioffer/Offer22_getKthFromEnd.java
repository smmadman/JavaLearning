package LeetCode.jianzhioffer;

import java.util.Stack;

public class Offer22_getKthFromEnd {
    public static void main(String[] args) {

    }

    public static ListNode getKthFromEnd(ListNode head, int k){
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        stack.push(temp);
        while(temp.next != null){
            stack.push(temp.next);
            temp = temp.next;
        }

        for(int i = 1; i < k; i++){
            stack.pop();
        }

        return stack.pop();
    }
}
