package lcwu;

import java.util.ArrayList;
import java.util.List;

class Solution725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[]res  = new ListNode[k];
        if(root == null){
            return res;
        }
        ArrayList<ListNode> nodeDirectory = new ArrayList<>();
        ListNode head = root;
        while(head!=null){
            nodeDirectory.add(head);
            head = head.next;
        }
        int size = nodeDirectory.size();
        System.out.println(size);
        int otherpartssize = size/k;
        int remainingsize = (size % k);
        if(otherpartssize == 0) remainingsize -= k;

        ListNode curr = root;


        for (int i = 0; i < k; ++i) {
            ListNode dummyhead = curr;
            for (int j = 0; j < otherpartssize + (i < remainingsize ? 1 : 0) - 1; ++j) {
                if (curr != null) curr = curr.next;
            }
            if (curr != null) {
                ListNode prev = curr;
                curr = curr.next;
                prev.next = null;
            }
            res[i] = dummyhead;
        }
        return res;
    }
}