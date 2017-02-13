package zhanglw.study.algorithm.sort;

import com.alibaba.fastjson.JSON;
import zhanglw.study.algorithm.util.ArrayUtils;

import static zhanglw.study.algorithm.util.ArrayUtils.swap;

/**
 * Created by zhanglianwei on 2017/2/13.
 */
public class SelectionSort {

    public static void sort(int[] arr) {
        // 外层循环
        for (int i = 0; i < arr.length - 1; i++) {
            // 最小值索引
            int minIndex = i;
            // 内层循环,从i+1开始到arr.length-1 ,0到i已经排序好了
            for (int j = i + 1; j < arr.length; j++) {
                // 依次和minIndex 对应的值比较,如果小于最小值,则minIndex改变为j,依次不停找到最小值
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(arr, i, minIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[] initArr = ArrayUtils.initIntegerArray(5, 4, 98);
        System.out.println(JSON.toJSONString(initArr));
        sort(initArr);
        System.out.println(JSON.toJSONString(initArr));
    }

}
