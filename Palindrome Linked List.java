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
// using double ended queue(deque)
// tc - O(n)
// sc - O(n)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        
        Deque<Integer> st = createStack(head);
        ListNode current = head;
        while(!st.isEmpty()) {
            if(st.pop() != current.val){
                return false;
            }
            current = current.next;
        }
        return true;
    }
    private Deque<Integer>createStack(ListNode head) {
        Deque<Integer> st = new ArrayDeque<>();
        ListNode current = head;
        while(current != null) {
            st.push(current.val);
            current = current.next;
        }
        return st;
    }
}



