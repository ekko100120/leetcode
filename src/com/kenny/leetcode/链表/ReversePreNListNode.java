package com.kenny.leetcode.链表;

public class ReversePreNListNode{

    //翻转链表的前N个节点
    //非递归
      public ListNode reversePreNListNode(ListNode head, int N) {

          ListNode dummy = new ListNode(-1);
          dummy.next = head;
          ListNode supervisor = dummy;
          ListNode pre = null;
          ListNode next = null;
          ListNode cur = dummy.next;
          for (int i = 1; i <= N ; i++) {
              next = cur.next;
              cur.next = pre;
              pre = cur;
              cur = next;
          }
          supervisor.next.next= cur;
          supervisor.next =pre;
          return dummy.next;
      }

//    public ListNode reversePreNListNode(ListNode head, int N){
//
//        if (head == null || head.next ==null){
//            return  head;
//        }
//        int length =1;
//        ListNode cur = head;
//        ListNode pre = null;
//        ListNode next = null;
//        while (cur.next!=null && length<= N){
//
//            next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur =next;
//            length++;
//
//        }
//        head.next = cur;
//        return pre;
//    }

    ListNode nNext = null;
    public ListNode reversePreNListNode1(ListNode head, int N) {
        if (N == 1){
            nNext = head.next;
            return head;
        }
        ListNode last = reversePreNListNode1(head.next, N-1);
        head.next.next= head;
        head.next = nNext;
        return last;

    }




}
