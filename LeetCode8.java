package Leetcode;
// 字符串转整数（atoi）
import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCode8 {
    /*
    * my 61mx
    * 通过正则方法找出匹配的数字序列，并通过BigInteger将其转为int
    * */
    public int myAtoi(String str) {
        if(str.length()==0) return 0;
        str = str.trim();  //去除空格
//        捕获组
        String pattern = "^([+-]?\\d+)(.*)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);

        if(m.find()){
            String s = m.group(1);
            BigInteger bi = new BigInteger(s);
            int index = str.indexOf(s);
            if(bi.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE)))<0) return Integer.MIN_VALUE;
            if(bi.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE)))>0) return Integer.MAX_VALUE;
            return bi.intValue();
        }else{
            return 0;
        }
    }
    /*
    * my 31ms
    * 遍历每个字符检测范围，利用数学公式组合成int
    * */
    public int myAtoi_1(String str) {
        str = str.trim();  //去除空格
        if(str.length()==0) return 0;
//        字符串不以字符串或数字开头则为无效转换
        if(str.charAt(0)!='+' && str.charAt(0)!='-' && str.charAt(0)<'0' || str.charAt(0)>'9') return 0;
        int val = 0;
        int j = 0;
        if(str.charAt(0) == '-'){
            for(int i=1;i<str.length();i++){
                if(str.charAt(i)<'0' || str.charAt(i)>'9') break;
                if(val < Integer.MIN_VALUE/10 || (val == Integer.MIN_VALUE/10 && -1*Character.getNumericValue(str.charAt(i))<-8)) return Integer.MIN_VALUE;
                val = 10*val + -1*Character.getNumericValue(str.charAt(i));
            }
            return val;
        }else if (str.charAt(0) == '+'){
            j = 1;
        }
        for(int i=j;i<str.length();i++){
            if(str.charAt(i)<'0' || str.charAt(i)>'9') break;
            if(val > Integer.MAX_VALUE/10 || (val == Integer.MAX_VALUE/10 && Character.getNumericValue(str.charAt(i))>7)) return Integer.MAX_VALUE;
            val = 10*val + Character.getNumericValue(str.charAt(i));
        }
        return val;
    }
    /*
    *  20ms
    *  参考解法
    * */
    public int myAtoi_2(String str) {
        int index = 0, sign = 1, val = 0;
//        去空格
        while(index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
//        首字符为正负号
        if(index < str.length() && (str.charAt(index) == '-' || str.charAt(index) == '+')){
            sign = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit > 9 || digit < 0){ break;}
            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < val || (Integer.MAX_VALUE/10 == val && Integer.MAX_VALUE %10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            val = val * 10 + digit;
            index++;
        }
        return sign * val;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string;");
        LeetCode8 l = new LeetCode8();
        System.out.println(l.myAtoi_2(in.nextLine()));
    }
}
