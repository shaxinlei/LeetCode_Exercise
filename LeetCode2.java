package leetcode;

/*
* 两数相加
* 从低到高加，每次记住进位即可
* */
public class LeetCode2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pre = head;  // pre跟踪当前节点
        int rem = 0;  // 余数
        int flag = 0;  // 进位
        int index = 0;
        while (l1 != null && l2 != null){
            if (index == 0) {
                rem = (l1.val + l2.val)%10;
                flag = (l1.val  + l2.val)/10;
                head.val = rem;
                index++;
            }
            else{
                rem = (l1.val + l2.val + flag)%10;
                flag = (l1.val  + l2.val + flag)/10;
                pre.next = new ListNode(rem);
                pre = pre.next;
            }
            l1 = l1.next;
            l2  = l2.next;
        }
        while (l1 != null && l2 == null){
            rem = (l1.val + flag)%10;
            flag = (l1.val + flag)/10;
            pre.next = new ListNode(rem);
            pre = pre.next;
            l1 = l1.next;
        }
        while (l2 != null && l1 == null){
            rem = (l2.val + flag)%10;
            flag = (l2.val + flag)/10;
            pre.next = new ListNode(rem);
            pre = pre.next;
            l2 = l2.next;
        }
        if (flag != 0){
            pre.next = new ListNode(flag);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l1_2 = new ListNode(4);
//        ListNode l1_3 = new ListNode(2);
        l1.next = l1_2;
//        l1_2.next = l1_3;

        ListNode l2 = new ListNode(4);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(5);
        l2.next = l2_2;
        l2_2.next = l2_3;

        ListNode res = LeetCode2.addTwoNumbers(l1, l2);
        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
