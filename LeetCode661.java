package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 图片平滑器
 *
 * @author : sxl_lab
 * @date : 2018-11-15
 * time : 21:06
 */
public class LeetCode661 {
    /**
     * reference
     * Description: 直接遍历每个位置，计算每个位置周围8个位置中有效位置之和，并记录下有效位置个数
     * 时间复杂度O(N) N指的是像素数
     * 空间复杂度O(N) N指的是像素数
     * @auther: sxl_lab
     * @date: 2018/11/15 21:51
     */
    public static int[][] imageSmoother(int[][] M) {
        int rows = M.length;
        int columns = M[0].length;
        int[][] res = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int count = 0;
                for (int k = i-1; k <= i+1; k++) {
                    for (int l = j-1; l <=j+1 ; l++) {
                        if (k>=0 && k<rows && l>=0 && l<columns){
                            res[i][j] += M[k][l];
                            count++;
                        }
                    }
                }
                res[i][j] /= count;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] M= {{1}};

        System.out.println(Arrays.toString(imageSmoother(M)));
    }
}
