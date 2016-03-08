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
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + carry_bit;
            carry_bit = temp / 10;
            temp = temp % 10;
            if (result == null) {
                result = new ListNode(temp);
                resultEnd = result;
            } else {
                resultEnd.next = new ListNode(temp);
                resultEnd = resultEnd.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int temp = l1.val + carry_bit;
            carry_bit = temp / 10;
            temp = temp % 10;
            if (result == null) {
                result = new ListNode(temp);
                resultEnd = result;
            } else {
                resultEnd.next = new ListNode(temp);
                resultEnd = resultEnd.next;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            int temp = l2.val + carry_bit;
            carry_bit = temp / 10;
            temp = temp % 10;
            if (result == null) {
                result = new ListNode(temp);
                resultEnd = result;
            } else {
                resultEnd.next = new ListNode(temp);
                resultEnd = resultEnd.next;
            }
            l2 = l2.next;
        }
        if (carry_bit != 0) {
            resultEnd.next = new ListNode(carry_bit);
        }
        return result;
    }
}