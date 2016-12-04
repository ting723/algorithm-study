package zhanglw.study.algorithm.sort.shell;

import com.alibaba.fastjson.JSON;

/**
 * Created by zhanglw on 2016/12/4.
 */
public class ShellSort {

    private int[] arr = new int[]{3, 1, 8, 2, 3, 63, 18, 34, 23, 78, 89, 10};

    public void exec() {
        int gap = 1, i, j, len = arr.length;
        int temp;
        // gap
        while (gap < len / 3) {
            gap = gap * 3 + 1;
        }
        for (; gap > 0; gap /= 3) {
            for (i = gap; i < len; i++) {
                temp = arr[i];
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        shellSort.exec();
        System.out.println(JSON.toJSONString(shellSort.arr));
    }
}
