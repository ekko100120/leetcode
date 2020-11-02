package com.kenny.leetcode.链表;

public class LeetCode83 {

    //83. 删除排序链表中的重复元素
    //思路 https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/yuan-di-xiu-gai-shu-zu

    public ListNode deleteDuplicates(ListNode head) {

        if ( head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null){
            if (slow.val != fast.val){
                slow.next =fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next =null;
        return  head;

    }
}
