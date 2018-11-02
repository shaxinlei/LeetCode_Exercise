package leetcode;

import java.util.Scanner;

public class LeetCode10 {
    /*
     * 参照解答的递归做法
     *
     * */
    public boolean isMatch(String s, String p) {
//        字符模式为空时，只有字符串为空返回true
        if(p.isEmpty()) {
            return s.isEmpty();
        }

//        判断第一个字符死否匹配（此时字符模式非空）
        boolean first_match = false;
        if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            first_match = true;
        }

//        第二个字符为星号时
//        判断字符串s与去除*号后的字符模式是否匹配，即*取0次
//        *至少取1次，在第一个字符相同的情况下判断s剩余字符与字符模式p是否匹配
        if(p.length() >= 2 && p.charAt(1) == '*'){
            return isMatch(s, p.substring(2)) || first_match && isMatch(s.substring(1), p);
        }else{
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter string:");
        String str = in.next();
        System.out.println("Enter pattern:");
        String pattern = in.next();
        LeetCode10 l = new LeetCode10();
        System.out.println(l.isMatch(str, pattern));
    }
}
