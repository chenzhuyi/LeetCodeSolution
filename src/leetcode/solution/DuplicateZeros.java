package leetcode.solution;

import java.util.Arrays;

public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {

        int[] list = Arrays.copyOf(arr, arr.length);
        int j = 0;
        for (int i = 0; i<arr.length; ++i) {
            if (j == arr.length) {
                break;
            }
            if (list[i] == 0) {
                arr[j++] = 0;
                if (j == arr.length) {
                    break;
                }
                arr[j++] = 0;
            } else {
                arr[j++] = list[i];
            }
        }
    }
}
