package leetcode.solution;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NotRepeatableSubString {

    public NotRepeatableSubString() {
        
    }

    /**
     * 考滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;
        if (s.length() == 1)
            return 1;
        int maxLength = 1;

        char[] chars = s.toCharArray();

        int i = 0;
        int j = i + 1;
        String subString = s.substring(i, j);

        int index = -1;
        while (j < s.length()) {
            index = subString.indexOf(String.valueOf(chars[j]));
            if (index >= 0) {
                maxLength = subString.length() > maxLength ? subString.length() : maxLength;
                i = index + 1;
                subString = subString.substring(index + 1);
            } else {
                subString = subString + chars[j];
                ++j;
            }
        }

        maxLength = subString.length() > maxLength ? subString.length() : maxLength;

        return maxLength;
    }
}
