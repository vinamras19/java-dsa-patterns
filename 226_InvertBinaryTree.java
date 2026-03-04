class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // invert
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}