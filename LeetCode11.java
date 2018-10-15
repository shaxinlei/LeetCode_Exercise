package Leetcode;
// 盛水最多的容器，可通过反证法证明 https://segmentfault.com/a/1190000016654619
// 更清晰的证明方法，通过矩阵来理解

public class LeetCode11 {

    /*
     * 双指针法，两个指针从头尾进行扫描计算每个height[i]与height[j]构成的面积
     * 移动height[i]与height[j]较小的指针，移动较小的指针，减小了宽，但有可能增大高
     * 只需进行一次扫描，复杂度O(n)
     * */
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int maxAreaVal = 0;
        while (i < j){
            maxAreaVal = Math.max(maxAreaVal, (j-i)* Math.min(height[i], height[j]));
            if (height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxAreaVal;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }
}
