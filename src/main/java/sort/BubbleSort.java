package sort;

import java.util.Arrays;

/**
 * @author fangjie
 * @Description: 冒泡排序:依次比较前后两个元素，如果前者大于后者，则进行交换
 * 稳定
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * @date 2019/9/4 9:36
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] sortData = Common.prepareData();
        System.out.println("before sort :" + Arrays.toString(sortData));
        //注意i的范围为length-1,因为内部进行与后面元素做比较
        for (int i = 0; i < sortData.length - 1; i++) {
            //每轮比较，会将最大元素交换到最后，所以j的范围为：0到length-i-1
            for (int j = 0; j < sortData.length - 1 - i; j++) {
                if (sortData[j] > sortData[j + 1]) {
                    int temp = sortData[j];
                    sortData[j] = sortData[j + 1];
                    sortData[j + 1] = temp;
                }
            }
        }
        System.out.println("after sort :" + Arrays.toString(sortData));
    }

}
