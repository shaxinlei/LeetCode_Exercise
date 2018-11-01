package Leetcode;

/**
 * Created with IntelliJ IDEA.
 * Description:子数组最大平均数
 * User: sxl_lab
 * Date: 2018-10-31
 * Time: 11:08
 */
public class LeetCode643 {

    /**
     * my solution (能AC)
     * Description: 最简单的暴力循环 移动windows,计算windows内的sum，比较并修正max_sum
     *
     * @auther: sxl_lab
     * @date: 2018/11/1 11:10
     */
    public static double findMaxAverage1(int[] nums, int k) {
        double sumMax = -Double.MAX_VALUE;
        for (int i = 0; i <= nums.length-k; i++) {    //
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[i+j];
            }
            sumMax = Math.max(sumMax, sum);
        }
        return sumMax/k;
    }

    /**
     * my solution
     * Description: 循环(AC)
     * 每次移动窗口时新的元素值小于窗口尾部值，则直接跳过本次循环
     *
     * @auther: sxl_lab
     * @date: 2018/10/31 12:39
     */
    public static double findMaxAverage(int[] nums, int k) {
        double ans = -Double.MAX_VALUE;
        int memVal = 0;
        for (int i = 0; i <=  nums.length-k; i++) {
            // 新值小于要窗口尾部的值，直接continue
            if (i > 0 && nums[i+k-1] < memVal) {
                memVal = nums[i];  // 存下窗口最后一个值
            }else {
                int sum = 0;
                for (int j = 0; j < k; j++) {
                    sum += nums[i+j];
                }
                ans = Math.max(ans, sum);
                memVal = nums[i];  // 存下窗口最后一个值
            }
        }
        return ans/k;   // 注意将求平均的除法放最后算一次，每次比较sum而非avg，否则增加了无谓的计算量
    }

    /**
     *
     * Description: 一次循环 每次移动windowss时重复计算遗留元素的sum
     * 假设当前窗口范围为nums[i]到nums[i+k-1]，其sum为x，则下一个windows的sum为x-nums[i]+nums[i+k]，这样减少了很多重复的计算
     * 时间复杂度O(n) 空间复杂度O(1)
     * @auther: sxl_lab
     * @date: 2018/11/1 12:51
     */
    public static double findMaxAverage2(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double sumMax = sum;
//        i表示窗口尾部的索引
        for (int i = 1; i <= nums.length-k; i++) {
            sum += nums[i+k-1] - nums[i-1];
            sumMax = Math.max(sumMax, sum);
        }
//        for 循环也可以这么写，i表示窗口头部的索引
        /*for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i-k];
            sumMax = Math.max(sumMax, sum);
        }*/
        return sumMax/k;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,1,4,2};
        System.out.println(LeetCode643.findMaxAverage(nums, 4));

    }
}
