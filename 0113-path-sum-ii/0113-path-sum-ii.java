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
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, ans);
        return ans;
    }
    public void dfs(TreeNode root , int tar , List<Integer> path , List<List<Integer>> ans){
        if(root == null) return;
        path.add(root.val);
        if(root.left == null && root.right == null && root.val == tar){
            ans.add(new ArrayList<Integer>(path));
        }else{
            dfs(root.left , tar-root.val , path , ans);
            dfs(root.right , tar - root.val , path , ans);
        }
        path.remove(path.size() -1);
    }
}