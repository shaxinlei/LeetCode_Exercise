package Leetcode;

// 删除排序数组中的重复项
public class LeetCode26 {

    /*
    * reference
    * 已排序数组，利用双指针法，慢指针i和快指针j，只要nums[j] =nums[i]，我们就增加j来跳过重复项
    * */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]){
                i++;
//                i,j位置相同时不需要复制
                if (i != j){
                    nums[i] = nums[j];
                }
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4};
        int newSz = LeetCode26.removeDuplicates(nums);
        for (int i = 0; i < newSz; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
