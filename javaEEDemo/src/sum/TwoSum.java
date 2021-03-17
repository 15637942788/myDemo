package sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 吕顺祥
 * @version: 1.0
 * @date: 2021/3/17
 * @describe:
 */
public class TwoSum {
    public static void main(String[] args) {
        //给定
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 13;
        //因为 num[0] + num[1] = 2 + 7 = 9 返回 [0, 1]
        int[] ints = twoSum01(nums, target);
        int[] ints1 = twoSum02(nums, target);
        for (int i = 0; i < ints1.length; i++) {
            System.out.println(ints1[i]);
        }


    }

    //方法二：K值 V下标
    private static int[] twoSum02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int partnerNumber = target - nums[i];
            if (map.containsKey(partnerNumber)) {
                return new int[]{map.get(partnerNumber), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    //方法一：双重for循环
    private static int[] twoSum01(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
