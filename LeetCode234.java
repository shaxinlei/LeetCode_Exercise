package leetcode;

/**
 * Created with IntelliJ IDEA.
 * Description:回文链表
 *
 * @author : sxl_lab
 * @date : 2018-11-19
 * time : 11:47
 */
public class LeetCode234 {
    /**
     * reference(AC)
     * Description: 双指针的思想 首先遍历一遍链表，得到链表长度。第二次遍历到链表中间，并在遍历时反转前半部分链表，最后使用两个指针分别
     * 从中间向两侧遍历结点，判断是否对称
     *
     * 时间复杂度O(n) 空间复杂度O(1)
     * @auther: sxl_lab
     * @date: 2018/11/19 14:00
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        ListNode cur = head;
        ListNode prev= null, lNode = null, rNode =null;
        int len = 0;
//        计算链表长度
        while (cur != null){
            len++;
            cur = cur.next;
        }
        cur = head;
//        寻找中间指针，反转前半部分链表
        for (int i= 0;i< len/2;i++){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
//        明确两个mid指针
        if (len%2 == 0){
            lNode = prev;
            rNode = cur;
        }else {
            lNode = prev;
            rNode = cur.next;
        }
//        从两个mid指针向头尾遍历
        while (lNode != null && rNode != null){
            if (lNode.val != rNode.val){
                return false;
            }
            lNode = lNode.next;
            rNode = rNode.next;
        }
        return true;
    }

    /**
     *
     * Description: 也是双指针思想，但这里没有先遍历链表来确定链表中间结点，而是通过快慢指针来找到中间节点
     *
     * @auther: sxl_lab
     * @date: 2018/11/19 17:49
     */
    public static boolean isPalindrome1(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = p1.next;
        ListNode pre = p1;
        //find mid pointer, and reverse head half part
        while(p2.next != null && p2.next.next != null) {
            p2 = p2.next.next;
            pre = p1;
            p1 = p3;
            p3 = p3.next;
            p1.next = pre;
        }

        //odd number of elements, need left move p1 one step 奇数个元素
        if(p2.next == null) {
            p1 = p1.next;
        }
        else {   //even number of elements, do nothing

        }
        //compare from mid to head/tail
        while(p3 != null) {
            if(p1.val != p3.val) {
                return false;
            }
            p1 = p1.next;
            p3 = p3.next;
        }
        return true;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(isPalindrome(head));
    }
}
