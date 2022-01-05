package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class Multiply {

    public String multiply(String num1, String num2) {
        if (num1.length() == 1 && Integer.valueOf(num1) == 0
                || num2.length() == 1 && Integer.valueOf(num2)==0)
            return "0";

        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();

        List<Integer> res = new ArrayList<>();

        int index = 0;
        for(int i = char1.length-1; i>=0; --i) {
            for (int j = char2.length-1; j>=0; --j) {
                index = char2.length - 1 - j + (char1.length-1-i);
                int sub = Integer.valueOf(String.valueOf(char2[j]))
                        * Integer.valueOf(String.valueOf(char1[i]));
                if (res.isEmpty() || res.size()-1 < index) {
                    res.add(sub);
                } else {
                    res.set(index, res.get(index) + sub);
                }
            }
        }
        int added = 0;
        int tmp = 0;
        String resultS = "";
        for (int k = 0; k<res.size(); ++k) {
            tmp = res.get(k)+added;
            added = tmp/10;
            resultS = String.join("", tmp%10+"", resultS);
        }
        if (added > 0)
            resultS = String.join("", added+"", resultS);

        return resultS;
    }
}
