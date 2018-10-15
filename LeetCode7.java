package Leetcode;

import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Scanner;

// 翻转整数
public class LeetCode7 {
//    my
    public int reverse(int x) {
        int symbol = 1;
        long x_abs = (long)x;
        if(x < 0) {
            symbol = -1;
            x_abs = -(long)x;
        }
        long value = 0;
        while(x_abs != 0){
//            弹出推入数字
            value  = 10 * value + (int)(x_abs%10);
            x_abs /= 10;
        }
        if(value > Math.pow(2,31)-1){
            value = 0;
        }
        return  (int)value * symbol;
    }

    public int reverse_1(int x){
        long val = 0;
        while(x!=0){
            val = val*10 + x %10;
            x /= 10;
        }
        if(val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) return 0;
        return (int)val;
    }

    public int reverse_2(int x){
        int rev = 0;
        while(x!=0){
            int pop = x%10;
            x /=10;
//            error
            if (rev > (Integer.MAX_VALUE-pop)/10.0 || rev < (Integer.MIN_VALUE-pop)/10.0) {
                return 0;
            }
            rev = rev*10 + pop;
        }
        return rev;
    }


    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter a number");
//        int x = in.nextInt();
        LeetCode7 l = new LeetCode7();
        System.out.println(l.reverse_2(123));
        System.out.println((Integer.MIN_VALUE-3)/10.0);
    }
}
