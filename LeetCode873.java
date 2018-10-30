package Leetcode;

import java.util.HashSet;

public class LeetCode873 {

    /*
    * reference
    * 使用暴力搜索的方法，指定起始对A[i],A[j]，~搜索y=A[i]+A[j]是否在数组中，如过在数组中，则继续搜索，否则换新的起始对
    * 时间复杂度O(n^2logM) n为数组长度，M为数组Max值  空间复杂度O(n)
    * */
    public static int lenLongestFibSubseq(int[] A) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i: A) set.add(i);
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int x = A[j], y = A[i] + A[j];
                int len = 2;
                while (set.contains(y)){
                    int temp = y;
                    y += x;     // y为要搜索的下一个目标值
                    x = temp;
                    ans = Math.max(ans, ++len);
                }
            }
        }
        return ans >= 3 ? ans:0;
    }

    public static void main(String[] args) {
        int[] A = {1,3,7,11,12,14,18};
        System.out.println(lenLongestFibSubseq(A));
    }

}
