package Leetcode;

import java.util.Arrays;

/*
* 求数组中第K大的数
* 注意数组元素可能重复，而第K大并不要求元素不重复，例如：1 2 3 4 5 5 其中第3大元素为4而非3
* */
public class LeetCode215 {

    /*
    * my solution
    * 内置快排+随机访问
    * 时间复杂度O(nlogn) 空间复杂度O(1)
    * */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);  // 升序
        return nums[nums.length-k];
    }



}
