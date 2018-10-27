package Leetcode;

/*
* 交换数字
* */
public class LeetCode24 {
    /*
    * my solution
    * 使用了int型中间变量
    * */
    public static ListNode swapPairs(ListNode head) {
//         if (head == null || head.next == null) return head;
         int count = 0;
         ListNode cur = head;
         while (cur != null){
             if (count%2 == 0 && cur.next != null){
                 int val = cur.val;
                 cur.val = cur.next.val;
                 cur.next.val = val;
             }
             cur = cur.next;
             count++;
         }
         return head;
    }

    /*
    * 考虑只使用Node进行swap
    * */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
//        ListNode n5 = new ListNode(5);

        head.next = n2;
        n2.next = n3;
//        n4.next = n5;


        ListNode swapList = LeetCode24.swapPairs(head);
        while(swapList != null) {
            System.out.println(swapList.val);
            swapList = swapList.next;
        }
    }
}
