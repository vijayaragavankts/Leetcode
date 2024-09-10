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
    public int findGCT(int a, int b){
        while(b != 0){
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }


        ListNode curr = head;
        while(curr != null && curr.next != null){
            int gct = findGCT(curr.val,curr.next.val);
            ListNode gctNode = new ListNode(gct);
            gctNode.next = curr.next;
            curr.next = gctNode;
            curr = gctNode.next;
        }
        return head;
    }
}