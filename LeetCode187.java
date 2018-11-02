package leetcode;

import java.util.*;

/*
* 重复的DNA序列
* */
public class LeetCode187 {

    /*
    * my solution AC
    * 利用HashMap存储每个字串出现过的次数，将value大于等于2的key输出
    * 时间复杂度O(n), 空间复杂度O(1)
    * */
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();

        if (s.length() < 11) {
            return ans;
        }
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i <= s.length()-10; i++){
            String sub = s.substring(i, i+10);
            if (map.containsKey(sub)){
//                这个字串出现了两次以上时，该字串不添加到结果列表
                if (map.get(sub) < 2) {
                    map.remove(sub);
                    map.put(sub, 2);
                    ans.add(sub);
                }
            }else {
                map.put(sub,1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "AAAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s));
    }
}
