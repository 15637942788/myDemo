package sort;

import java.util.Arrays;

/**
 * @author: 吕顺祥
 * @version: 1.0
 * @date: 2021/4/5
 * @describe: 快排：其实就是那一个标准值，比我大的放右边，比我小的放左边，循环到
 * 1. 定义一个标准值，一般以第一个为标准值
 * 2. 用开始值arr[i]与标准值比较，比标准值小，i++
 * 3. 用结束值arr[j]与标准值比较，比标准值大，j++
 * 4. 如果arr[i] == arr[j]，i++
 * 5. 不等：也就是说 arr[i] > 标准值 同时，arr[j] < 标准值 则 交换值
 * 6. 此时得到的是标准值左边都比标准值小，标准值右边都比标准值大
 * 7. *** 将数组根据标准值分为左边和右边，继续调用自己，直到 i - 1 < 0 （说明此时左边已经到尽头了），j + 1 > 数组的长度 - 1（说明右边已经到尽头了）
 * 8. 返回排好序的数组
 */
public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {432, 1, 2, 2, 2, 3, 4, 34, 23, 532, 54, 34654, 4575};
        int len = arr.length - 1;
        quickSort(arr, 0, len);
        System.out.println(Arrays.toString(arr));
    }

    //这里先调用一次排序，将数组根据i（也就是pivot对应的正确下标）将数组分为两个数组，左边比pivot小，右边比pivot大
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int i = doQuickSort(arr, start, end);
            quickSort(arr, start, i - 1);
            quickSort(arr, i + 1, end);
        }
    }

    /**
     *  这个方法是填坑法，就是将 arr[start] 作为 pivot ，start 索引对应的位置可以空出来，用来填充比pivot大的数
     *  注意：如果pivot是从数组左边开始，那么循环需要从数组右边开始，原因是这样可以保证最先找到不符合条件的值一定小于pivot
     * @param arr 数组
     * @param start 开始索引
     * @param end 结束索引
     * @return pivot 正确的位置索引
     */
    public static int doQuickSort(int[] arr, int start, int end) {
        int pivot = arr[start];
        while (start < end) {
            while (arr[end] >= pivot && start < end) {
                end--;
            }
            arr[start] = arr[end];
            while (arr[start] <= pivot && start < end) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = pivot;
        return start;
    }
}
