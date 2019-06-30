package lcwu;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode beforeHead = head;
        int temp = m;
        while (temp > 2) {
            beforeHead = beforeHead.next;
            temp--;
        }
        ListNode start = beforeHead.next;
        if (m == 1) {
            start = head;
        }
        int cnt = n - m;
        ListNode prev = start;
        ListNode cur = start.next;
        while (cnt > 0) {
            cnt--;
            ListNode nn = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nn;
        }

        start.next = cur;

        if (m != 1) {
            beforeHead.next = prev;
            return head;
        }
        return prev;
    }
}
