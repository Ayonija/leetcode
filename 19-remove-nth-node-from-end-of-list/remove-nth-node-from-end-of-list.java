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
        // Create two pointers
        ListNode firstPointer = head;
        ListNode secondPointer = head;

        // Move firstPointer n steps ahead
        for (int i = 0; i < n; i++) {
            firstPointer = firstPointer.next;
        }

        // If firstPointer is null, we need to remove the head
        if (firstPointer == null) {
            return head.next; // Remove the head node
        }

        // Move both pointers until firstPointer reaches the end
        while (firstPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        // Remove the nth node from the end
        secondPointer.next = secondPointer.next.next;

        return head; // Return the modified list
    }
}