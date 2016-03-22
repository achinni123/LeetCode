/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  
    public static class sorter implements Comparator<ListNode>{
        public int compare(ListNode l1, ListNode l2){
            return l1.val - l2.val;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(16, new sorter());
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        for(ListNode temp : lists){
            if(temp != null){
                minHeap.add(temp);
            }
        }
        
        while(minHeap.size() > 0){
            ListNode temp = minHeap.poll();
            p.next = temp;
            
            if(temp.next != null){
                minHeap.add(temp.next);
            }
            
            p = p.next;
        }
        
        return head.next;
        
    }
}
