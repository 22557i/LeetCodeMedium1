package lcwu;
import java.util.*;
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)return null;
        Set<ListNode>t=new HashSet<>();
        while(head.next!=null){
            if(t.contains(head))return head;
            else t.add(head);
            head=head.next;
        }
        return null;

    }
}
