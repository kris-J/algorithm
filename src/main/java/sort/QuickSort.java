package sort;

import java.util.Arrays;

/**
 * @author fangjie
 * @Description: 快速排序,选择基准元素，将小于该元素的值都放到左侧，大于该元素的值放到右侧
 *
 * 1.结尾元素作为基准点，则先从左向右找第一个大于基准数的值，进行交换，再从右向左找第一个小于基准数的值，进行交换
 * 2.头部元素作为基准点，则先从右向左找第一个小于基准数的值，进行交换，再从左向右找第一个大于基准数的值，进行交换
 * @date 2020/3/5 14:20
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] sortData = Common.prepareData();
        System.out.println(Arrays.toString(sortData));
        sort(sortData, 0, sortData.length - 1);
        System.out.println(Arrays.toString(sortData));
    }

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int index = partition(arr, left, right);
            //左侧迭代
            sort(arr, left, index - 1);
            //右侧迭代
            sort(arr, index + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {

//        //第一个元素作为基准
//        int flag = arr[left];
//        while (left < right){
//            //从右向左找到第一个比flag小的数字
//            while(left < right && arr[right] >= flag){
//                right--;
//            }
//
//            //交换位置
//            swap(arr,left,right);
//
//            //从左向右找到第一个比flag大的数字
//            while(left < right && arr[left] <= flag){
//                left++;
//            }
//            //交换位置
//            swap(arr,left,right);
//        }
//        return left;
        //最后元素作为基准
        int flag = arr[right];
        while (left < right){


            //从左向右找到第一个比flag大的数字
            while(left < right && arr[left] <= flag){
                left++;
            }
            //交换位置
            swap(arr,left,right);

            //从右向左找到第一个比flag小的数字
            while(left < right && arr[right] >= flag){
                right--;
            }

            //交换位置
            swap(arr,left,right);

        }
        return left;

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
