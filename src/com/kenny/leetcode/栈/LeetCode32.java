package com.kenny.leetcode.栈;

import java.util.Stack;

public class LeetCode32 {

    //给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
    //https://zhuanlan.zhihu.com/p/93959688
    //https://zhuanlan.zhihu.com/p/93959688
    public int longestValidParentheses(String s) {

        if (s ==null ||s.isEmpty()){
            return 0;
        }

        //必须为0
        int max = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i <s.length() ; i++) {

            if ('(' == s.charAt(i)){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.empty()){
                    stack.push(i);
                }else {

                    max = Math.max(max, i- stack.peek());
                }

            }

        }
        return  max;
    }
}
