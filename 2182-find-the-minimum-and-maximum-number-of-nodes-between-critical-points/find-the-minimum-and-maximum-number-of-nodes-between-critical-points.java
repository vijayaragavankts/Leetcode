class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode slow = head;
        ListNode current = slow.next;
        ListNode fast = current.next;
        
        if (fast == null)
            return new int[]{-1,-1};
        
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        
        while (fast != null){
            idx++;
            
            if (slow.val < current.val 
                && fast.val < current.val)
                list.add(idx);
            else if (slow.val > current.val && fast.val > current.val)
                list.add(idx);
            
            slow = slow.next;
            current = current.next;
            fast = fast.next;
        }
        
        if (list.size() <= 1) 
            return new int[]{-1,-1};
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 1; i < list.size(); i++){
            if (min > list.get(i) - list.get(i-1))
                min = list.get(i) - list.get(i-1);
        }
        max = list.get(list.size()-1) - list.get(0);
        
        return new int[]{min, max};
    }
}