package leetcode.solution;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {

        quickSort(nums, 0, nums.length-1);
        return nums[nums.length-k];
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left > right)
            return;

        int base = nums[left];
        int i = left;
        int j = right;
        while(i < j) {
            while (j > i && nums[j] >= base) {
                --j;
                continue;
            }
            if (j>i)
                nums[i] = nums[j];
            while (i< j && nums[i] <= base) {
                ++i;
                continue;
            }
            if (i<j)
                nums[j] = nums[i];
        }
        nums[i] = base;
        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }
}
