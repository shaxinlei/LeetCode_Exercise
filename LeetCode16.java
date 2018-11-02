package leetcode;

import java.util.Arrays;

// 最接近的三个数之和
public class LeetCode16 {
    /*
    * 双指针法，先排序，再移动两侧指针
    * */
    public static int threeSumClosest(int[] nums, int target) {
        int min_dis = 10000;
        int sum = 0;
        if (nums.length<3) {
            return 0;
        }
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; i++) {
            int left = i+1;
            int right = arr.length-1;
            while (left<right){
                int distance = Math.abs(arr[i] + arr[left] + arr[right]-target);
                if(distance < min_dis) {
                    sum = arr[i] + arr[left] + arr[right];
                    min_dis = distance;
                }

                if (arr[i] + arr[left] + arr[right] == target) {
                    return target;
                }else{
                    if (arr[i] + arr[left] + arr[right] <= target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2,1,-4};
        System.out.println(LeetCode16.threeSumClosest(nums, 1));
    }
}
