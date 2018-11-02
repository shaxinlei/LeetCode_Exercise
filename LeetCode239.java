package leetcode;

import java.util.Arrays;

public class LeetCode239 {
    /*
    * my solution
    * 遍历每个window，计算每个window的max值
    * 时间复杂度O(n)，空间复杂度O(n)
    * */
    public static int[] maxSlidingWindow(int[] nums, int k) {
//        数组长度为0，或者数组长度小于window size
        if ( nums.length ==0 || nums.length < k ) {
            return new int[]{};
        }

//        Slide Window的个数，step为1的情况下适用，不同step需另外计算
        int[] res = new int[nums.length-k+1];
//        Slide Window，计算每个window内的max
        for (int i = 0; i < nums.length-k + 1; i++) {
            res[i] = max(nums,i,i+k-1);
        }
        return res;
    }

    /*
    * 计算nums数组在[left,right]区间上的最大值
    * */
    public static int max(int[] nums, int left, int right){
        int max_val = nums[left];
        for (int i = left+1; i <= right ; i++) {
            if (nums[i] >  max_val) {
                max_val = nums[i];
            }
        }
        return max_val;
    }

    public static void main(String[] args) {

//        int[] nums= {1,3,-1,-3,5,3,6,7};
        int[] nums= {};
        System.out.println(Arrays.toString(LeetCode239.maxSlidingWindow(nums,0)));
    }
}
