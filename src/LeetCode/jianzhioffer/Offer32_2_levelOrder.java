package LeetCode.jianzhioffer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32_2_levelOrder {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>>  res = new LinkedList<>();

        if (root != null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            List<Integer> temp = new LinkedList<>();

            for(int i = queue.size(); i > 0 ; i--){
                TreeNode tmp = queue.poll();
                int val = tmp.val;
                temp.add(val);

                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
            }

            res.add(temp);
        }

        return res;
    }
}
