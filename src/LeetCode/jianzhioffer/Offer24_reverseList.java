package LeetCode.jianzhioffer;

import java.util.List;
import java.util.Stack;

public class Offer24_reverseList {
    public static void main(String[] args) {

    }
    public static ListNode reverseList(ListNode head){

        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode newHead = new ListNode(0);

        newHead.next = head;

        ListNode temp = head.next;
        ListNode temp2;

        while(temp != null){
            temp2 = temp;
            temp = temp.next; // 及时更新，否则死循环，temp找不到下一个值

            temp2.next = newHead.next;
            newHead.next = temp2;
        }

        head.next = null;

        return newHead.next;
    }
}
