package Leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

// 整数转罗马数字
public class LeetCode12 {

    /*
    * my solution
    * 从地位到到位，分解出整数的每位数数字，对每位数字代表的值分别进行转化 如：992=900+90+2
    * */
    public static String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        Map<Integer, String> map = new HashMap<Integer, String>(){
            {
                put(1, "I");
                put(5, "V");
                put(10, "X");
                put(50, "L");
                put(100, "C");
                put(500, "D");
                put(1000, "M");
                put(4, "IV");
                put(9, "IX");
                put(40, "XL");
                put(90, "XC");
                put(400, "CD");
                put(900, "CM");
            }
        };

        int exp = 0;
        while(num != 0){
            int res = num % 10;    // 这位数字
            num /= 10;
            int factor = (int)Math.pow(10, exp);
            exp++;
            if (res == 0) continue;   // 此位为0不用单独将此位转化位罗马数字
            int temp = res * factor;
            if (map.containsKey(temp)) {
                builder.insert(0,map.get(temp));
            }
            else
            {
                if (factor >= 1000){    // 底数大于等于1000
                    factor = 1000;
                    while(res>=1) {
                        builder.insert(0,map.get(factor));
                        res--;
                    }
                }
                else {          // 底数小于1000
                    if (res < 4){     // res 为 1，2，3时，只需添加res个I即可
                        while(res>=1) {
                            builder.insert(0,map.get(factor));
                            res--;
                        }
                    }
                    else {
                        while(res>=6){   // res 为 6,7,8时考虑5+1，6+1，7+1的情况
                            builder.insert(0,map.get(factor));
                            res--;
                        }
                        builder.insert(0,map.get(5*factor));
                    }
                }
            }

        }
        return builder.toString();
    }

    /*
    * reference
    *
    * */
    public static String intToRoman1(int num) {
        Map<Integer, String> map = new LinkedHashMap<Integer, String>(){
            {
                put(1000, "M");
                put(900, "CM");
                put(500, "D");
                put(400, "CD");
                put(100, "C");
                put(90, "XC");
                put(50, "L");
                put(40, "XL");
                put(10, "X");
                put(9, "IX");
                put(5, "V");
                put(4, "IV");
                put(1, "I");
            }
        };

        Iterator<Integer> it = map.keySet().iterator();
        StringBuffer sb = new StringBuffer();
        while(it.hasNext()){
            Integer key = it.next();
            String val = map.get(key);
            if (num/key>0){
                for (int i = 0; i < num/key; i++) {
                    sb.append(val);
                }
            }
            num = num - key * (num/key);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(LeetCode12.intToRoman1(num));
    }
}
