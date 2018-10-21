package Leetcode;

// 此题需要考虑如何不适用dummy节点
public class LeetCode19 {
    /*
    * preference
    * 两次遍历法
    * 先遍历一次列表求出列表长度len, 那么我们要删除的就是第len-n+1个元素，在通过一次遍历找到第len-n个元素，删除其后一个元素
    * 时间复杂度O(n)，空间复杂度O(1)
    * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
//        考虑到删除head节点的特情况，增加哑节点，令其指向head节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

//        计算链表长度
        int len = 0;
        ListNode cur = head;
        while (cur != null){
            len++;
            cur = cur.next;
        }

//        删除第len-n+1个节点
        int pos = 0;
        cur = dummy;
//        将指针指向第len-n个节点
        while (pos < (len - n)){
            cur = cur.next;
            pos++;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    /*
    * 双指针方法
    * 首先初始化俩指针都指向dummy节点，其次保证second节点与first距离n个节点，如second节点是1节点，first节点就应该是1+n节点
    * 然后，保持俩节点间距离，向前遍历，直到first == null，即到达了链表尾部
    * 时间复杂度O(n), 空间复杂度O(1)
    * */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

//        初始化双指针位置
        ListNode first = dummy, second = dummy;
        while (n>=0){
            first = first.next;
            n--;
        }

//        维持双指针间的gap，向前平移
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    /*
    * 双指针方法中 对两次循环部分的合并
    * */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

//        初始化双指针位置
        ListNode first = dummy, second = dummy;

//        维持双指针间的gap，向前平移
        while (first != null){
            first = first.next;
            if (n>=0){
                n--;
            }else {
                second = second.next;
            }
        }
        second.next = second.next.next;
        return dummy.next;
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

        ListNode res = removeNthFromEnd1(head, 3);
        while (res != null){
            System.out.println(res.val+" ");
            res = res.next;
        }
    }
}
