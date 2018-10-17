package Leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
* 罗马数字转整数，12题的逆过程
* 遍历有序map中的每个key，将其与s中的一位或两位做比较
* 注意：4，9，40，90，400，900这种数字对应的罗马字母在字符串中只会出现一次，只有1，10，100， 1000这种罗马字母可能出现多次
* */
public class LeetCode13 {
    public static int romanToInt(String s) {
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
                // I, X, C, M可能会连续出现，表示2，3， 200，300..
                while (index <= s.length()-1 && s.charAt(index) == key.charAt(0)){
                    ans += val;
                    index++;
                }
            }else {
                // 遇到IV IX XL XC CD CM
                if (index+1 <= s.length()-1 &&  s.charAt(index) == key.charAt(0) && s.charAt(index +1) == key.charAt(1)){
                    ans += val;
                    index += 2;
                }
            }
        }
        return ans;
    }

    /*
    * reference
    * 使用两个有序数组替代map，思路与romanToInt方法一致
    * */
    public static int romanToInt1(String s) {
        int ans = 0;
        String[] letters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        int index = 0;
        for(int i=0 ; i < letters.length;i++){
            if (letters[i].length() ==1){
                while(index<=s.length()-1 && s.charAt(index) == letters[i].charAt(0)){
                    ans += values[i];
                    index++;
                }
            }else{
                if (index+1 <= s.length()-1 && s.charAt(index) == letters[i].charAt(0) && s.charAt(index+1) == letters[i].charAt(1)){
                    ans += values[i];
                    index += 2;
                }
            }
        }
        return ans;
    }

    /*
    * reference
    * 利用4 9 40 90 400 900只会出现一次的特征，解析每个罗马数组的字母，对特殊情况分开处理
    * 时间复杂度O(n)
    * */
    public static int romanToInt2(String s) {
        int ans = 0;
        if (s.contains("IV") || s.contains("IX")) ans -= 2;
        if (s.contains("XL") || s.contains("XC")) ans -= 20;
        if (s.contains("CD") || s.contains("CM")) ans -= 200;

        int index = 0;
        for (;index<s.length();index++){
            switch(s.charAt(index)){
                case 'M':{
                    ans += 1000;
                    break;
                }
                case 'D':{
                    ans += 500;
                    break;
                }
                case 'C':{
                    ans += 100;
                    break;
                }
                case 'L':{
                    ans += 50;
                    break;
                }
                case 'X':{
                    ans += 10;
                    break;
                }
                case 'V':{
                    ans += 5;
                    break;
                }
                case 'I':{
                    ans += 1;
                    break;
                }
                default:
                    System.out.println(" Unknown character!");
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(LeetCode13.romanToInt2(s));
    }
}
