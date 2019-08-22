package offer;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * [57] 和为s的数字
 * 
 * 题目：在递增排序数组中查找和为两个数，若有多对数字的和等于S，输出两个数的乘积最小的
 *      (两个数小的先输出)
 * 
 * 思路：1、双重循环遍历，用set省去内层循环
 *      2、由于是递增排序数组，使用头尾双指针
 *        （和相同的两个数，相差越大乘积越大，所以第一次得到两个数的即为答案）
 */     
public class Solution {
    // use set to find number pair
    public ArrayList<Integer> FindNumbersWithSum1(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int product = Integer.MAX_VALUE;
        for (int num : array) {
            int target = sum - num;
            // find current number's partner which can add be sum
            if (set.contains(target)) {
                // if have multy pairs, return pair which product is max
                if (target * num < product) {
                    res.clear();
                    res.add(target);
                    res.add(num);
                }
            }
            // use set to mark visited number
            set.add(num);
        }

        return res;
    }

    // use two point to find number pair
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length < 2) {
            return res;
        }
        // because of array is sorted use head and tail point
        int left = 0, right = array.length - 1;
        while (left < right) {
            // when head point add tail point equal sum
            // find the number pair 
            int curSum = array[left] + array[right];
            if (curSum == sum) {
                res.add(array[left]);
                res.add(array[right]);
                break;
            // when head point add tail point bigger sum
            // move tail point for decrease curren sum
            } else if (curSum > sum) {
                right--;
            // when head point add tail point smaller sum
            // move head point for increase curren sum
            } else {
                left++;
            }
        }

        return res;
    }
}
