package offer;

/**
 * [3] 不修改数组找到重复的数字
 * 
 * 题目：长度为n + 1的数组里的所有数字都在1-n的范围里，所以数组中至少有一个数字是重复的，找出任意一个重复的数字
 *      (不能修改输入数组)
 * 
 * 思路：类二分查找，将数组分为含*一定*包含重复元素部分和*不一定*包含重复元素部分
 */
public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0) {
            return false; 
        }
        // start equal 1 and end equal n
        int start = 1, end = length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int count = countRange(numbers, start, mid);
            // when start equal end, judge start(end) is the duplication or not
            if (start == end) {
                if (count > 1) {
                    duplication[0] = start;
                    return true;
                } else {
                    break;
                }
            }
            // duplication is in left part
            if (count > (mid - start + 1)) {
                end = mid;
            // duplication is in right part
            } else {
                start = mid + 1;
            }
        }

        // haven't duplication
        return false;
    }
    
    // count how much number value is between [start, end] in array numbers
    private int countRange(int[] numbers, int start, int end) {
        int count = 0;
        for (int num : numbers) {
            if (start <= num && num <= end) {
                count++;
            }
        }

        return count;
    }
}
