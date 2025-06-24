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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        for(int i = 1 ; i < left ; i++) prev = prev.next;
        ListNode start = prev.next;
        prev.next = null;
        ListNode end = start;
        for(int i = left ; i < right; i++) end = end.next;
        ListNode next = end.next;
        end.next = null;

        ListNode curr = start , p = null;
        while(curr != null){
            ListNode n = curr.next;
            curr.next = p;
            p = curr;
            curr = n;
        }
        prev.next = p;
        start.next = next;
        return dummy.next;
    }
}