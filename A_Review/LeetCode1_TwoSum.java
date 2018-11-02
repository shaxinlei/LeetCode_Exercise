package leetcode.A_Review;

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
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two solution");
    }

    /*
    * 两遍hash
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

    /*
    * 一遍hash
    * 在遍历的时候查看，已插入map的元素中是否有当前元素的对应目标元素
    * 没有性能的提升，而且下降了程序的可读性
    * */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int resTarget = target - nums[i];
            if(map.containsKey(resTarget)){
                return new int[]{map.get(resTarget), i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {1, 3,3,4};
        int target = 6;
        int[] res = twoSum2(nums, target);
        for (int a : res) {
            System.out.println(a + " ");
        }
    }
}
