package main.java;

import java.util.Arrays;

/**
 * @author fangjie
 * @Description: 插入排序，在未排序元素中，逐一与已排序元素进行比较，找到自己的位置进行插入
 * 稳定
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * @date 2019/9/4 10:14
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] sortData = Common.prepareData();
        System.out.println("before sort :" + Arrays.toString(sortData));
        for (int i = 1; i < sortData.length; i++) {
            int j;
            //待比较元素
            int currentEle = sortData[i];
            //当前元素与前面已排序好的元素逐一比较,如果前面的大，则向后移动
            for (j = i - 1; j >= 0; j--) {
                if (sortData[j] > currentEle) {
                    sortData[j + 1] = sortData[j];
                } else {
                    break;
                }
            }
            //上面for循环后，j进行了--运算，第一轮会变成-1
            sortData[j + 1] = currentEle;
        }
        System.out.println("after sort :" + Arrays.toString(sortData));
    }
}
