package leetcode;

/*
* 比较版本号
* */
public class LeetCode165 {
    /*
    * my solution
    * 先利用split函数分割版本号，将其数字部分存为字符串数组，并将字符数组转为int型，
    * 然后对两个version的版本数组按位比较，注意末尾带0的版本号，如1.0=1 1.0.0=1
    * 时间复杂度 O(n) 空间复杂度O(1)
    * */
    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int[] v1 = new int[arr1.length];
        int[] v2 = new int[arr2.length];

        for (int i = 0; i < v1.length; i++) {
            v1[i] = Integer.parseInt(arr1[i]);
        }

        for (int i = 0; i < v2.length; i++) {
            v2[i] = Integer.parseInt(arr2[i]);
        }

        int i = 0, j = 0;
        while (i<v1.length && j < v2.length){
            if (v1[i] < v2[j]){
                return -1;
            }else if (v1[i] > v2[j]){
                return 1;
            }
            i++;
            j++;
        }
        while (i < v1.length && j >= v2.length){
            if (v1[i] == 0){
                i++;
            }else {
                return 1;
            }
        }
        while (j<v2.length && i >= v1.length){
            if (v2[j] == 0){
                j++;
            }else {
                return -1;
            }
        }
        return 0;
    }

    /*
    * reference
    * 简洁的写法，复杂度与上面的方法一致
    * */
    public static int compareVersion1(String version1, String version2){
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int len = Math.max(arr1.length, arr2.length);

        for (int i = 0; i < len; i++) {
            int a1 = i < arr1.length?Integer.parseInt(arr1[i]):0;
            int a2 = i < arr2.length?Integer.parseInt(arr2[i]):0;

            if (a1 < a2) {
                return -1;
            } else if(a1 > a2) {
                return 1;
            }
        }
        return 0;
    }

    /*
    * reference
    * 未使用String内置的split方法，复杂度更低
    * 此方法待理解
    * */
    public static int compareVersion2(String version1, String version2){
        int sum1 = 0;
        int sum2 = 0;
        int i = 0;
        int j = 0;

        while(i < version1.length() || j < version2.length()){
            sum1 = 0;
            sum2 = 0;
            while(i < version1.length() && version1.charAt(i) != '.') {
                sum1 = 10 * sum1 + version1.charAt(i) - '0';
                i++;
            }

            while(j < version2.length() && version2.charAt(j) != '.') {
                sum2 = 10 * sum2 + version2.charAt(j) - '0';
                j++;
            }

            if(sum1 > sum2) {
                return 1;
            } else if(sum1 < sum2) {
                return -1;
            } else{
                i++;
                j++;
            }
        }

        return 0;
    }

}
