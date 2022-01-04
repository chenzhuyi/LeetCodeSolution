package leetcode.solution;

public class ProvinceNum {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected[0].length;
        int[] nodes = new int[n];

        int circles = 0;
        for (int i = 0; i< n; ++i) {
            if (nodes[i] == 0) {
                dfs(nodes, i, isConnected);
                ++circles;
            }
        }

        return circles;
    }

    /**
     * 深度搜索
     */
    private void dfs(int[] nodes, int i, int[][] isConnected) {
        for (int j = 0; j<isConnected.length; ++j) {
            if (i == j || nodes[j] == 1) {
                continue;
            }
            if (isConnected[i][j] == 1) {
                nodes[j]=1;
                dfs(nodes, j, isConnected);
            }
        }
    }
}
