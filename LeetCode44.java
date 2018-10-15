package Leetcode;

import java.util.Scanner;

public class LeetCode44 {
    /*
     * 递归方法 本题递归方法参照leetCode10
     * 计算超时
     * */
    public boolean isMatch1(String s, String p) {
//        p为空串
        if (p.isEmpty()) return s.isEmpty();

//        p非空
        if (p.charAt(0) == '*') {
            return isMatch1(s, p.substring(1)) || (s.length() >= 1 && isMatch1(s.substring(1), p.substring(1))) || (s.length() >= 1 && isMatch1(s.substring(1), p));
        } else {
            if (s.length() >= 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '?')) {
                try {
                    return isMatch1(s.substring(1), p.substring(1));
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println();
                }
            }
            return false;

        }
    }

    /*
     * 递归方法 本题递归方法参照leetCode10
     * 计算超时
     * */
    public boolean isMatch2(String s, String p) {
//        p为空串
        if (p.isEmpty()) return s.isEmpty();

//        第一个字符为*
        if (p.charAt(0) == '*') {
            return isMatch2(s, p.substring(1)) || (!s.isEmpty() && isMatch2(s.substring(1), p));
        } else {  // 第一个字符不是*
            //        判断第一个字符是否匹配
            boolean first_match = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?'));
            return first_match && isMatch2(s.substring(1), p.substring(1));
        }
    }

    /*
     * dp 方法
     *
     * */
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;  // s 和 p都是空串
//        s非空，p为空串，一定不匹配
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }

//        s为空， p非空， 只有p全为*才匹配
        for (int j = 1; j <= p.length(); j++) {
//            p中当前位置是否是*，以及当前位置前的部分是否匹配
            dp[0][j] = (p.charAt(j - 1) == '*' && dp[0][j - 1]);
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = (dp[i][j - 1] || dp[i - 1][j]);    // dp[i][j-1] 表认为*表空串， dp[i-1][j] 表*不代表空串的情况并且*已经匹配了s中的第一个字符
                } else {
                    // 不是*号，只有遍历到两个字符相等或p当前符号为*并且前面匹配成功才匹配
                    dp[i][j] = (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') && dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String p = in.next();
        LeetCode44 l = new LeetCode44();
        System.out.println(l.isMatch2(s, p));
    }
}
