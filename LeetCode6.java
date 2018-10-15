package Leetcode;
// Z字型变换
public class LeetCode6 {
    public static String convert(String s, int numRows) {
        int len = s.length();
        String res = "";
        if(len <= numRows || numRows ==1)
            return s;
        int interval = 2*numRows-2,k;
//        添加首行的字符
        for (k = 0;k<len;k=k+interval){
            res += s.charAt(k);
        }
//        添加中间行的字符
        for (int i = 1; i < numRows-1; i++) {
            int j = 2*i;
            for(k=i;k<len;k=k+j){
                res += s.charAt(k);
                j = interval - j;
            }
        }
//        添加最后一行的字符
        for(k=numRows-1;k<len;k=k+interval){
            res += s.charAt(k);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(LeetCode6.convert(s,numRows));
    }
}
