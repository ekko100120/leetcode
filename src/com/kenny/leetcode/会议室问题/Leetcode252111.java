package com.kenny.leetcode.会议室问题;

import java.util.*;

public class Leetcode252111 {


    public static void main(String[] args) {
        int[] nums = {1,3,4,5,6,9,0};
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i]);
        }
    }

//    public boolean check(int[][] nums){
//        List<MeetingTime> meetingTimeList = new ArrayList<>();
//
//        Collections.sort(meetingTimeList,(o1,o2 )->{
//            o1.start - o2.start
//        });
//    }



    static  class MeetingTime{
        public int start;
        public int end;

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }
}
