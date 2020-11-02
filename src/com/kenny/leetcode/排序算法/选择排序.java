package com.kenny.leetcode.排序算法;

public class 选择排序 {

    //选择排序

   /* 原理：
    每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕。

    步骤如下：
            1、给定数组：int[] arr={里面n个数据}；
            2、第1趟排序，在待排序数据arr[1]~arr[n]中选出最小的数据，将它与arr[1]交换；
            3、第2趟，在待排序数据arr[2]~arr[n]中选出最小的数据，将它与arr[2]交换；
            4、以此类推，第i趟在待排序数据arr[i]~arr[n]中选出最小的数据，将它与arr[i]交换，直到全部排序完成。*/


   /* 选择排序总结：
            1、N个元素需要排序N-1轮；
            2、第i轮需要比较N-i次；
            3、N个元素排序，需要比较n（n-1）/2次；
            4、选择排序的算法复杂度仍为O（n*n）；
            5、相比于冒泡排序，选择排序的交换次数大大减少，因此速度要快于冒泡排序*/

    public static int[] selectSort(int[] a) {

        int length = a.length;
        //第一层边界时length-1
        for (int i = 0; i < length-1 ; i++) {

            int min= i;
            //第二层边界时length
            for (int j = i+1; j <length ; j++) {
                if (a[min]>a[j]){
                    min = j;
                }
            }
            if (i != min){
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
        return a;
    }
}
