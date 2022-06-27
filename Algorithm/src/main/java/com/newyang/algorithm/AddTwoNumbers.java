package com.newyang.algorithm;

/**
 * @author NewYang
 * @email 1013836629@qq.com
 * @date 2022/6/24 1:57
 */

public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int over = 0;

        while (l1 != null || l2 != null || over != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int sum = val1 + val2 + over;

            over = sum / 10;

            ListNode node = new ListNode(sum % 10);

            cursor.next = node;
            cursor = node;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return root.next;
    }
}
