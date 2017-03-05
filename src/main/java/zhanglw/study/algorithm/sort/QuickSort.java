package zhanglw.study.algorithm.sort;

import com.alibaba.fastjson.JSON;
import zhanglw.study.algorithm.util.ArrayUtils;

/**
 * Created by zhanglw on 2017/3/2.
 * QuickSort
 */
public class QuickSort {

    private void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int x = a[low];
            int i = low;
            int j = high;
            while (i < j) {
                while (i < j && a[j] >= x) j--; // i< j 作为单次排序的结束条件,  从后向前,排除a[j]大于x的值,直到小于x为之
                if (i < j) {
                    a[i++] = a[j];  // 在i<j的情况下,将此时的a[i]的值变成此时的a[j](即小于x的值)的值
                    System.out.println("i=" + i + ",j=" + j + ":" + JSON.toJSONString(a));
                }
                while (i < j && a[i] < x) i++; // 从前到后查找比x大值, 由于上一步中a[j]必然小于x,上一步在赋值时直接采用a[i++] i值加1,而i++值等于i
                if (i < j) {
                    a[j--] = a[i];
                    System.out.println("i=" + i + ",j=" + j + ":" + JSON.toJSONString(a));
                }
                System.out.println("i=" + i + ",j=" + j);
            }

            a[j] = x;
            System.out.println(JSON.toJSONString(a));
            quickSort(a, low, j - 1);
            quickSort(a, j + 1, high);
        }

        System.out.println("--------");

    }

    public static void main(String[] args) {
        int[] a = ArrayUtils.initIntegerArray(10, 2, 100);
        System.out.println(JSON.toJSONString(a));
        System.out.println("\n");
        new QuickSort().quickSort(a, 0, a.length - 1);
        System.out.println("\n");
        System.out.println(JSON.toJSONString(a));
    }
}
