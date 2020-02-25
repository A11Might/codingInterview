package oldercode;

/**
 * [3] 数组中重复的数字
 * 
 * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内，数组中某些数字是重复的，找出数组中任意一个重复的数字
 *       (不知道有几个数字是重复的。也不知道每个数字重复几次)
 * 
 * 思路：1、使用数组注册已遍历过的数字，当遍历的数字出现过，则找到重复数字
 *       2、遍历数组，将数字按大小归位(数字大小为索引)，若同一个位子上出现两个数字，则找到重复数字
 */
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0) {
            return false; 
        }
        // use array to store number appear times
        int[] times = new int[length];
        // traverse array
        // if current number had appeared, find the duplication
        for (int num : numbers) {
            if (times[num] != 0) {
                duplication[0] = num;
                return true;
            }
            // use array times mark number had appeared
            times[num]++;
        }

        // none of duplication
        return false;
    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0) {
            return false; 
        }
        // traverse array
        for (int i = 0; i < length; i++) {
            // if current number isn't in it's right position
            // judge right position is duplication of its or not
            // if not swap its and right position element
            // and continue judge swap element is in right position
            while (i != numbers[i]) {
                if (numbers[numbers[i]] == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                } else {
                    swap(numbers, i, numbers[i]);
                }
            }
        }

        // none of duplication
        return false;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}
