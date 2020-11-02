package com.kenny.leetcode.字符串;

import java.util.*;

public class Leetcode1207 {

    //    1207. 独一无二的出现次数

    public boolean uniqueOccurrences(int[] arr) {

        if (arr.length <2){
            return true;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <arr.length ; i++) {

            if (!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }else {
                map.put(arr[i], map.get(arr[i])+1);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (Integer key: map.keySet()){
            set.add(map.get(key));
        }
        return map.size() == set.size();
    }
}
