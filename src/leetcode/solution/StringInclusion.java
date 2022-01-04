package leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class StringInclusion {

    public boolean checkInclusion(String s1, String s2) {
        Map<String, Integer> s2n = new HashMap<>();
        for (char c : s1.toCharArray()) {
            String s = String.valueOf(c);
            s2n.putIfAbsent(s, 0);
            s2n.put(s, s2n.get(s)+1);
        }

        return isCheckOk(s1, s2.toCharArray(), 0, s2n);

    }

    private boolean isCheckOk(String s1, char[] s2c, int startIndex, Map<String, Integer> s2n) {
        Map<String, Integer> s2ntmp = new HashMap<>();
        s2ntmp.putAll(s2n);
        int i = startIndex;
        for (; i < startIndex + s1.length() && i<s2c.length; ++i) {
            String cs = String.valueOf(s2c[i]);
            if (s1.indexOf(cs) >= 0) {
                s2ntmp.put(cs, s2ntmp.get(cs)-1);
                continue;
            } else {
                return isCheckOk(s1, s2c, i+1, s2n);
            }
        }
        if (s2ntmp.values().stream().filter(v -> v ==0).count()==s2n.size()) {
            return true;
        } else if (i < s2c.length){
            return isCheckOk(s1, s2c, startIndex+1, s2n);
        }
        return false;
    }

}
