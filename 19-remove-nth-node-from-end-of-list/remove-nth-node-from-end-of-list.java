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
        int length = 0;
        ListNode dummy = head;
        while(dummy != null){
            length++;
            dummy = dummy.next;
        }
        ListNode temp = head;
        ListNode ref = temp;
        int res = length - n;
        int count = 0;
        if(length == n){
            return head.next;
        }
        while(temp != null ){
            count++;
            if(count == res){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return ref;
    }
}