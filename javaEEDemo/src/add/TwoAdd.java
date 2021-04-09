package add;

/**
 * @author: 吕顺祥
 * @version: 1.0
 * @date: 2021/4/6
 * @describe:
 */
public class TwoAdd {
    public static class ListNode {
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 2;
        l1.next = l1;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode zhizhen = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Num = l1 != null ? l1.val : 0;
            int l2Num = l2 != null ? l2.val : 0;
            int sum = l1Num + l2Num + carry;
            carry = sum / 10;
            zhizhen.next = new ListNode(sum % 10);
            zhizhen = zhizhen.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            zhizhen.next = new ListNode(carry);
        }
        return head.next;
    }
}
