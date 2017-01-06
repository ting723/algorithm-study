package zhanglw.study.algorithm.sort;

import com.alibaba.fastjson.JSON;
import zhanglw.study.algorithm.util.ArrayUtils;

/**
 * Created by zhanglw on 2017/1/5.
 */
public class BubbleSort {

    public static int[] initArray = ArrayUtils.initIntegerArray(10,0,100);

    public static void sort(int[] arrs) {
        System.out.println(JSON.toJSONString(initArray));
        for (int i = 0; i < initArray.length; i++) {
            for (int j = 1; j < initArray.length-i; j++) {
              if(initArray[j]>initArray[j-1]){
                 int temp = initArray[j-1];
                 initArray[j-1]=initArray[j];
                 initArray[j] = temp;
              }
            }
        }
    }

    public static void main(String[] args) {
        sort(initArray);
        System.out.println(JSON.toJSONString(initArray));
    }
}
