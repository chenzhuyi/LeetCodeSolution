package leetcode.solution;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return true;
        else if (root.left != null && root.right == null
                || root.left == null && root.right != null)
            return false;

        return checkPerDegree(getChild(new TreeNode[]{root}));
    }

    private TreeNode[] getChild(TreeNode[] nodes) {
        int n = nodes.length;
        TreeNode[] res = new TreeNode[n*2];
        int index = 0;
        for(TreeNode node : nodes) {
            res[index++] = node == null? null : node.left;
            res[index++] = node == null? null : node.right;
        }
        return res;
    }

    private boolean checkPerDegree(TreeNode[] nodes) {
        int i = 0;
        int j = nodes.length - 1;
        boolean isAllNull = true;
        while (i < j) {
            if (nodes[i] == null && nodes[j] != null
                    || nodes[i] != null && nodes[j] == null) {
                return false;
            }
            isAllNull = isAllNull && nodes[i] == null && nodes[j] == null;
            if (nodes[i] == null && nodes[j] == null || nodes[i].val == nodes[j].val) {
                ++i;
                --j;
                continue;
            }
            return false;
        }
        if (isAllNull)
            return true;
        return checkPerDegree(getChild(nodes));
    }
}
