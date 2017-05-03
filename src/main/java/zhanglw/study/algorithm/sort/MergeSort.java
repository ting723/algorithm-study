package zhanglw.study.algorithm.sort;

/**
 * Created by zhanglianwei on 2017/5/3.
 */
public class MergeSort {
    private static int[] a = {3, 7, 8, 4, 2, 5, 1};

    public static void main(String[] args) {
        sort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void sort(int[] a, int left, int right) {
        // 递归结束条件
        if (left >= right) return;
        // 取得中间值
        int center = (left + right) >> 1;
        // 分治
        sort(a, left, center);
        sort(a, center + 1, right);
        // 合并
        mergeSort(a, left, center, right);
    }

    private static void mergeSort(int[] a, int left, int center, int right) {
        int[] tempArr = new int[right - left + 1];
        int i = left;
        int j = center + 1;
        int k = 0;
        // 将较小的值放入数组
        while (i <= center && j <= right) {
            tempArr[k++] = (a[i] < a[j] ? a[i++] : a[j++]);
        }
        // 将左边的放到数组
        while (i <= center) {
            tempArr[k++] = a[i++];
        }
        // 将右边的放到数组
        while (j <= right) {
            tempArr[k++] = a[j++];
        }
        // 复制的当前数组
        for (int m = 0; left <= right; left++, m++) {
            a[left] = tempArr[m];
        }
    }
}
