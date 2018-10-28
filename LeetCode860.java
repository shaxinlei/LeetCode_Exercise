package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode860 {
    /*
    * my solution1 AC
    * 利用一个链表来模拟钱包，每次收到钱时都检查是否满足找零条件，找零结束后将bill插入钱包链表
    * 时间复杂度O(n), 空间复杂度O(n)
    * 超过0%
    * */
    public static boolean lemonadeChange(int[] bills) {
        List<Integer> wallet = new LinkedList<>();
        for (int val: bills
             ) {
            switch (val){
                case 5: {
                    wallet.add(5);
                    break;
                }
                case 10:{
                    if (wallet.contains(5)){
                        wallet.remove(new Integer(5));
                        wallet.add(10);
                    }else {
                        return false;
                    }
                    break;
                }
                case 20:{
                    if (wallet.contains(5)){
                        wallet.remove(new Integer(5));
                        if (wallet.contains(10)){
                            wallet.remove(new Integer(10));
                            wallet.add(20);
                        }else {
                            if (wallet.contains(5)){
                                wallet.remove(new Integer(5));
                                if (wallet.contains(5)){
                                    wallet.remove(new Integer(5));
                                    wallet.add(20);
                                }
                                else {
                                    return false;
                                }
                            }else {
                                return false;
                            }
                        }

                    }else {
                        return false;
                    }
                    break;
                }

            }
        }
        return true;
    }

    /*
    * my solution2 AC
    * 两个变量num5,num10记录下钱包中5元和10元面值的数量，5元无需找零则num5++，10元需检查num5是否大于等于1，若满足则num5--
    * ,num10++，收到20元，有两种找零方案，5+5+5或者5+10，优先后一种，贪婪思想。因为20不会用来找零，无需记录。
    * 时间复杂度O(n) 空间复杂度O(1)
    * 超过100%
    * */
    public static boolean lemonadeChange1(int[] bills) {
        if (bills[0] > 5) return false;   // 第一个用户付10或20刀时，无法找零，返回false

//        记录手中5元面值和10元面值的数量
        int num5 = 0;
        int num10 = 0;
        for (int val: bills
             ) {
            switch (val){
                case 5:{
                    num5++;
                    break;
                }
                case 10:{
                    if (num5 >= 1){
                        num5--;
                        num10++;
                    }
                    else {
                        return false;
                    }
                    break;
                }
                case 20:{
//                    收到面值20时，找零方案不是唯一的
//                    当有5+10的组合时一定要先采用5+10的组合，因为这样能余下更多的5，方便后续的找零，否则可能会找零失败
                    if (num5 >= 1 && num10 >= 1){
                        num5--;
                        num10--;
                    }else if (num5 >= 3){
                        num5 -= 3;
                    }
                    else {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    /*
    * 思想与我的类似，但没有使用switch，也没有每次都检查找零条件，而是先找零，最后检查是否满足five>=0的条件
    * */
    public static boolean lemonadeChange2(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,5,10,20};
        System.out.println(LeetCode860.lemonadeChange(bills));
    }
}
