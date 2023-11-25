/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode temp = slow;
                do{
                    count++;
                    temp = temp.next;
                }while(temp != fast);
                break;
            }
        }
        if(count == 0){
            return null;
        }
        ListNode l1 = head;
        ListNode l2 = head;
        while(count-- > 0){
            l1 = l1.next;
        }
        while(l1 != l2){
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }
}