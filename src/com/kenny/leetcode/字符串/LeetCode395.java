package com.kenny.leetcode.字符串;



public class LeetCode395 {

    //    https://my.oschina.net/u/4316503/blog/3244999

    /**
     * 计算最长重复子串长度.
     *
     * @param s 字符串
     * @param k 重复次数
     * @return 长度
     */

    public int longestSubstring(String s, int k) {

        if (s.length()<1 || s.length()<k){
            return 0;
        }
        if (k==1){
            return s.length();
        }
        return getMaxLength(s.toCharArray(), 0, s.length()-1, k);
    }

    /**
     * 计算最长重复子串长度逻辑处理
     *
     * @param chars 字符数组
     * @param k     重复次数
     * @param start 开始位置
     * @param end   结束位置
     * @return 长度
     */
    private int getMaxLength(char[] chars, int start, int end, int k) {
        if ( end-start+1 < k){
            return 0;
        }
        // 计数器，26代表个字母
        int[] count = new int[26];

        //统计字符频率
        for (int i = start; i <= end ; i++) {
            ++count[chars[i]-'a'];
        }

        // 起点、终点夹逼，去掉首位不符合条件的字符串(滑动窗口)
        while (start<=end && count[chars[start] - 'a'] <k){
            start++;
        }
        while (start<=end && count[chars[start]-'a'] <k){
            end--;
        }
        if (end-start+1 <k){
            return 0;
        }
        // 字符串中间存在不符合条件的字符，即以该字符串为界，分割前子串和后字串，进行计算(分治)
        for (int i = start; i <= end ; i++) {

            if (count[chars[i]-'a'] <k){
                return Math.max(getMaxLength(chars,start,i-1,k),getMaxLength(chars,i+1,end,k));
            }
        }
        return  end-start+1;
    }
}
