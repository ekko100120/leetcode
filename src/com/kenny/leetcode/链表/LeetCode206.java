package com.kenny.leetcode.链表;

public class LeetCode206 {

    //翻转链表
    //反转一个单链表。
    //普通方法
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode pre = null;
        ListNode next = null;
        while (head !=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head =next;
        }
        return pre;

    }

    //递归
    public ListNode reverseList1(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode newListNode = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return newListNode;
    }


    public ListNode reverseList2(ListNode head) {

        if (head ==null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur !=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

}
