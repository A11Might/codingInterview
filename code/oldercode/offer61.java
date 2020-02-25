package oldercode;

import java.util.Arrays;

/**
 * [61] 扑克牌中的顺子
 * 
 * 题目：判断给定数组中的数字是否是连续(0可以当做任何数字)
 * 
 * 思路：1、数组排序后判断0的个数是否等于其他相邻数字之间的空缺总数 
 *      2、满足除零外a、无重复元素
 *                  b、最大值与最小值之差小于5
 */
public class Solution {
    public boolean isContinuous1(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        // sort array and count zero's number
        Arrays.sort(numbers);
        int numOfZero = 0, numOfGap = 0;
        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            numOfZero++;
        }
        // because array is in order, zero's number is the first not zero element's index
        // count the gap's number, if have two element is same, directly return false
        int small = numOfZero, big = small + 1;
        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) {
                return false;
            }
            // two adjacent element's gap, minus one what adjacent numbers all have
            numOfGap += numbers[big++] - numbers[small++] - 1;
        }

        // when gap's number is smaller or equal with zero's number, true
        return (numOfGap > numOfZero) ? false : true;
    }

    public boolean isContinuous2(int [] numbers) {
        if (numbers.length != 5) {
            return false;
        }
        // use max and min to store array's maximum and minimum except zero
        // use bitFlag to mark element in binary system
        int max = -1, min = 14;
        int bitFlag = 0;
        // traverse array
        // if number is zero, skip
        // if number isn't zero, search it had store or not, when not to store now and upate maximum and minimum
        // if maximum minus minimum is bigger or equal with five, the numbers can't succession
        for (int num : numbers) {
            if (num == 0) {
                continue;
            }
            if (((bitFlag >> num) & 1) == 1) {
                return false;
            }
            bitFlag |= (1 << num);
            max = num > max ? num : max;
            min = num < min ? num : min;
            if (max - min >= 5) {
                return false;
            }
        }

        return true;
    }
}
