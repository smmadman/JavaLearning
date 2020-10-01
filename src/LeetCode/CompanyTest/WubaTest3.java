package LeetCode.CompanyTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WubaTest3 {
    public static void main(String[] args) {

    }

    public static ArrayList<ArrayList<Integer>> printNode (TreeNode node) {
        // write code here
        Queue<Queue<TreeNode>> resQueue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(node == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        resQueue.add(queue);

        while(!resQueue.isEmpty()){
            Queue<TreeNode> tempQueue  = resQueue.poll();
            Queue<TreeNode> resQ = new LinkedList<>();
            ArrayList<Integer> tempResArr = new ArrayList<>();
            while(!tempQueue.isEmpty()){
                TreeNode tempNode = tempQueue.poll();
                tempResArr.add(tempNode.val);

                if(tempNode.left != null) resQ.add(tempNode.left);
                if(tempNode.right != null) resQ.add(tempNode.right);
            }
            if(resQ.size() != 0){
                resQueue.add(resQ);
            }
            res.add(tempResArr);
        }
        return res;
    }
}
