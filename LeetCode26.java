package leetcode;

import java.util.Arrays;

// 删除排序数组中的重复项,只能在原地修改，只能使用O(1)的额外空间
public class LeetCode26 {
    /*
    * my basic idea
    * 基本想法 利用双指针i,j，i指针指向不重复元素的位置，j指针从i指针的下一个位置开始遍历数组，
    * 如果nums[i] == nums[j]，j指向下一个位置，如果不等，就将j处的值保存到一个数组中，并将i的位置置为j，再开始。
    * 使用了O(n)的额外空间，此方法仅供加深理解
    * */
    public static int removeDuplicates1(int[] nums){
        if (nums.length < 2) {
            return nums.length;
        }

        int[] res = new int[nums.length];
        res[0] = nums[0];
        int k = 1;  // res有效长度，因为第一个元素已放置

        for (int i=0, j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]){
                res[k++] = nums[j];
                i = j;
            }
        }
        System.out.println(Arrays.toString(res));
        return k;
    }

    /*
     * reference
     * 已排序数组，利用双指针法，慢指针i和快指针j，只要nums[j] =nums[i]，我们就增加j来跳过重复项
     * i本质上是代表了不重复元素的位置，但因为存在nums[++i] = nums[j]这一操作，使得nuns[i]的值与j的前元素相同
     * */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]){
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }

    /*
    * 使用原数组来存储，仍然是双指针i,j，i指向当前的不重复元素，j用来遍历
    * 若nums[i]!=nums[j]，将nums[j]赋给nums[i],j指向下一个元素，此时nums[i]保存的是j的前一个元素
    * */
    public static int removeDuplicates2(int[] nums){
        if (nums.length < 2) {
            return nums.length;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]){
                i++;
//                i,j位置相同时不需要复制 如：nums={1,2,3,4,4}前4个元素无需重复复制
                if (i != j){
                    nums[i] = nums[j];
                }
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4};
        int newSz = LeetCode26.removeDuplicates2(nums);
        for (int i = 0; i < newSz; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
