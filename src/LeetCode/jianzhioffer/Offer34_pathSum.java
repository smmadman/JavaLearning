package LeetCode.jianzhioffer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class Offer34_pathSum {
    public static void main(String[] args) {
    }
}

class pathSum1 {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> theRes = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum, 0);
        return theRes;
    }

    public void recur(TreeNode root, int theValue, int sum){

        if(root == null){
            return ;
        }

        path.add(root.val);

        if(root.left == null && root.right == null && theValue == root.val + sum){
            theRes.add(new LinkedList<>(path));
        }

        recur(root.left, theValue, sum + root.val);
        recur(root.right, theValue, sum + root.val);

        path.removeLast();
    }
}
