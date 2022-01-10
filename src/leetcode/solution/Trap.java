package leetcode.solution;

/**
 * 接雨水
 * @author i327631
 *
 */
public class Trap {

    public int trap(int[] height) {

        if (height.length <= 2)
            return 0;

        int n = height.length;
        int[] e = new int[] {height[0], 0};

        int sum = 0;
        for (int i = 1; i < n-1; ++i) {
            if (height[i-1] <= height[i]&&e[0]<height[i]) {
                e[0] = height[i];
                e[1] = i;
                continue;
            }
            int rh = height[i+1];
            if (rh > height[i]) {
                int h = Math.min(height[i-1], height[i+1]);
                sum += Math.abs(h-height[i]);
                height[i] = h;
                if (e[0] > height[i] && rh > height[i]) {
                    sum += (i-e[1])*Math.abs(Math.min(e[0], rh)-height[i]);
                }
            }
        }
        return sum;
    }
}
