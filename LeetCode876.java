package Leetcode;
/*
* 链表中间节点：返回链表的中间节点，奇数个节点时，反回正中间的，偶数个节点时，返回length/2+1个
* */
public class LeetCode876 {

    /*
    * my solution
    * 遍历两次列表，第一次遍历计算链表长度，第二次定位到中间位置进行输出
    * 时间复杂度O(n)，空间复杂度O(1)
    * */
    public static ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode cur = head;
//        遍历链表，计算链表长度
        while (cur != null){
            length++;
            cur = cur.next;
        }
        cur = head;
        int index = -1;
        if (length%2 == 0) index = length/2 + 1;
        else index = (int)Math.ceil(length/2.0);
        while (index > 1){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    /*
    * reference
    * 先将链表结构存储到数组中，再在数组中进行随机访问
    * 时间复杂度O(n) 空间复杂度O(n)
    * */
    public static ListNode middleNode1(ListNode head) {
        ListNode[] list = new ListNode[100];      // 题目中给出了链表中节点数上限为100的限制
        ListNode cur = head;
        int i = 0;
        while (cur != null){
            list[i++] = cur;
            cur = cur.next;
        }
        return list[i/2];
    }

    /*
    * reference
    * 双指针，快指针的移速是慢指针的两倍，慢指针每次移动到相邻节点，快指针每次移动到相间节点
    * 时间复杂度O(n) 空间复杂度O(1)
    * */
    public static ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if (fast.next == null) break;
            else fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {

//        ListNode head = new ListNode(-1);
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        head.next = n2;
//        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(LeetCode876.middleNode1(head).val);

    }
}
