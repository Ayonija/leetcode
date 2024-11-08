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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy; // Points to the end of the previous group
        
        while (true) {
            // Check if there are at least k nodes left to reverse
            ListNode kthNode = getKthNode(prevGroupEnd, k);
            if (kthNode == null) break; // Not enough nodes left
            
            // Store the next group start
            ListNode nextGroupStart = kthNode.next;
            
            // Reverse current group
            ListNode prev = kthNode.next; // This will become the new end of the reversed group
            ListNode curr = prevGroupEnd.next; // Start of the group to be reversed
            
            while (curr != nextGroupStart) {
                ListNode temp = curr.next; // Store next node
                curr.next = prev; // Reverse current node's pointer
                prev = curr; // Move prev to current node
                curr = temp; // Move to next node
            }
            // Connect previous group with reversed group
            ListNode newGroupStart = prevGroupEnd.next; // Start of reversed group
            prevGroupEnd.next = kthNode; // Connect end of previous group to new head
            newGroupStart.next = nextGroupStart; // Connect end of reversed group to next group
            
            // Move prevGroupEnd pointer for the next iteration
            prevGroupEnd = newGroupStart;
        }
        
        return dummy.next; // Return new head of the modified list
    }

        
    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start; // Returns null if there are less than k nodes left
    }
}