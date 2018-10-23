package Leetcode;

import java.util.HashMap;

public class LeetCode1 {

//    两遍hash表
    public int[] twoSum1(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

//        将每个元素的值和它的索引添加到HashMap中
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

//        检查每个元素对应的目标元素是否存在于HashMap中
        for (int i = 0; i < nums.length; i++) {
            int resTarget = target - nums[i];
            if (map.containsKey(resTarget)&& map.get(resTarget) != i)
                return new int[]{i, map.get(target-nums[i])};
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //    一遍hash表 时间复杂度O(n)  空间复杂度O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
