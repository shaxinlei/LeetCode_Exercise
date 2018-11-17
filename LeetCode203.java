package leetcode;

/**
 * Created with IntelliJ IDEA.
 * Description:删除链表元素
 *
 * @author : sxl_lab
 * @date : 2018-11-17
 * time : 20:23
 */
public class LeetCode203 {
    /**
     * my solution(AC)
     * Description: 增加一个帮助结点指向第一个结点，用于帮助删除第一个结点
     * 在删除结点时，考虑从增加一个指向第一结点的帮助结点，用于处理删除第一个结点的情况
     * 时间复杂度O(n) 空间复杂度O(1)
     * @auther: sxl_lab
     * @date: 2018/11/17 20:23
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode helpNode = new ListNode(-1);
        helpNode.next = head;
        ListNode cur = helpNode;
        while(cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return helpNode.next;
    }
}
