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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ref = dummy;
        ListNode prev = null;
        ListNode curr = dummy;
        for(int i=0;i<left;i++){
            prev = curr;
            curr = curr.next;
        }
        ListNode previous = prev;
        ListNode current = curr;
        for(int i=left;i<=right;i++){
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        prev.next = previous;
        curr.next = current;
        return ref.next;
    }
}