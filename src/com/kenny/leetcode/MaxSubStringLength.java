package com.kenny.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxSubStringLength {


    public int lengthOfLongestSubstring(String s) {
        char[] n = s.toCharArray();
        int length = n.length, ans =0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start =0, end =0; end< length ; end++) {
            char a = n[end];
            if (map.containsKey(a)){
                start = Math.max(map.get(a),start);
            }
            ans = Math.max(ans, end-start+1);
            map.put(n[end], end+1);
        }
        return  ans;


    }
}
