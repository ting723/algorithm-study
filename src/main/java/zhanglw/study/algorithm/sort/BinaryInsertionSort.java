package zhanglw.study.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * **折半插入查询**
 * 原理:
 *   对插入排序算法的一种改进,采用折半查找法,减少其比较次数
 * 1. 设a[0]...a[n]
 * 2. 设a[i](i>=1) , 取a[i-1]...a[0]中的a[mid]=a[(i-1+0)/2]进行比较,
 *    若a[mid]<a[i], 则取a[(mid+1+i-1)/2]比较
 *    若a[mid]>a[i], 则取a[(mid-1+0)/2]比较
 *    直至low>high, 后a[low]..a[i-1]平移一位
 *    最后将a[low]=key
 * 3. 循环a[1]..a[n]
 * Created by zhanglw on 2016/12/4.
 */
public class BinaryInsertionSort {

    private int[] arr = new int[]{4, 13, 1, 81, 9, 0, -1, 3, 2, 97};

    public void exec() {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int high = i - 1;
            int low = 0;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] < key) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            for (int j = i; j > low; j--) {
                arr[j] = arr[j - 1];
            }

            arr[low] = key;

        }

    }

    public static void main(String[] args) {
        BinaryInsertionSort binaryInsertionSort = new BinaryInsertionSort();
        binaryInsertionSort.exec();
        System.out.println(JSON.toJSONString(binaryInsertionSort.arr));
    }
}
