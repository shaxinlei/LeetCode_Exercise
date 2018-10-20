package Leetcode;

import java.util.List;
import java.util.prefs.NodeChangeEvent;

public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode p = removeNthFromEnd(cur.next,n);
        n--;
//        if (n==0) return

        return head;
    }
}
