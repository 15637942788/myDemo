package sort;

import java.util.Arrays;

/**
 * @author: 吕顺祥
 * @version: 1.0
 * @date: 2021/4/5
 * @describe: 快排：其实就是那一个标准值，比我大的放右边，比我小的放左边，循环到
*      1. 定义一个标准值，一般以第一个为标准值
 *     2. 用开始值arr[i]与标准值比较，比标准值小，i++
 *     3. 用结束值arr[j]与标准值比较，比标准值大，j++
 *     4. 如果arr[i] == arr[j]，i++
 *     5. 不等：也就是说 arr[i] > 标准值 同时，arr[j] < 标准值 则 交换值
 *     6. 此时得到的是标准值左边都比标准值小，标准值右边都比标准值大
 *     7. *** 将数组根据标准值分为左边和右边，继续调用自己，直到 i - 1 < 0 （说明此时左边已经到尽头了），j + 1 > 数组的长度 - 1（说明右边已经到尽头了）
 *     8. 返回排好序的数组
 */
public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {1, 2,34,546,43,346,3,3,4,56,4};
        int len = arr.length - 1;
        arr = quickSort(arr, 0, len);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] quickSort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && arr[i] < pivot) {
                i++;
            }
            while (i < j && arr[j] > pivot) {
                j--;
            }
            if (arr[i] == arr[j]) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) {
            arr = quickSort(arr, start, i - 1);
        }
        if (j + 1 < end) {
            arr = quickSort(arr, j + 1, end);
        }
        return arr;
    }
}
