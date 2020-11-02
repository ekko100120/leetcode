package com.kenny.leetcode.排序算法;

public class 归并排序 {

    //归并排序
    /*核心思想: 若要对 nums[lo..hi] 进行排序，我们先对 nums[lo..mid] 排序，再对 nums[mid+1..hi] 排序，
     最后把这两个有序的子数组合并，整个数组就排好序了。*/

    public void sort(int[] nums){
        int start =0;
        int end = nums.length-1;
        mergeSort(nums,start,end);
    }

    public void mergeSort(int[] nums, int start, int end){
        if (start >= end){
            return;
        }

        int pivotal = start+(end-start)/2;
        mergeSort(nums,start,pivotal);
        mergeSort(nums,pivotal+1,end);
        merge(nums,start,pivotal,end);
    }

    private void   merge(int[] nums, int start, int pivotal, int end) {

        int[] tmp = new int[nums.length];
        int right = pivotal+1;
        int index = start;
        int left = start;
        while (left<=pivotal && right<=end){
            if (nums[left]<=nums[right]){
                tmp[index++] = nums[left++];
            }else {
                tmp[index++] = nums[right++];
            }
        }
        while (right<=end){
            tmp[index++] = nums[right++];
        }
        while (left<=pivotal){
            tmp[index++] = nums[left++];
        }
        while (start<=end){
            nums[start] = tmp[start++];
        }

    }

    //默写
    // 核心思想将两个数组分叉成两个数组，然后是两个数组内部有序，最后将两个内部有序的数组合并成一个有序的数组；

    public void mergeSort1(int[] nums, int start, int end){
        if (start>=end){
            return;
        }
        int pivotal = start+(end-start)/2;
        mergeSort1(nums,start,pivotal);
        mergeSort1(nums,pivotal,end);
        merge1(nums,start,pivotal,end);


    }

    private void merge1(int[] nums, int start, int pivotal, int end) {

        int[] tmp = new int[nums.length];
        int left = start;
        int right = pivotal+1;
        int index = start;
        while (left<=pivotal&& right<= end){
            if (nums[left]<= nums[right]){
                tmp[index++] = nums[left++];
            }else {
                tmp[index++] = nums[right++];
            }
        }
        while (left<=pivotal){
            tmp[index++] = nums[left++];
        }
        while (right<= end){
            tmp[index++] = nums[right++];
        }
        while (start<=end){
            nums[start] = tmp[start++];
        }


    }


}
