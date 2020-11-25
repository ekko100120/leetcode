package com.kenny.leetcode;

public class LeetCode4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int  n = length1+length2;
        int[] nums = new int[n];
        int i =0, j=0;
        int index =0;
        while(i<length1 &&j<length2){
            if(nums1[i]<nums2[j]){
                nums[index++] = nums1[i++];
            }else{
                nums[index++] = nums2[j++];
            }
        }
        while(i<length1){
            nums[index++] = nums1[i++];
        }
        while(j<length2){
            nums[index++] = nums2[j++];
        }
        int k = n%2;
        int z = n/2;
        if( k == 0){
            return (nums[z]+nums[z-1])/2;
        }else{
            return nums[z];
        }

    }

    public static void main(String[] args) {
        LeetCode4 code = new LeetCode4();
        int[] nums1 ={1,2};
        int[] nums2 = {3,4};
        double result =  code.findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }
}
