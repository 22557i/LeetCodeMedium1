package lcwu;

import java.util.Stack;

public class Solution2 {
     public ListNode addTwoNumbers(ListNode l1, ListNode l2){
         if(l1==null&&l2==null)return l1;
         if(l1==null) return l2;
         if(l2==null) return l1;
         ListNode Res = new ListNode(0);
         Stack<Integer> stackl1 = new Stack<>();
         Stack<Integer> stackl2 = new Stack<>();
         while(l1.next !=null){
             stackl1.push(l1.val);
             l1=l1.next;
         }
         stackl1.push(l1.val);
         while(l2.next != null){
             stackl2.push(l2.val);
             l2 = l2.next;
         }
         stackl2.push(l2.val);
         int count1 =0;
         int count2 =0;
        while(!stackl1.isEmpty()){
            count1 += Math.pow(10,stackl1.size()-1)*stackl1.pop();
        }
         while(!stackl2.isEmpty()){
             count2 += Math.pow(10,stackl2.size()-1)*stackl2.pop();
         }

         int count =( count1+ count2);
         ListNode l = new ListNode(count%10);
         count/=10;
         Res.next = l;
         while(count!=0){
             l.next = new ListNode(count%10);
             count/=10;
             l = l.next;
         }
         return Res.next;
 }
}/*
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
*/