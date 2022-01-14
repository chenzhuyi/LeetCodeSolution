package leetcode.solution;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int n : num_set) {
            if (num_set.contains(n-1)) {
                continue;
            }
            int current = n;
            int currentLength = 1;
            while (num_set.contains(current+1)) {
                current += 1;
                currentLength += 1;
            }
            longestStreak = currentLength > longestStreak ? currentLength : longestStreak;
        }

//        for (int num : num_set) {
//            if (!num_set.contains(num - 1)) {
//                int currentNum = num;
//                int currentStreak = 1;
//
//                while (num_set.contains(currentNum + 1)) {
//                    currentNum += 1;
//                    currentStreak += 1;
//                }
//
//                longestStreak = Math.max(longestStreak, currentStreak);
//            }
//        }

        return longestStreak;
    }
}
