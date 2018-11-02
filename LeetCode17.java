package leetcode;

import java.util.*;

/*
* 电话号码的字母组合
* */
public class LeetCode17 {

    /*
    * reference
    * 回溯法
    * */
    public  List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        Map<Character,String> map = new HashMap<Character, String>(){
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        StringBuilder sb = new StringBuilder();
        traceBack(ans, 0, sb, map, digits);
        return ans;
    }

    public void traceBack(List<String> ans, int index, StringBuilder sb, Map<Character, String> map, String digits){
//        递归的结束条件
        if (sb.length() == digits.length() ) {
            ans.add(new String(sb));
            return;
        }
        for (int i = index; i < digits.length(); i++) {
            char[] letters = map.get(digits.charAt(i)).toCharArray();
            for (int j = 0; j < letters.length; j++) {
                sb.append(letters[j]);
                traceBack(ans, i+1, sb, map, digits);
                sb.setLength(sb.length()-1);  // 回溯操作
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String digits = in.next();
        System.out.println(new LeetCode17().letterCombinations(digits));
    }
}
