package com.kenny.leetcode.链表;


public class Leetcode92 {

    //给定里面，翻转从第M 到N个节点
    // https://juejin.im/post/6844903870263459847
    //https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/di-gui-fan-zhuan-lian-biao-de-yi-bu-fen 东哥

    /*Java 1ms，时间空间均90+。 实现思路 ：以1->2->3->4->5, m = 2, n=4 为例:

    定位到要反转部分的头节点 2，head = 2；前驱结点 1，pre = 1；
    当前节点的下一个节点3调整为前驱节点的下一个节点 1->3->2->4->5,
    当前结点仍为2， 前驱结点依然是1，重复上一步操作。。。
            1->4->3->2->5.
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            for(int i = 1; i < m; i++){
                pre = pre.next;
            }
            head = pre.next;
            for(int i = m; i < n; i++){
                ListNode nex = head.next;
                head.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
            }
            return dummy.next;
        }
    }
    m = 1, n = length的时候，这一解法也是为反转链表I提供了另一个解题思路*/


    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode supervisor = dummy;
        for(int i = 1; i < m; i++){
            supervisor = supervisor.next;
        }
        ListNode pre = null;
        ListNode cur = supervisor.next;
        for(int i = m; i <= n; i++){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        supervisor.next.next = cur;
        supervisor.next = pre;
        return dummy.next;
    }


    public ListNode reverseBetween1(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode supervisor = dummy;
        // find the preM node
        for (int i = 1; i <m ; i++) {
            supervisor = supervisor.next;
        }

        ListNode cur = supervisor.next;
        ListNode pre = null;
        for (int i = m; i <= n ; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur =next;
        }

        supervisor.next.next =cur;
        supervisor.next =pre;
        return dummy.next;
    }

        //错误答案
//    public ListNode reverseBetween1(ListNode head, int m, int n) {
//
//        ListNode tmp = head;
//        ListNode preM = head;
//
//
//        for (int i = 1; i < m ; i++) {
//            preM = preM.next;
//        }
//        ListNode cur = preM.next;
//        ListNode pre = null;
//        ListNode next = null;
//        for (int i = m; i <=n ; i++) {
//
//            next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur =next;
//        }
//        preM.next.next = cur;
//        preM.next = pre;
//
//        return head;
//    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
    ListNode successor = null; // 后驱节点
    public ListNode reverseN(ListNode head, int n) {

        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

}
