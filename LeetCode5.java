package leetcode;

import java.util.Scanner;

//求最长回文子串
public class LeetCode5 {
//    暴力搜索的方法 未AC
    public static String longestPalindrome(String s) {
        int maxLen = 1;
        int startIndex = 0;
//        子串长度 i
        for (int i = 1; i <= s.length(); i++) {
//            字串开始位置
            for (int j = 0; j <= s.length()-i; j++) {
                int temp1 = j;
                int temp2 = j+i-1;
                while (temp1<temp2 && s.charAt(temp1) == s.charAt(temp2)){
                    temp1++;
                    temp2--;
                }
                if (temp1>=temp2){
                    maxLen = i;
                    startIndex = j;
                }
            }
        }
        if(startIndex+maxLen > s.length()) {
            return s.substring(startIndex);
        } else {
            return s.substring(startIndex, startIndex+maxLen);
        }
    }
//  暴力搜索的基础上进行了剪枝，AC
    public  static String longestPalindrome1(String s) {
        int maxLen = 1;
        int startIndex = 0;
        for(int len = s.length();len>=1;len--){
            if(len <= maxLen) {
                break;
            }
            for (int i = 0; i <= s.length()-len; i++) {
                int lIndex = i;
                int rIndex = i+len-1;
                while(lIndex<rIndex && s.charAt(lIndex) == s.charAt(rIndex)){
                    lIndex++;
                    rIndex--;
                }
                if(lIndex>=rIndex){
                    maxLen = len;
                    startIndex = i;
                    if(startIndex+maxLen > s.length()) {
                        System.out.println("字串："+s.substring(startIndex));
                    } else {
                        System.out.println("字串："+s.substring(startIndex, startIndex+maxLen));
                    }
                }
            }
        }
        if(startIndex+maxLen > s.length()) {
            return s.substring(startIndex);
        } else {
            return s.substring(startIndex, startIndex+maxLen);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(LeetCode5.longestPalindrome1(s));
    }
}
