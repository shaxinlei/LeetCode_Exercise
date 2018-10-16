package Leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
* 罗马数字转整数，12题的逆过程
*
* */
public class LeetCode13 {
    public static int romanToInt(String s) {
        String[] letters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        int ans = 0;
        Map<String, Integer> map = new LinkedHashMap<String, Integer>(){
            {
                put("M", 1000);
                put("CM", 900);
                put("D", 500);
                put("CD", 400);
                put("C", 100);
                put("XC", 90);
                put("L", 50);
                put("XL", 40);
                put("X", 10);
                put("IX", 9);
                put("V", 5);
                put("IV", 4);
                put("I", 1);
            }
        };
        int index = 0;
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            Integer val = map.get(key);
            if (key.length() == 1){
                while (index <= s.length()-1 && s.charAt(index) == key.charAt(0)){
                    ans += val;
                    index++;
                }
            }else {
                if (index+1 <= s.length()-1 &&  s.charAt(index) == key.charAt(0) && s.charAt(index +1) == key.charAt(1)){
                    ans += val;
                    index += 2;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(LeetCode13.romanToInt(s));
    }
}
