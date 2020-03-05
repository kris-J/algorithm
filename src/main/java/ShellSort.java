package main.java;

import java.util.Arrays;

/**
 * @author fangjie
 * @Description: 希尔排序, 插入排序的升级版，在待排序数组上进行分组，每组进行插入排序
 * 不稳定
 * 时间复杂度：O(n^(1.3~2))
 * 空间复杂度：O(1)
 * @date 2019/9/5 13:46
 */
public class ShellSort {

    public static void main(String[] args) {
        /**
         * {10, 16, 1, 20, 19, 14, 50, 12, 15}进行排序，以长度一半作为增量
         * 1.step=4:   10与19比较，16与14比较(交换)，1与50比较，20与12比较(交换)，19与15比较(交换)-->{10, 14, 1, 12, 15, 16, 50, 20, 19}
         * 2.step=2:   10与1比较(交换)，14与12比较(交换)，10与15比较，14与16比较，15与50比较，16与20比较，50与19比较(交换)-->{1, 12, 10, 14, 15, 16, 19, 20, 50}
         * 3.step=1:   1与12比较，12与10比较(交换)，12与14比较.......-->{1, 10, 12, 14, 15, 16, 19, 20, 50}
         */
        int[] sortData = Common.prepareData();
        System.out.println("before sort :" + Arrays.toString(sortData));
        int length = sortData.length;
        //分组，开始的增量(step)为长度的一半
        for (int step = length / 2; step > 0; step /= 2) {
            //对各个分组进行插入排序
            System.out.println("step=" + step);
            for (int i = step; i < length; i++) {
                int j;
                int currentEle = sortData[i];
                for (j = i - step; j >= 0; j -= step) {
                    System.out.println("compare " + sortData[j] + " with " + currentEle);
                    if (sortData[j] > currentEle) {
                        sortData[j + step] = sortData[j];
                    } else {
                        break;
                    }
                }
                sortData[j + step] = currentEle;
                System.out.println("step sort result:" + Arrays.toString(sortData));
            }
        }

        System.out.println("after sort :" + Arrays.toString(sortData));
    }
}
