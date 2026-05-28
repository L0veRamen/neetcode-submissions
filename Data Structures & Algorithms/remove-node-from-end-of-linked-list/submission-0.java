/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        // traverse to predecessor (size - n) steps from dummy
        ListNode p = dummy;
        for (int i = 0; i < size - n; i++) {
            p = p.next;
        }
        // delete target
        p.next = p.next.next;
        return dummy.next;
    }
}
