package zhanglw.study.algorithm.sort;

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

    /**
     * 外部构建子序列
     * 内部进行插入排序
     */
    public void execInnerInsertSort() {
        int i, j, k, n = arr.length;

        //构建步长
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (i = 0; i < gap; i++) {

                // 以下为插入排序了
                for (j = i; j < n; j += gap) {
                    int key = arr[j];
                    for (k = j - gap; k >= 0; k -= gap) {
                        if (arr[k] > key) {
                            arr[k + gap] = arr[k];
                        } else {
                            break;
                        }
                    }
                    arr[k + gap] = key;
                }
            }
        }
    }

    public void execOptimizeOne() {
        int j, gap, n = arr.length;
        for (gap = n / 2; gap > 0; gap /= 2) {
            // 从第gap个元素开始
            for (j = gap; j < n; j++) {
                // 插入排序
                if (arr[j] < arr[j - gap]) {
                    // 小于-gap的,则依次向前移动
                    int temp = arr[j];
                    int k = j - gap;
                    while (k >= 0 && arr[k] > temp) {
                        arr[k + gap] = arr[k];
                        k -= gap;
                    }
                    arr[k + gap] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
//        shellSort.exec();
//        shellSort.execInnerInsertSort();
        shellSort.execOptimizeOne();
        System.out.println(JSON.toJSONString(shellSort.arr));
    }
}
