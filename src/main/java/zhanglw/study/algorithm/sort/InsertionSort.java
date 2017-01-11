package zhanglw.study.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * **插入排序**
 * 原理:
 * 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 1. 设序列a[0]...a[n],假设第一个元素已经排好序
 * 2. 将a[i]设为key,将a[i-1],a[i-2],...,a[0]的元素从后到前依次和a[i]做比较，a[i-j]小于a[i]则向后移动一位(即a[i-j-1]=a[i-j])
 * 若大于a[i],则a[i-j+1] = a[i]
 * 3. 对a[0]...a[n]做外循环,a[i]做key,a[i-1]...a[0]做内循环
 * Created by zhanglw on 2016/12/4.
 */
public class InsertionSort {

    private int[] arr = new int[]{100000, -1, 10, 8, 11, 5, 1, 2, 3, 4};

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
//        insertionSort.exec();
        insertionSort.sort_easy(insertionSort.arr);
        System.out.println(JSON.toJSONString(insertionSort.arr));
    }

    public void exec() {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }


    public void sort_easy(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}

