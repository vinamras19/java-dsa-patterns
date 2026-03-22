public class Codec {
    private int i;

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildStr(root, sb);
        return sb.toString();
    }

    private void buildStr(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
            return;
        }
        sb.append(node.val).append(",");
        buildStr(node.left, sb);
        buildStr(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        i = 0;
        return buildTree(tokens);
    }

    private TreeNode buildTree(String[] tokens) {
        if (tokens[i].equals("N")) {
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(tokens[i++]));
        node.left = buildTree(tokens);
        node.right = buildTree(tokens);
        return node;
    }
}