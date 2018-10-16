package Leetcode;

public class LeetCode42 {

    /*
    * 暴力破解法
    * 时间复杂度O(n**2) 空间复杂度 O(1)
    * 找出每个位置可以接水的体积，找出每个位置两侧的最大高度，两者中的min-当前位置的高度就是当前位置可以接水的体积
    * */
    public static int trap1(int[] height) {
//        0位置和height位置处不可能接水
        int sum = 0;
        for (int i = 1; i < height.length-1; i++) {
            int l = i-1;
            int r = i+1;
            int l_max = height[l];
            int r_max = height[r];

            while(true){
//                将特殊情况放在开头，排除掉进行减枝
                if ((l==0 && l_max <= r_max) || (r == height.length -1 && r_max< l_max)) break;
                if (l==0 && r==height.length-1) break;
                if (l-1>=0){
                    if (height[--l] > l_max ) {
                        l_max = height[l];
                    }
                }
                if (r+1<=height.length-1){
                    if (height[++r] > r_max) {
                        r_max = height[r];
                    }
                }
            }
            if (height[i]<l_max && height[i]<r_max){
                sum += Math.min(l_max, r_max)-height[i];
            }
        }
        return sum;
    }

    /*
    * DP方法
    * 时间复杂度 O(n) 空间复杂度O(n)
    * 利用DP计算每个位置左右两侧的最大高度，以空间换时间
    * */
    public static int trap2(int[] height) {
        if (height == null || height.length == 0) return 0;
        int ans = 0;
        int size = height.length;
        int[] l_max_arr = new int[size];
        int[] r_max_arr = new int[size];

//        找出每个位置的左侧的最大高度，并存储(这里计算并存储最大高度的方法就是DP)
        l_max_arr[0] = height[0];
        for (int i = 1; i < size; i++) {
            l_max_arr[i] = Math.max(height[i], l_max_arr[i-1]);
        }

//        找出每个位置的右侧的最大高度，并存储
        r_max_arr[size-1] = height[size-1];
        for (int i = size-2; i >= 0 ; i--) {
            r_max_arr[i] = Math.max(height[i], r_max_arr[i+1]);
        }

//        每个位置两侧最大高度中的较小值减去本位置的高度，即这个位置可以接水的体积
        for (int i = 1; i < size-1; i++) {
            ans += Math.min(l_max_arr[i], r_max_arr[i]) - height[i];
        }
        return ans;
    }

    /*
    * 双指针
    *
    * */
   /* public static int trap3(int[] height) {
        int size = height.length;
        int left  = 1;
        int right = size - 1;
        int left_max = 0;
        int right_max = 0;

        while(left < right){
            if()
        }
    }*/

    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(LeetCode42.trap2(a));
    }
}
