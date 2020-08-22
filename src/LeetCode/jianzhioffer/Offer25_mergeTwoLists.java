package LeetCode.jianzhioffer;

public class Offer25_mergeTwoLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode newHead = new ListNode(0);
        ListNode newTemp = newHead;

        while(temp1 != null && temp2 != null){
            ListNode theTemp;
            if(temp1.val <= temp2.val){
                theTemp = new ListNode(temp1.val);
                temp1 = temp1.next;
            }else{
                theTemp = new ListNode(temp2.val);
                temp2 = temp2.next;
            }
            newTemp.next = theTemp;

            newTemp = newTemp.next;
        }

        if(temp1 == null){
            newTemp.next = temp2;
        }else{
            newTemp.next = temp1;
        }

        return newHead.next;
    }
}
