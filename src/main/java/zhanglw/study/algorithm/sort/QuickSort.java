package zhanglw.study.algorithm.sort;

import com.alibaba.fastjson.JSON;
import zhanglw.study.algorithm.util.ArrayUtils;

/**
 * Created by zhanglw on 2017/3/2.
 */
public class QuickSort {

    public void sort(int[] a, int l, int r) {
        if (l < r) {
            int x = a[l];
            int i = l;
            int j = r;
            while (i < j) {
                while (i < j && a[j] >= x) j--;
                if (i < j) a[i++] = a[j];


                while (i < j && a[i] < x) i++;
                if (i < j) a[j--] = a[i];
            }

            a[i] = x;
            sort(a, l, i - 1);
            sort(a, i + 1, r);
        }

    }

    public static void main(String[] args) {
        int[] a = ArrayUtils.initIntegerArray(10, 2, 100);
        System.out.println(JSON.toJSONString(a));
        new QuickSort().sort(a, 0, a.length - 1);
        System.out.println(JSON.toJSONString(a));
    }
}
