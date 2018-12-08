import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @Auther: orchard.chang
 * @Date: 2018/12/7
 * @Description:
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * 思路：没啥好说的，就是加法，处理好进位和边界问题就好了。问题在于，我特么居然运行时间是42ms，没觉得我的代码比18ms的弱呢。
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        int flag = (l1.val + l2.val) > 9 ? 1 : 0;
        ListNode p = head;
        while (l1.next != null || l2.next != null || flag == 1) {
            if (l1.next != null) {
                l1 = l1.next;
            } else {
                l1.val = 0;
            }
            if (l2.next != null) {
                l2 = l2.next;
            }
            else {
                l2.val = 0;
            }
            p.next = new ListNode((l1.val + l2.val + flag) % 10);
            p = p.next;
            flag = (l1.val + l2.val + flag) > 9 ? 1 : 0;
        }
        return head;
    }

    public ListNode addTwoNumbers_18msWay(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
