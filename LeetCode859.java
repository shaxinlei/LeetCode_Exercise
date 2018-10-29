package Leetcode;

import java.util.HashSet;

/*
* 亲密字符串
* */
public class LeetCode859 {
    /*
    * my solution AC
    * 分情况讨论：首先要求两字符串长度相等；当两字符串相同时，如果字符串中每个字符都无重复，则返回false；
    * 当两字符串不同时，记录下字符不同的位置的数量i，不同的字符个数大于等于2和i=1的情况都返回false,
    * 等于2的情况下，交叉位置字符相同则返回True
    * 此方法和LeetCode提供的solution解法相同
    * 时间复杂度O(n) 空间复杂度O(1)
    * */
    public static boolean buddyStrings(String A, String B) {
        if (A.length() < 2 || B.length() < 2 || A.length() != B.length()) return false;

        if (A.equals(B)){
//            我利用了HashSet来验证唯一性，也可以统计26个英文字母的数量来判断唯一性
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < A.length(); i++) {
                if (set.contains(A.charAt(i)))
                    return true;
                else {
                    set.add(A.charAt(i));
                }
            }
            return false;
        }else{    // 字符串A与B长度相等但内容不同
            int[] arr = new int[2];
            int i = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(j)){
                    if (i >= 2) return false;
                    arr[i++] = j;
                }
            }
            // i == 1或i == 2
            if (i == 1){
                return false;
            }
            else {
                if (A.charAt(arr[0]) == B.charAt(arr[1]) && A.charAt(arr[1]) == B.charAt(arr[0])) return true;
                else return false;
            }
        }
    }

    public static void main(String[] args) {
        String A = "ab";
        String B = "ab";
        System.out.println(buddyStrings(A, B));
    }
}
