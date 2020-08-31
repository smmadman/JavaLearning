package LeetCode.jianzhioffer;

import sun.awt.image.ImageWatched;
import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32_1_levelOrder {
    public static void main(String[] args) {

    }

    public static int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<Integer>  res = new ArrayList<>();

        if (root != null){
            queue.add(root);
        }

        while(!queue.isEmpty()){

            for(int i = queue.size(); i > 0 ; i--){
                TreeNode tmp = queue.poll();
                res.add(tmp.val);

                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
            }

        }

        int[] resArray = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}
