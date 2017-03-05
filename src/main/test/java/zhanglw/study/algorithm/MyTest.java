package zhanglw.study.algorithm;

import com.alibaba.fastjson.JSON;
import zhanglw.study.algorithm.util.ArrayUtils;

/**
 * Created by zhanglianwei on 2017/3/4.
 * My Test
 */
public class MyTest {

    public static void main(String[] args) {

        int[] a = ArrayUtils.initIntegerArray(10, 2, 100);
        System.out.println(JSON.toJSON(a));
        quickSort(a, 0, a.length - 1);
        System.out.println(JSON.toJSON(a));

    }

    private static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int i = low;
            int j = high;
            int x = arr[low];
            while (i < j) {
                while (i < j && arr[j] >= x) j--;
                if (i < j) arr[i++] = arr[j];

                while (i < j && arr[i] < x) i++;
                if (i < j) arr[j--] = arr[i];
            }
            arr[i] = x;
            quickSort(arr, low, i - 1);
            quickSort(arr, i + 1, high);
        }
    }
}
