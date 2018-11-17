package leetcode;
/**
 * Created with IntelliJ IDEA.
 * Description:合并两个有序列表
 *
 * @author : sxl_lab
 * @date : 2018-11-17
 * time : 16:50
 */
public class LeetCode21 {
    /**
     * my reference(AC)
     * Description:加入头结点res，使用两个游标遍历两个列表的每个结点，将val较小的结点接在res结点后，
     * 遍历过程参照归并排序中的合并函数
     *
     * @auther: sxl_lab
     * @date: 2018/11/17 19:18
     */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
//        头结点，它指向第一个结点
        ListNode helpNode = new ListNode(-1);
        ListNode curNode = helpNode;
//        游标
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                curNode.next = l1;
                l1 = l1.next;
            }else{
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        while (l1 != null){
            curNode.next = l1;
            l1 = l1.next;
            curNode = curNode.next;
        }
        while (l2 != null){
            curNode.next = l2;
            l2 = l2.next;
            curNode = curNode.next;
        }
        return helpNode.next;
    }
    /**
     * reference(AC) 推荐
     * Description: 递归解法
     *
     * @auther: sxl_lab
     * @date: 2018/11/17 19:34
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
//        递归基准条件
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l2.next = l22;
        l22.next = l23;

        ListNode res = mergeTwoLists(l1, l2);
        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
