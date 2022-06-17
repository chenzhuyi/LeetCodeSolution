package leetcode.solution;

public class FindDiagonalOrder {

    public int[] findDiagonalOrder(int[][] mat) {
        int leni = mat.length;
        int lenj = mat[0].length;
        int[] output = new int[leni * lenj];
        boolean isUp = true;
        int i = 0;
        int j = 0;
        int n = 0;

        while (n < output.length) {
            if (isUp) {
                output[n++] = mat[i--][j++];
                if (i<0 || j == lenj) {
                    isUp=false;
                    i++;
                    if (j == lenj) {
                       j--;
                       i++;
                    }
                }
            } else {
                output[n++] = mat[i++][j--];
                if (j<0 || i == leni) {
                    isUp=true;
                    j++;
                    if (i ==leni) {
                        i--;
                        j++;
                    }
                }
            }
        }
        return output;
    }
}
