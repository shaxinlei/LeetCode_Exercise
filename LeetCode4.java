package Leetcode;

public class LeetCode4 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        String longestStr = "";

        for (int i = 0; i < s.length(); i++) {
            String tempLongestStr = ""+s.charAt(i);
            int tempLength = 1;
            for (int j = i+1; j < s.length(); j++) {
                // 最长字串里已经包含这个字符
                if(tempLongestStr.indexOf(s.charAt(j)) != -1){
                    break;
                }else{
                    tempLongestStr += s.charAt(j);
                    tempLength++;
                }
            }
            if(tempLength > maxLength){
                maxLength = tempLength;
                longestStr = tempLongestStr;
            }
        }
//        System.out.println(longestStr);
        return maxLength;
    }
    public static void main(String[] args) {
        String s = "pwwkew";
        LeetCode4 a = new LeetCode4();
        System.out.println("maxLength:"+a.lengthOfLongestSubstring(s));
    }
}
