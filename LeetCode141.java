package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description: 线性表找环
 *
 * @author : sxl_lab
 * @date : 2018-11-17
 * time : 20:44
 */
public class LeetCode141 {
    /**
     * my solution(未AC 超时，题意理解：是链中出现环，而不是判断是否为环形链表)
     * Description:
     *
     * @auther: sxl_lab
     * @date: 2018/11/17 21:02
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode cur = head.next;
        while (cur != null){
            if (cur != head){
                cur = cur.next;
            }else {
                return true;
            }
        }
        return false;
    }

    /**
     * reference(AC) 推荐
     * Description: 利用了Hash表，遍历所有结点并在哈希表中存储每个结点的引用，如果当前结点为null，表示到了tail结点则无环，
     * 若是当前结点的引用已经存在于哈希表中，则表示有环。
     * 时间复杂度O(n) 空间复杂度O(n) n为链表中元素个数
     * @auther: sxl_lab
     * @date: 2018/11/17 21:10
     */
    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)){
                return true;
            }else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    /**
     * reference
     * Description: 快慢指针，快指针每次向前移动两个结点，慢指针每次向前移动一个结点，若有环则必相遇，若无环，必时快指针先到达tail
     * 时间复杂度分析见https://leetcode-cn.com/problems/linked-list-cycle/
     *
     * @auther: sxl_lab
     * @date: 2018/11/17 21:13
     */
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(-4);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = head;
        System.out.println(hasCycle(head));
    }
}
