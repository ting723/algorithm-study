package zhanglw.study.algorithm.util;

import com.alibaba.fastjson.JSON;

import java.util.Random;

/**
 * Created by zhanglw on 2017/1/5.
 */
public class ArrayUtils {

    /**
     * @param maxLength 数组最大长度
     * @param maxValue  数组内最大值
     * @param minValue  数组内最小值
     * @return
     */
    public static int[] initIntegerArray(int maxLength, int minValue, int maxValue) {
        int[] arr = new int[maxLength];
        Random random = new Random();
        for (int i = 0; i < maxLength; i++) {
            arr[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }
        return arr;
    }

    /**
     * 默认产生1000个数
     *
     * @param minValue 最小值
     * @param maxValue 最大值
     * @return
     */
    public static int[] initIntegerArray(int minValue, int maxValue) {
        return initIntegerArray(1000, minValue, maxValue);
    }

    /**
     * 产生0,100的整数
     *
     * @return
     */
    public static int[] initIntegerArray() {
        return initIntegerArray(100, 0, 100);
    }

    public static void main(String[] args) {
        int[] arrs = initIntegerArray(8, 5, 53);
        System.out.println(JSON.toJSONString(arrs));
    }



    public static void swap(int[] arrs, int j, int i) {
        int temp = arrs[j];
        arrs[j] = arrs[i];
        arrs[i] = temp;
    }
}
