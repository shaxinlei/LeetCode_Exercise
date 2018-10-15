package Leetcode;

public class LeetCode42 {

    /*
    * 暴力破解法
    * 时间复杂度O(n**2) 空间复杂度？？
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
    *
    * DP
    * */
    /*public static int trap2(int[] height) {

    }*/

    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(LeetCode42.trap1(a));
    }
}
