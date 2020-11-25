package com.kenny.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode3 {

    //3. 无重复字符的最长子串
    //https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

    //方法1
    public int lengthOfLongestSubstring1(String s) {
        int length = s.length();
        Set<Character> sets = new HashSet<>();
        int i=0, j=0;
        int maxLength =0;
        while(j<=length-1){
            char tmp = s.charAt(j);
            if(sets.contains(tmp)){
                // 循环右移剔除重复元素以及左边的所有元素
                while(sets.contains(tmp)){
                    sets.remove(s.charAt(i));
                    i++;
                }
            }else{
                sets.add(tmp);
                //j++ 应该在maxLength后面
                maxLength =Math.max(maxLength,j-i+1);
                j++;
            }
        }
        return maxLength;

    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }
}
