package leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public ThreeSum() {
    }

    public void threeSumA(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int nl = nums.length;
        if (nl < 3)
            return;

        Arrays.sort(nums);
        int tmpSum = 0;
        int left = nums[0];
        int right = nums[nl - 1];
        int i = 0;
        for (; i < nl && nums[i] < 0; ++i) {
            if (i > 0 && nums[i] == left)
                continue; // 去重
            left = nums[i];

            for (int j = nl - 1; j> i && nums[j] >= 0 ; --j) {
                if (j < nl - 1 && nums[j] == right)
                    continue; // 去重
                right = nums[j];

                tmpSum = left + right;
                int tmpk = 0;
                if (tmpSum < 0) {
                    // 从右
                    boolean isFirst = true;
                    for (int k = j - 1; k > i && nums[k] >= 0; --k) {
                        if (nums[k] + tmpSum > 0)
                            continue;
                        else if (nums[k]+ tmpSum == 0) {
                            if(isFirst)
                                isFirst = false;
                            else if (nums[k] == tmpk) {
                                break;
                            }
                            tmpk = nums[k];
                            List<Integer> res = new ArrayList<Integer>();
                            res.add(left);
                            res.add(right);
                            res.add(nums[k]);
                            result.add(res);
                        } else {
                            break;
                        }
                    }
                } else if (tmpSum >= 0) {
                    // 从左
                    boolean isFirst = true;
                    for (int k = i+1; k<nl && nums[k] <= 0; ++k) {
                        if (nums[k] + tmpSum < 0)
                            continue;
                        else if (nums[k]+ tmpSum == 0) {
                            if(isFirst)
                                isFirst = false;
                            else if (nums[k] == tmpk) {
                                break;
                            }
                            tmpk = nums[k];
                            List<Integer> res = new ArrayList<Integer>();
                            res.add(left);
                            res.add(right);
                            res.add(nums[k]);
                            result.add(res);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        if (i< nl && nums[i]==0 && i+2<nl && nums[i+2]==0) {
            List<Integer> res = new ArrayList<Integer>();
            res.add(0);
            res.add(0);
            res.add(0);
            result.add(res);
        }
        System.out.println(result);
    }
    
    /**
     * 执行用时：100 ms, 在所有 Java 提交中击败了12.12%的用户
     * 内存消耗：42.4 MB, 在所有 Java 提交中击败了44.02%的用户
     *
     * @param nums
     */
    public void threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // [-5, -4, -3, -1, 0, 0, 0, 2, 2, 2, 3, 3]

        int[] key = findKey(nums);
        if (key.length == 0)
            return;
        if (key[0] == 0 && key[1] != 0)
            return;
        // only do when key[0] > 0
        int i = 0;
        int j = nums.length - 1;
        int left = nums[i];
        int right = nums[j];
        int tmpSum = left + right;
        boolean isGood = false;
        for (j = nums.length - 1; j >= key[0]; --j) {
            if (j < nums.length - 1 && nums[j] == right) {
                continue;
            }
            right = nums[j];
            if (right == 0)
                continue;
            left = nums[0];
            for (i = 0; i< key[0]; ++i) {
                if (i > 0 && nums[i] == left) {
                    continue;
                }
                left = nums[i];
                if (left == 0)
                    continue;
                isGood = false;
                tmpSum = left + right;
                if (tmpSum == 0 && key[1] == 0) {
                    List<Integer> res = new ArrayList<Integer>();
                    res.add(left);
                    res.add(right);
                    res.add(0);
                    result.add(res);
                } else if (tmpSum >= 0 && foundTarget(nums, i+1, key[0]-1, -1*tmpSum)) {
                    isGood = true;
                } else if (tmpSum < 0 && foundTarget(nums, key[0], j-1, -1*tmpSum)) {
                    isGood = true;
                }
                if (isGood) {
                    List<Integer> res = new ArrayList<Integer>();
                    res.add(left);
                    res.add(right);
                    res.add(-1*tmpSum);
                    result.add(res);
                }
            }
        }
        if (key[1] == 0 && key[0]+2 <nums.length && nums[key[0]+2] == 0) {
            List<Integer> res = new ArrayList<Integer>();
            res.add(0);
            res.add(0);
            res.add(0);
            result.add(res);
        }
        System.out.println(result);
    }

    /**
     * 用二分法找到最小的自然数
     * @param nums
     * @return 返回二元数组，[下标, 值]
     */
    public int[] findKey(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int [] res = new int[]{};
        if (i > j)
            return res;
        if (i == j) {
            if (nums[i] < 0)
                return res;
            else
                return new int[] {0, nums[0]};
        }
        int mid = 0;
        while (i <= j) {
            // length >= 2
            mid = (i + j)/2;
            if (nums[mid] < 0) {
                // check next one
                if (nums[mid + 1] >= 0) {
                    res = new int[] {mid + 1, nums[mid + 1]};
                    break;
                } else {
                    if (mid == i) {
                        return new int[]{};
                    }
                    i = mid;
                    continue;
                }
            } else if (nums[mid] > 0) {
                // check before one
                if (mid - 1 < 0 || nums[mid - 1] < 0) {
                    res = new int[] {mid, nums[mid]};
                    break;
                } else {
                    j = mid;
                    continue;
                }
            } else {
                res = new int[] {mid, 0};
                break;
            }
        }
        // fixed
        for (int k = res[0]; k >= 0; --k) {
            if (nums[k] < res[1])
                break;
            if (nums[k] == res[1]) {
                res[0] = k;
            }
        }

        return res;
    }

    /**
     * 用二分法查找目标数是否存在
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    public boolean foundTarget(int[]nums, int start, int end, int target) {
        int tmp = (start + end)/2;
        while(start < end) {
            tmp = (start + end)/2;
            if (nums[tmp] == target) {
                return true;
            } else if (nums[tmp] > target && tmp > 0) {
                end = tmp - 1;
            } else {
                start = tmp + 1;
            }
        }
        if (start == end && nums[start] == target) {
            return true;
        }
        return false;
    }
}
