package leetcode.solution;

import java.util.Arrays;

public class FindPairs {
    public int findPairs(int[] nums, int k) {

        Arrays.sort(nums);
        int result = 0;

        int curi = 0;
        int curj = 0;
        for (int i = 0; i<nums.length-1; ++i) {
            if (i > 0 && nums[i] == curi) {
                continue;
            }
            curi = nums[i];
            for (int j=i+1; j<nums.length; ++j) {
                if (j > i+1 && nums[j] == curj) {
                    continue;
                }
                curj = nums[j];
                if (nums[j] - nums[i] == k) {
                    ++result;
                } else if (nums[j] - nums[i] < k) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
