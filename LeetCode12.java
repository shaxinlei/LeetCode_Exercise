package leetcode;


import java.util.*;

// 整数转罗马数字
// 注意本题整数范围在[1,3999]
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
            if (res == 0) {
                continue;   // 此位为0不用单独将此位转化位罗马数字
            }
            int temp = res * factor;
            if (map.containsKey(temp)) {
                builder.insert(0,map.get(temp));
            }
            else
            {
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
        return builder.toString();
    }

    /*
    * reference
    * 将map中的值降序排列，从前向后解析整数为罗马数字
    * 时间复杂度为O(logn)还是O(nlogn)
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
                    sb.append(val);    // 向后添加
                }
                num = num - key * (num/key);
            }
        }
        return sb.toString();
    }

    /*
    * 使用两个下标对应的数组代替有序的map
    * */
    public static String intToRoman2(int num){
        String[] letters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int index = 0;
        StringBuffer sb = new StringBuffer();
        while (num > 0){
            if (num >= values[index]){
                sb.append(letters[index]);
                num -= values[index];
            }else {
                index++;
            }
        }
        return sb.toString();
    }
    /*
    * reference
    * 最容易理解的方法，当num限定了范围时，最多到3999，考虑将个十百千所有情况下的罗马数字都表示出来
    * 时间复杂度O(1) 空间复杂度O(1)
    * */
    public static String intToRoman3(int num){
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[(num%10)];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(LeetCode12.intToRoman2(num));
    }
}
