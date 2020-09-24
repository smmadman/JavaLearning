package LeetCode.AlgorithmTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeAverage {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int size = 1;
        List<Double> list = new ArrayList<>();

        while(!queue.isEmpty()){
            double tempSum = 0;
            int count = 0;
            for(int i = 0; i < size; i++){
                TreeNode tempTree = queue.poll();
                tempSum += tempTree.val;
                if(tempTree.left != null){
                    queue.add(tempTree.left);
                    count++;
                }
                if(tempTree.right != null){
                    queue.add(tempTree.right);
                    count++;
                }
            }
            tempSum = tempSum / size;
            list.add(tempSum);
            size = count;
        }
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}