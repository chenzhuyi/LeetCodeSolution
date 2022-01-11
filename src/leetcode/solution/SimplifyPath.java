package leetcode.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SimplifyPath {

    public String simplifyPath(String path) {
        List<String> list = new ArrayList<>();

        for (String s : path.split("/")) {
            switch(s) {
            case ".":
            case "":
                continue;
            case "..":
                int size = list.size();
                if (size == 0) {
                    continue;
                } else {
                    list.remove(size - 1);
                }
                break;
            default:
                list.add(s);
            }
        }

        return "/"+list.stream().collect(Collectors.joining("/"));
    }
}
