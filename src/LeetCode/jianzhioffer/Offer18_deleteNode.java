package LeetCode.jianzhioffer;

public class Offer18_deleteNode {
}

class ListNode2 {
    int val;
     ListNode2 next;
     ListNode2(int x) { val = x; }
 }

class Solution {
    public ListNode2 deleteNode(ListNode2 head, int val) {
        if(head.next == null){
            return head;
        }else{

            if(head.val == val){
                return head.next;
            }

            ListNode2 temp = head.next;
            ListNode2 temp2 = head;
            while(temp.val != val){
                temp = temp.next;
                temp2 = temp2.next;
            }
            if(temp.next != null){
                temp2.next = temp.next;
            }else{
                temp2.next = null;
            }
            return head;
        }
    }
}