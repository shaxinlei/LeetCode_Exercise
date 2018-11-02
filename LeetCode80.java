package leetcode;

import java.util.Arrays;

// 删除排序数组中的重复项 重复元素出现的次数不得超过两次
// 本题类似于26题，与27题有区别
public class LeetCode80 {

    /*
    * my basic idea
    * 基本想法 在26题的基础上增加一个计数器，当mums[i]==nums[j]时，计数器+1，若计数器<=2时，将num[j]存到res中，
    * 当num[i]!=num[j]，将num[j]存入res，然后将j赋给i，并将计数器置1，继续循环
    * */
    public static int removeDuplicates1(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int[] res = new int[nums.length];
        res[0] = nums[0];
        int i = 0, count = 1, k = 1;

        for (int j = 1; j < nums.length; j++){
            if (nums[i] == nums[j]){
                count++;
                if (count<=2){
                    res[k++] = nums[j];
                }
            }else {
                res[k++] = nums[j];
                i = j;
                count = 1;
            }
        }
        System.out.println(Arrays.toString(res));
        return k;
    }

    /*
    * my solution
    * 在上方法的基础上去掉了O(n)的额外空间
    * 此方法扩展性较好，将count<=2改为count<=3就变成了最多允许重复三次
    * 时间复杂度O(n)
    * */
    public static int removeDuplicates2(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int i = 0, count =1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] == nums[j]){
                count++;
                if (count <= 2){
                    nums[++i] = nums[j];
                }
            }else {
                nums[++i] = nums[j];
                count = 1;
            }
        }
        return i+1;
    }

    /*
    * 此方法还需理解
    * */
    public static int removeDuplicates(int[] nums) {
        if (nums.length<2) {
            return nums.length;
        }

        int index = 2;
        for (int i = 2; i < nums.length; i++){
            if (nums[i] != nums[index - 2]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,1,2,2,2,3,3};
        int newSz = LeetCode80.removeDuplicates2(nums);
        for (int i = 0; i < newSz; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
