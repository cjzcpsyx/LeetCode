/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry_bit = 0;
        ListNode result = null;
        ListNode resultEnd = null;
        while (l1 != null || l2 != null || carry_bit != 0) {
            int temp = carry_bit;
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            carry_bit = temp / 10;
            temp = temp % 10;
            if (result == null) {
                result = new ListNode(temp);
                resultEnd = result;
            } else {
                resultEnd.next = new ListNode(temp);
                resultEnd = resultEnd.next;
            }
        }
        return result;
    }
}