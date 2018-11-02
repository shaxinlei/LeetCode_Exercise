package leetcode;

import java.util.*;

/*
* 有效的括号
* */
public class LeetCode20 {

    /*
    * my solution
    * 利用栈的思想
    * 不区分开括号和闭括号，来进行压栈和匹配
    * 时间复杂度O(n)，因为我们每次只遍历给定字符串中的一个字符并在栈上进行O(1)的压栈和出栈操作
    * 空间复杂度O(n)，当所有的开括号都在左侧时，我们需要将所有的开括号压入栈中
    * */
    public static boolean isValid(String s) {
        if (s==null || s.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<Character, Character>(){
            {
                put('(',')');
                put('{','}');
                put('[',']');
            }
        };

        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.size() != 0){
                char top = stack.get(stack.size()-1);
                if (!map.containsKey(top)) {
                    return false;
                }
                if (s.charAt(i) == map.get(top)){
                    stack.remove(stack.size()-1);
                    continue;
                }
            }
            stack.add(s.charAt(i));
        }
        if (stack.size() == 0) {
            return true;
        }else {
            return false;
        }
    }

    /*
    * 还是利用栈的方法，但区分开闭括号
    * 开括号直接入站，闭括号则
    * */
    public static boolean isValid1(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };
        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
//            闭括号，进行匹配判断
            if (map.containsKey(s.charAt(i))){
                if (stack.size() > 0 && map.get(s.charAt(i)) == stack.get(stack.size()-1)){
                    stack.remove(stack.size()-1);
                    continue;
                }else {
                    return false;
                }
            }else {
                stack.add(s.charAt(i));   // 开括号，直接压栈
            }
        }
        if (stack.size() == 0) {
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(isValid1(s));
    }
}
