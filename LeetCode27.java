package Leetcode;


import java.util.Arrays;

public class LeetCode27 {

    /*
    * my basic idea
    * 基本想法，利用一个指针j扫描数组，并申请一个结果数组，一旦发现nums[j]!=val，就将nums[j]存入结果数组
    * 利用了O(n)的额外空间，该方法仅供加深理解
    * */
    public static int removeElement2(int[] nums, int val) {
        if (nums.length==0) return 0;

        int[] res = new int[nums.length];
        int k = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val){
                res[k++] = nums[j];
            }
        }
        System.out.println(Arrays.toString(res));
        return k;
    }

    /*
    * reference & my idea
    * 双指针 慢指针i, 快指针j,当 nums[j]==val 时，递增 j 以跳过该元素。只要 nums[j]!=val，复制nums[j]到nums[i]并同时
    * 递增两个索引。重复这一过程，直到j到达数组末尾，该数组新长度为i。
    * 时间复杂度O(n)，空间复杂度O(1)
    * */
    public static int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        for (; j<nums.length;j++){
            if (nums[j]!=val){
//                i,j位置相同时，不需要重复复制（my idea）
                if (i!=j){
                    nums[i] = nums[j];
                }
                i++;
            }
        }
        return i;
    }


    /*
    * reference
    * 当我们遇到nums[i]==val时，将当前元素与最后一个元素交换，并将数组长度减1，即释放了最后一个元素，通时i不变。当nums[i]!=val
    * 时，增加i直到i到达数组末尾（长度动态变化）
    * 时间复杂度O(n)，空间复杂度O(1)
    * 参考地址：https://leetcode-cn.com/problems/remove-element/solution/
    * */
    public static int removeElement1(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i<n){
            if(nums[i] == val){
                nums[i] = nums[n-1];
                n--;
            }else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int newSz = LeetCode27.removeElement2(nums, 3);
        for (int i = 0; i < newSz; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
