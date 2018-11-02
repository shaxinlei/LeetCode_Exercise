package leetcode;

import java.util.*;

public class LeetCode15 {

    /*
    * 此题类似第1题，采用先排序后逼近的方法
    * 这个方法可以推广到k-sum，先排序，然后做k-2次循环，再最内层实现左右夹逼，时间复杂度是O(max{nlogn, pow(n, k-1)})
    * 时间复杂度:O(n^2)
    * */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if( nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i];
            int j = i+1;  // 左游标
            int k = nums.length-1;  // 右游标
            while(j<k){
                if (nums[j] + nums[k] < target){
                    j++;
                    while (j<k && nums[j] == nums[j-1]) {
                        j++;
                    }
                }
                else if (nums[j] + nums[k] > target){
                    k--;
                    while (j<k && nums[k] == nums[k+1]) {
                        k--;
                    }
                }
                else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j<k && nums[j] == nums[j-1]) {
                        j++;
                    }
                    while (j<k && nums[k] == nums[k+1]) {
                        k--;
                    }
                }
            }
        }
        return res;
    }

    /*
    * 对方法一减枝
    * 当num[i]>0时，nums[i] + nums[j] + nums[K] 一定大于0，不合条件，可以退出循环
    * 将等于的情况放最前面，可以减去一些情况
    * 比方法一稍快
    * */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if( nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] >= 0) {
                break;
            }
            int target = -nums[i];
            int j = i+1;  // 左游标
            int k = nums.length-1;  // 右游标
            while(j<k){
                if (nums[j] + nums[k] == target){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j<k && nums[j] == nums[j+1]) {
                        j++;
                    }
                    while (j<k && nums[k] == nums[k-1]) {
                        k--;
                    }
                    j++;
                    k--;
                }
                else if (nums[j] + nums[k] > target){
                    k--;
//                    while (j<k && nums[k] == nums[k+1]) k--;  // 不在这边跳过重复值，好像速度更快
                }
                else {
                    j++;
//                    while (j<k && nums[j] == nums[j-1]) j++;   // 不在这边跳过重复值，好像速度更快
                }
            }
        }
        return res;
    }

    /*
    * hash表的方法
    * */
//    public List<List<Integer>> threeSum3(int[] nums) {
//
//    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        LeetCode15 l = new LeetCode15();
        System.out.println(l.threeSum2(nums));
    }
}
