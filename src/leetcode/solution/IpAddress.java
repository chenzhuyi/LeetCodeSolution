package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class IpAddress {

    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12)
            return res;

        int index = 0;
        String ss = "";
        if (s.startsWith("0")) {
            index = 1;
            ss = ".0";
        }

        parse(res, ss, s,index);
        return res;
    }
 
    private void parse(List<String> res, String prevS, String s, int index) {
        for(int length = 3; length > 0; --length) {
            StringBuilder sb = new StringBuilder(prevS);
            String tmp = tryGet(s, index, length);
            if (!tmp.isEmpty()) {
                sb.append(".").append(tmp);
                if (index + length >= s.length()) {
                    if(sb.toString().split("\\.").length == 5) {
                        res.add(sb.toString().substring(1));
                    }
                }
                parse(res, sb.toString(), s, index + length); // go to next level then
            }
        }
    }

    private String tryGet(String s, int index, int length) {
        if (index > s.length() - 1 || index + length > s.length()) {
            return "";
        }
        String tmp = s.substring(index, index + length);
        if (isValid(tmp)) {
            return tmp;
        }
        return "";
    }

    private boolean isValid(String s) {
        switch (s.length()) {
        case 1:
            return true;
        case 2:
            if (s.startsWith("0"))
                return false;
            return true;
        case 3:
            if (s.startsWith("0"))
                return false;
            if (Integer.valueOf(s) < 256)
                return true;
            return false;
        default:
            return false;
        }
    }
}
