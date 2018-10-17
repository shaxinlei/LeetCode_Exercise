package Leetcode;

// 最长公共前缀
public class LeetCode14 {
    /*
    * my solution
    * 以第一个字符串为参考对象，比较第一个字符串与后续字串相同前缀的位置
    * */
    public static String longestCommonPrefix(String[] strs) {
//        当字符串数组为空或长度为0时，返回""
        if (strs == null || strs.length == 0 ) return "";
//        当字符串数组中只有一个字符串时，返回它本身
        if (strs.length == 1) return strs[0];

        int index = 0;
        boolean flag = false;
        while(true){
//            index超出str[0]长度，说明str[0]就是最长前缀
            if (index > strs[0].length()-1) return strs[0];
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {

//                index超出strs[i]长度，说明str[i]就是最长前缀
                if (index > strs[i].length()-1) return strs[i];

//                strs[i]在index处字符与其他字符串在index处的字符不同
                if (index < strs[i].length() && strs[i].charAt(index) != c) {
                    index--;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
            // 0到index处前缀相同
//            查看下一个字符
            index++;
        }
        return strs[0].substring(0, index+1);
    }

    /*
    * reference
    * 假设第一个字符串是最长前缀pre，判断pre是否是其他字符串的前缀，不成立时缩小pre长度再匹配
    *
    * */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        int i = 1;
        while (i<strs.length){
            while (strs[i].indexOf(pre)!=0){
                pre = pre.substring(0, pre.length()-1);
            }
            i++;  // 下一个字符串
        }
        return  pre;
    }
    public static void main(String[] args) {
//        String[] strs = {"dog","racecar","car"};
        String[] strs = {""};
        System.out.println(LeetCode14.longestCommonPrefix(strs));
    }
}
