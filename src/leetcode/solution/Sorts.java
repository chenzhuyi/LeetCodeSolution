package leetcode.solution;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Sorts {

    /**
     * 时间复杂度O(n^2), 空间复杂度O(1), 稳定
     * @param nums
     */
    public void bubble(int[] nums) {
        int nl = nums.length;
        int tmp = 0;
        for (int i = 0; i< nl; ++i) {
            for (int j = 0; j< nl - i -1; ++j) {
                if (nums[j] > nums[j+1]) {
                    // exchange
                    tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    /**
     *时间复杂度O(nlogn), 空间复杂度O(logn), 不稳定
     *
     * 1. 先找一个基准，如base = nums[0]
     * 2. 从右往左(j, --j)，如果比base小，nums[i]=nums[j]
     * 3. 从左往右(i, ++i), 如果比base大，nums[j]=nums[i]
     * 4. 如果i>=j, 停止查找，nums[i]=base
     * 5. 分别对base左，右，进行递归
     * @param nums
     */
    public void fastSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    private void quickSort(int[] nums, int i, int j) {
        if (i >= j)
            return;

        int base = nums[i];
        int id = i;
        int jd = j;
        while(id < jd) {
            while (id < jd && nums[jd] >= base) {
                --jd;
            }
            if (id < jd)
                nums[id] = nums[jd];

            while (id < jd && nums[id] <= base) {
                ++id;
            }
            if (id < jd)
                nums[jd] = nums[id];
        }
        // id >= jd
        nums[id] = base;
        quickSort(nums, i, id-1);
        quickSort(nums, id+1, j);
    }
}
