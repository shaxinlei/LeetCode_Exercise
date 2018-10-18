package Leetcode;

// 反转单链表
public class Leetcode206 {
//    循环方法
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;  // 反转后链表的头节点
        while (cur!=null){
            ListNode temp = cur.next;  // 保存当前节点的next节点
            cur.next = prev;    // 当前节点指向前节点
            prev = cur;        // 当前节点成为下个循环的前节点
            cur = temp;       // 当前节点的指针移至下一个节点
        }
        return prev;
    }

//    递归方法进行链表翻转
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);    // p节点为翻转后的头节点（原来的tail，最终的head）
        head.next.next = head;
        head.next = null;
        return p;  // 传递头节点
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode reversedList = Leetcode206.reverseList1(head);
        while(reversedList != null) {
            System.out.println(reversedList.val);
            reversedList = reversedList.next;
        }
    }

}


