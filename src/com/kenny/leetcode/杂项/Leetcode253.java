package com.kenny.leetcode.杂项;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode253 {


    public static void main(String[] args) {
        int[][] nums = {
                {1,4},
                {1,2},
                {3,5},
                {2,4}}
                ;

        int result = Leetcode253.minMeetingRooms(nums);
        System.out.println(result);


    }
    //http://www.noteanddata.com/leetcode-253-Meeting-Rooms-II-java-solution-note.html
    public static int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] interval: intervals) {
            int count = map.getOrDefault(interval[0], 0);
            map.put(interval[0], count+1);
            count = map.getOrDefault(interval[1], 0);
            map.put(interval[1], count-1);
        }
        int maxcount = 0;
        int count = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            count += entry.getValue();
            maxcount = Math.max(maxcount, count);
            System.out.println(count);
            System.out.println(maxcount);
            System.out.println("=============================");
        }
        return maxcount;
    }

    //最少会议室数量
    public static int getMin(int[][] nums){
        int[] starts = new int[nums.length];
        int[] ends = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            starts[i] = nums[i][0];
            ends[i] = nums[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int count =0;
        for (int i = 0,j=0; i < starts.length ; i++) {

            if (starts[i]< ends[j]){
                count++;
            }else {
                j++;
            }
        }
        return count;

    }


}
