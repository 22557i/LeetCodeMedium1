package lcwu;

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode dummyhead = new ListNode(Integer.MIN_VALUE);
        ListNode prev,curr,next;
        dummyhead.next=head;
        prev=dummyhead;
        curr=head;
        next= head.next;

        while(curr != null && curr.next != null){
            next = curr.next;
            ListNode temp = next.next;
            next.next = curr;
            curr.next = temp;
            prev.next = next;
            prev = curr;
            curr = temp;
        }
        return dummyhead.next;
    }
}
