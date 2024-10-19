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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to serve as the starting point of the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Traverse both lists and append the smaller node to the merged list
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;  // Append list1 node
                list1 = list1.next;     // Move to the next node in list1
            } else {
                current.next = list2;  // Append list2 node
                list2 = list2.next;     // Move to the next node in list2
            }
            current = current.next;     // Move to the next position in the merged list
        }

        // If there are remaining nodes in either list, append them
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
         // The merged list starts from the next of dummy node
        return dummy.next;
    }
}