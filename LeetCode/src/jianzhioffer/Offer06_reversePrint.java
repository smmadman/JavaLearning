package jianzhioffer;

import java.util.Stack;

public class Offer06_reversePrint {
    public static void main(String[] args) {

    }

    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode current_node = head;

        while(current_node != null){
            stack.push(current_node.val);

            current_node = current_node.next;
        }

        int arr[] = new int[stack.size()];
        int i = 0;
        while(!stack.empty()){
            arr[i] = stack.pop();
            i++;
        }

        return arr;
    }

}

class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
