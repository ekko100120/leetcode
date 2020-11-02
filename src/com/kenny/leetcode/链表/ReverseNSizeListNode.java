package com.kenny.leetcode.链表;

public class ReverseNSizeListNode {


//    public ListNode reverseKGroup1(ListNode head, int k){
//        ListNode dummy = new ListNode(-1);
//        dummy.next =head;
//        ListNode supervisor = dummy;
//        int length =0;
//        ListNode cur = supervisor.next;
//        while (length++ < k && cur!=null){
//
//        }
//
//    }
    public ListNode reverseLopK(ListNode head, ListNode end){
        ListNode dummy = new ListNode(-1);
        dummy.next =head;
        ListNode supervisor = dummy;
        int length =0;
        ListNode cur = supervisor.next;
        ListNode pre =null, next=null;
        while (cur!=end){
            next = cur.next;
            cur.next =pre;
            pre = cur;
            cur=next;
        }
        supervisor.next.next =cur;
        supervisor.next=pre;
        return supervisor.next;
    }

    //-------------------------------------------------------------
   public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return null;
        }

        ListNode a,b;
        a=b=head;
        for (int i = 0; i <k ; i++) {
            if (b==null){
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a,b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }

    public ListNode reverse(ListNode a, ListNode b){
        ListNode pre, cur, next;
        pre= null;
        cur = a;
        next=null;
        while (cur != b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur =next;
        }
        return pre;
    }
    //-------------------------------------------------------------

    public ListNode reverseKGroup1(ListNode head, int k) {


        ListNode tmp = head;
        for (int i = 1; i < k && tmp!=null ; i++) {
            tmp = tmp.next;
        }
        if (tmp ==null){
            return head;
        }
        ListNode t2 =  tmp.next;
        tmp.next =null;
        ListNode newHead = reverseNode(head);
        ListNode newTemp = reverseKGroup1(t2,k);
        head.next = newTemp;
        return newHead;












//        ListNode tmp = head;
//        for (int i = 1; i <k && tmp != null ; i++) {
//            tmp = tmp.next;
//        }
//        if (tmp == null){
//            return head;
//        }
//        ListNode t2 = tmp.next;
//        tmp.next = null;
//        ListNode newHead = reverseNode(head);
//        ListNode newTmp = reverseKGroup1(t2,k);
//        head.next = newTmp;
//        return newHead;

    }


    private ListNode reverseNode(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode result = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}
