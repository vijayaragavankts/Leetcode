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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l3 = new ListNode(0);
        ListNode res = l3;
        while(l1 != null && l2 != null){
            int sum = carry + l1.val + l2.val;
            l3.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            l3 = l3.next;
        }
        while(l1 != null){
            int sum = carry + l1.val;
            l3.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l3 = l3.next;
        }
        while(l2 != null){
            int sum = carry + l2.val;
            l3.next = new ListNode(sum % 10);
            carry = sum / 10;
            l2 = l2.next;
            l3 = l3.next;
        }
        while(carry != 0){
            int sum = carry;
            l3.next = new ListNode(sum % 10);
            carry = sum / 10;
            l3 = l3.next;
        }
        return res.next;
    }
}