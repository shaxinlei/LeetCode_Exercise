package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 字符的最短距离
 *
 * @author : sxl_lab
 * @date : 2018-11-13
 * time : 11:01
 */
public class LeetCode821 {
    /**
     * My solution (AC) 但较暴力
     * Description: 第一遍遍历字符串，记录所有字符c的位置，计算S中每个字符到每种c的距离，并保留较小值
     * 时间复杂度O(n), 空间复杂度O(n)
     * @auther: sxl_lab
     * @date: 2018/11/13 11:01
     */
    public static int[] shortestToChar(String S, char C) {
        int len = S.length();
        int[] res = new int[len];
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == C){
                pos.add(i);
            }
        }
        for (int i = 0; i < pos.size(); i++) {
            for (int j = 0; j < len ; j++) {
                int curIndex = pos.get(i);
                if (i == 0){
                    res[j] = Math.abs(j-curIndex);
                }
                else {
                    if (res[j] > Math.abs(j-curIndex)){
                        res[j] = Math.abs(j-curIndex);
                    }
                }
            }
        }
        return res;
    }

    /**
     *
     * Description:分别从左往右和从右往左扫描
     *
     * @auther: sxl_lab
     * @date: 2018/11/13 11:23
     */
    public int[] shortestToChar1(String S, char C) {
        int len = S.length();
        int[] res = new int[len];
        int prev = Integer.MIN_VALUE/2;

        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == C){
                prev = i;
            }
            res[i] = i - prev;
        }

        prev = Integer.MAX_VALUE/2;
        for (int i = len-1; i >= 0 ; i--) {
            if (S.charAt(i) == C){
               prev = i;
            }
            res[i] = Math.min(res[i], prev-i);
        }
        return res;
    }
    public static void main(String[] args) {
        String S = "loveleetcode";
        char c = 'e';
        System.out.println(Arrays.toString(LeetCode821.shortestToChar(S, c)));
    }
}
