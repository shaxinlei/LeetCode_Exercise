package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        char[] chars = {'(', ')'};
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        traceBack(chars, sb, res, 1, n);
        return res;
    }

    public void traceBack(char[] chars, StringBuilder sb, List<String> res, int index, int n){
        if(sb.length() == n){
            res.add(sb.toString());
            return;
        }
        for (int i = index; i < n; i++) {
            for (int j = 0; j < chars.length; j++) {
                sb.append(chars[j]);
                traceBack(chars, sb, res, index+1, n);
                sb.setLength(sb.length()-1);   // 回溯操作
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<String> res = new LeetCode22().generateParenthesis(n);
        for (String s:res
             ) {
            System.out.println("s");
        }
    }
}
