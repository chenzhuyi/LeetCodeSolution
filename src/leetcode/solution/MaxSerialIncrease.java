package leetcode.solution;

import java.util.Arrays;

/**
 * 最长连续递增子序列
 * vs
 * 最长连续子序列
 *
 */
public class MaxSerialIncrease {

    public int findLengthOfLCIS(int[] nums) {

        if (nums.length < 2)
            return nums.length;

        int maxLength = 1;
        int i = 1;
        int length = 1;
        while(i < nums.length) {
            if (nums[i] <= nums[i-1]) {
                maxLength = length > maxLength? length : maxLength;
                length = 1;
            } else {
                ++length;
            }
            ++i;
        }
        return maxLength = length > maxLength? length : maxLength;
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        // 10,9,2,5,3,7,21,18
        // 1, 1,1,1,1,1,1 ,1
        // 1, 1,1,2,2,3,4, 4
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
