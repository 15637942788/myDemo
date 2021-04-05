package sort;

import java.util.Arrays;
import java.util.Date;

/**
 * @author: 吕顺祥
 * @version: 1.0
 * @date: 2021/4/4
 * @describe: 堆排序：主要是通过构建大根堆(升序)或小根堆(降序)，然后不断的取父根的值，得到的有序的一种方式
 * 1.构造大根堆
 * 2.首尾换位置
 * 3.扣除最后一位继续构造大根堆
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 46, 3, 4, 56, 1, 4, 6, 7, 43, 15, 53, 5325, 235, 56346, 64, 234, 235, 325};
        long startTime = new Date().getTime();
        heapsort(arr);
        long endTime = new Date().getTime();
        System.out.println("排序用时：" + (endTime - startTime) + "毫秒");
        System.out.println(Arrays.toString(arr));
    }

    public static void heapsort(int[] arr) {
        //构造大根堆
        heapInsert(arr);
        int size = arr.length;
        while (size > 1) {
            //固定最大值，即首位和末尾换位置
            swap(arr, 0, size - 1);
            size--;
            heapify(arr, 0, size);
        }
    }

    //构造大根堆
    public static void heapInsert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //当前的索引值
            int currentIndex = i;
            //父索引
            int fatherIndex = (currentIndex - 1) / 2;
            //循环：条件当前节点的值大于父节点的值，则交换，并将索引指向父节点
            while (arr[currentIndex] > arr[fatherIndex]) {
                //交换索引对应元素的值
                swap(arr, currentIndex, fatherIndex);
                //当前索引指向父索引
                currentIndex = fatherIndex;
                //重新计算父索引
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }

    //构造剩余的大根堆
    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        while (left < size) {
            int largesIndex;
            if (arr[left] < arr[right] && right < size) {
                largesIndex = right;
            } else {
                largesIndex = left;
            }
            if (arr[index] > arr[largesIndex]) {
                largesIndex = index;
            }
            if (index == largesIndex) {
                break;
            }
            swap(arr, largesIndex, index);
            index = largesIndex;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }

    }

    //交换数组中两个元素的值
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
