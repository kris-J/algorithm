package main.java;

import java.util.Arrays;

/**
 * @author fangjie
 * @Description: 选择排序:从中找到最小的数值，加入已排序数组(当前数组的前列)的末尾
 * 不稳定
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * @date 2019/9/4 9:57
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] sortData = Common.prepareData();
        System.out.println("before sort :" + Arrays.toString(sortData));
        int minIndex;
        for (int i = 0; i < sortData.length - 1; i++) {
            minIndex = i;
            //查找最小元素的索引
            for (int j = i + 1; j < sortData.length; j++) {
                if (sortData[j] < sortData[minIndex]) {
                    minIndex = j;
                }
            }
            //进行交换
            int temp = sortData[i];
            sortData[i] = sortData[minIndex];
            sortData[minIndex] = temp;
        }
        System.out.println("after sort :" + Arrays.toString(sortData));
    }
}
