package leetcode;
// Leetcode第4题 两个排序数组的中位数

public class LeetCode3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length3 = length1 + length2;
        int[] nums3 = new int[length3];
        int i=0,j=0,k=0;
        while(i<length1&&j<length2){
            if (nums1[i]<nums2[j]){
                nums3[k++] = nums1[i++];
            }else{
                nums3[k++] = nums2[j++];
            }
        }
        while(i<length1){
            nums3[k++] = nums1[i++];
        }
        while(j<length2){
            nums3[k++] = nums2[j++];
        }
        if(length3%2 == 0){
            median = (nums3[(int)Math.floor((length3-1)/2.0)]+ nums3[(int)Math.ceil(((length3-1)/2.0))])/2.0;
        }else{
            median = nums3[(length3-1)/2];
        }
        return median;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 7, 8};
        int[] nums2 = {1, 2, 3, 6};
        LeetCode3 a = new LeetCode3();
        System.out.println("median:"+ a.findMedianSortedArrays(nums1,nums2));
    }
}
