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
    // TC - O(n) - We are iterating till the last node
    // SC - O(1) - we are using cyr and prev pointers which takes constant extra space
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;         // prev always points to null
        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
