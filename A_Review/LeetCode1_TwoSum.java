package Leetcode.A_Review;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1_TwoSum {
    /*
    * 两重循环
    * 时间复杂度O(n^2) 空间复杂度O(1)
    * */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length && j!= i; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("No two solution");
    }

    /*
    * 两次hash
    * */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int resTarget = target - nums[i];
            if (map.containsKey(resTarget) && map.get(resTarget) != i){
                return new int[]{i, map.get(resTarget)};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] res = twoSum1(nums, target);
        for (int a : res) {
            System.out.println(a + " ");
        }
    }
}
