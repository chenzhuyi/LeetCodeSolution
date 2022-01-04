package leetcode.solution;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        int minLength = strs[0].length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< minLength; ++i) {
            for (int j = 1; j<strs.length;++j) {
                if (strs[j].length() == 0) {
                    return "";
                }
                minLength = strs[j].length() < minLength
                        ? strs[j].length() : minLength;
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}
