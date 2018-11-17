package leetcode;

/**
 * Created with IntelliJ IDEA.
 * Description:删除排序链表中的重复元素
 *
 * @author : sxl_lab
 * @date : 2018-11-17
 * time : 19:59
 */
public class Leetcode83 {
    /**
     * my solution (AC)
     * Description: 两个游标遍历此链表
     * 时间复杂度O(n) 空间复杂度O(1)
     *
     * @auther: sxl_lab
     * @date: 2018/11/17 20:06
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode preNode = head;
        ListNode nextNode = head.next;
        while (nextNode != null){
            if (preNode.val == nextNode.val){
                preNode.next = nextNode.next;
                nextNode = preNode.next;
            }else {
                preNode = preNode.next;
                nextNode = nextNode.next;
            }
        }
        return head;
    }
}
