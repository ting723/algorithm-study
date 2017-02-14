package zhanglw.study.algorithm.sort;

import com.alibaba.fastjson.JSON;
import zhanglw.study.algorithm.util.ArrayUtils;

import static zhanglw.study.algorithm.util.ArrayUtils.swap;

/**
 * Created by zhanglw on 2017/1/5.
 */
public class BubbleSort {

    public static int[] initArray = ArrayUtils.initIntegerArray(10, 0, 100);

    public static int sortCount = 0;

    public static void sort(int[] arrs) {
        if (arrs == null || arrs.length == 0) return;
        // 外循环
        for (int i = 0; i < arrs.length-1; i++) {
            // 内循环
            // 从0到1开始比较,将最大值排到最后
            // 由于每次都会将最大值排到最后,可以在下一次比较时,将已排好的最大值排除,以减少比较次数
            System.out.println(i + ": " + JSON.toJSONString(arrs));
//            for (int j = 1; j < arrs.length - i; j++) {
//                sortCount++;
//                if (arrs[j] < arrs[j - 1]) {
//                    swap(arrs, j, j - 1);
//                }
//            }

            // 第二种方式:内循环
            // 从arrs.length到i开始比较,将最小值排到最前
            // 由于每次都会将最小值排到最后,可以在下一次比较时,将已排好的最小值排除,以减少比较次数
            for (int j = arrs.length-1; j > i; j--) {
                sortCount++;
                if(arrs[j]<arrs[j-1]){
                    swap(arrs,j,j-1);
                }
            }

//            for (int j = 0 ; j < arrs.length-i-1; j++) {
//                if (arrs[j] > arrs[j + 1]) {
//                    swap(arrs, j, j + 1);
//                }
//            }
        }
    }


    public static void main(String[] args) {
        sort(initArray);
        System.out.println(JSON.toJSONString(initArray));
        System.out.println("Recycle count:" + sortCount);
    }
}
