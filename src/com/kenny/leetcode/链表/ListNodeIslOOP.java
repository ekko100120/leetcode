package com.kenny.leetcode.链表;

public class ListNodeIslOOP {

    //判断链表是否成环

    public boolean hasCycle(ListNode head) {

        if (head ==null || head.next == null){
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != slow){
            if (fast ==null ||fast.next ==null){
                return false;
            }
            fast = fast.next.next;
            slow= slow.next;
        }
        return true;
    }

}
