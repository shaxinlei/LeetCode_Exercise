package leetcode;

import java.util.Scanner;

public class LeetCode9 {
    /*
    * 将数字回文转换为字符串回文，对应字符逐一比对
    * 缺点：需要申请存储字符串的空间
    * */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
//        String str = Integer.toString(x);   // 好像比valueOf方法更快
        String str = String.valueOf(x);
        int i = 0;
        int j = str.length()-1;
        while (i<=j){
            if (str.charAt(i)!=str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /*
    * 参考解法：使用数学方法翻转一半数字进行判断
    * */
    public boolean isPalindrome_1(int x){
//        以0结尾但非零的数不是回文数
//        负数不是回文数
        if (x < 0 || (x %10 ==0 && x != 0)) {
            return false;
        }

        int revertedNum = 0;
        while(x > revertedNum){
            revertedNum = 10*revertedNum + x % 10;
            x /= 10;
        }
//        当x长度为奇数时， revertedNum/10可以去除中位数
        return x == revertedNum || x == revertedNum/10;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string;");
        LeetCode9 l = new LeetCode9();
        System.out.println(l.isPalindrome(in.nextInt()));
    }
}
