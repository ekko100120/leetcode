package com.kenny.leetcode.排序算法;

public class 快速排序 {

    //快速排序


    /*快速排序的逻辑是，若要对 nums[lo..hi] 进行排序，
    我们先找一个分界点 p，通过交换元素使得 nums[lo..p-1] 都小于等于 nums[p]，且 nums[p+1..hi] 都大于 nums[p]，
    然后递归地去 nums[lo..p-1] 和 nums[p+1..hi] 中寻找新的分界点，最后整个数组就被排序了。*/


//    原理：
//    选择一个关键值作为基准值。比基准值小的都在左边序列（一般是无序的），比基准值大的都在右边（一般是无序的）。
//    然后对这两部分分别重复这个过程，直到整个有序。
//
//    算法思想：
//    基于分治的思想，是冒泡排序的改进型。首先在数组中选择一个基准点（该基准点的选取可能影响快速排序的效率，后面讲解选取的方法），
//    然后分别从数组的两端扫描数组，设两个指示标志（lo指向起始位置，hi指向末尾)，首先从后半部分开始，如果发现有元素比该基准点的值小，
//    就交换lo和hi位置的值，然后从前半部分开始扫秒，发现有元素大于基准点的值，就交换lo和hi位置的值，
//    如此往复循环，直到lo>=hi,然后把基准点的值放到hi这个位置。一次排序就完成了。以后采用递归的方式分别对前半部分和后半部分排序，
//    当前半部分和后半部分均有序时该数组就自然有序了。


    public static void quickSort(int[] arr){
        int start = 0;
        int end = arr.length-1;
        sort(arr,start,end);
    }

    public static void sort(int[] arr, int start, int end){
        if (start>=end){
            return ;
        }
        int partition = partition(arr,start,end);
        sort(arr,start, partition-1);
        sort(arr,partition+1, end);

    }


    public static int partition(int[] arr, int start, int end){
        int base = arr[end];
        while (start< end){
            while (start<end && arr[start]<=base){
                start++;
            }
            if (start<end){
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] =tmp;
                end--;
            }
            while (start<end && arr[end]>= base){
                end--;
            }
            if (start<end){
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] =tmp;
                start++;
            }

        }
        return end;
    }



    //默写

    public static void quickSort(int[] nums, int start, int end){
        if ( start >= end){
            return;
        }
        int partition = getPartition(nums, start, end);

        quickSort(nums, start,partition-1);
        quickSort(nums,partition+1, end);




    }

    private static int getPartition(int[] nums, int start, int end) {

        int tmp = nums[start];
        while (start<end){

            while (start<end && nums[end] >= tmp){
                end--;
            }
            nums[start] = nums[end];
            while (start<end && nums[start]<= tmp){
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] =tmp;
        return start;

    }

}
