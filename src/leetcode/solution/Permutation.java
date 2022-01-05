package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public String getPermutation(int n, int k) {

        if (n ==1)
            return "1";
        if (n == 2) {
            if (k == 1)
                return "12";
            else
                return "21";
        }

        int res = 1;
        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=n;++i) {
            res = res * i;
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        int p = k;
        int num = res;
        int hint = res;
        for (int j = n; j>2; --j) {
            hint = hint/j;
            num = p%hint;
            p = p/hint;
            if (num == 0) {
                sb.append(list.remove(p-1));
                for(int w = list.size()-1; w>=0; --w) {
                    sb.append(list.get(w));
                }
                return sb.toString();
            } else {
                sb.append(list.remove(p));
                p = num;
            }
        }
        if (num % 2 == 0) {
            sb.append(list.get(1)).append(list.get(0));
        } else {
            sb.append(list.get(0)).append(list.get(1));
        }
        return sb.toString();
    }
}
