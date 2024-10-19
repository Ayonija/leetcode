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
    public ListNode mergeKLists(ListNode[] lists) {
        // Create a priority queue (min-heap) to store the nodes
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the head of each list to the min-heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        
        // Dummy node to help with the merged list construction
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // While there are nodes in the min-heap
        while (!minHeap.isEmpty()) {
            // Get the smallest node from the heap
            ListNode smallest = minHeap.poll();
            current.next = smallest; // Append it to the merged list
            
            // Move to the next node in the list of the smallest node
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
             
            current = current.next; // Move current pointer forward
        }
        
        return dummy.next; // Return the merged list, skipping the dummy node
    }
}