/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/


class SubTree{
    int max;
    int min;
    int sum;
    boolean isBST;
    SubTree(){
        max = Integer.MAX_VALUE;
        min = Integer.MIN_VALUE;
        sum = 0;
        isBST = true;
    }
} 
class Solution {
    public int maxSum = 0;
    
    public SubTree sumBST(TreeNode root) {
        if(root == null){
            SubTree temp = new SubTree(); 
            temp.min = Integer.MAX_VALUE;
            temp.max = Integer.MIN_VALUE;
            return temp;
        }
        SubTree left = sumBST(root.left);
        SubTree right = sumBST(root.right);
        SubTree node = new SubTree();
        if(left.isBST == true && right.isBST== true && left.max < root.val && right.min > root.val) {
            node.sum = root.val + left.sum + right.sum;
            //System.out.println(node.sum);
        }
        else
        {
            node.sum = Math.max(left.sum,right.sum);
            node.isBST = false;
        }
        node.max = Math.max(right.max,root.val);
        node.min = Math.min(left.min,root.val);
        maxSum = Math.max(maxSum,node.sum);
        return node;
    }
    
    public int maxSumBST(TreeNode root) {
        sumBST(root);
        return maxSum;
    }
}