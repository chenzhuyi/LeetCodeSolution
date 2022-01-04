package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class Merge {

    /**
     * input  [[2,6],[1,3],[8,10],[15,18]]
     * output [[1,6],[8,10],[15,18]]
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
        int[] isMerged = new int[n];

        for(int i = 0; i<n; i++) {
            bfs(intervals, isMerged, intervals[i], i);
        }
        List<int[]> lists = new ArrayList<>();
        for (int j =0; j<n; j++) {
            if(isMerged[j] ==0 || isMerged[j] ==1) {
                lists.add(intervals[j]);
            }
        }
        return lists.toArray(new int[][] {});
    }

    private void bfs(int[][] intervals, int[] nodes, int[] base, int baseIndex) {
        for (int i = 0; i< intervals.length; ++i) {
            if (nodes[i] != 2 && baseIndex != i) {
                int[] check = intervals[i];
                if (base[0]<=check[1] && check[1]<=base[1]
                        || base[0]<=check[0] && check[0]<=base[1]) {
                    nodes[i] = 2; // need deleted
                    nodes[baseIndex] = 1;
                    int[] merge = new int[2];
                    merge[0] = Math.min(check[0], base[0]);
                    merge[1] = Math.max(check[1], base[1]);
                    base[0] = merge[0];
                    base[1] = merge[1];
                }
            }
        }
    }
}
