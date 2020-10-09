package com.kenny.leetcode;

public class MergeSortedList {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int l = m+n-1;
        int i = m-1;
        int j = n -1;

        while (j>=0){
            nums1[l--] = (i>=0 && nums1[1]>= nums2[j])? nums1[l--] =nums1[i]:nums2[j--];
        }
    }
}
