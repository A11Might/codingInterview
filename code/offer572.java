package offer;

import java.util.ArrayList;

/**
 * [57] 和为s的连续正数序列
 * 
 * 题目：找出所有和为S的连续正数序列(至少含两个数)
 *      (序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序)
 * 
 * 思路：使用left和right分别表示序列的最小值和最大值，从最小序列开始找，初始化left为1，right为2
 *      序列至少要有两个数字，则一直增加left到(1 + sum) / 2为止
 *      (当left == (1 + sum) / 2时，right == (1 + sum) / 2 + 1，curSum > sum，查找终止)
 *      1、序列和大于sum，从序列中去掉最小值，即增加left
 *      2、序列和小于sum，则增大right，让序列含更多数字
 *      3、序列和等于sum，则则增大right，继续查找(也可增大left)
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // from {1, 2} to find sequence
        // left == (1 + sum) / 2 iteration terminal
        // because of haven't sequence and is sum anymore 
        int left = 1, right = 2;
        int mid = (sum + 1) / 2;
        int curSum = left + right;
        while (left < mid) {
            // when current sequence and is equal sum
            // add sequence to result and continue expand sequence
            if (curSum == sum) {
                addNum(res, left, right);
            // when current sequence and is bigger than sum
            // reduce sequence
            } else if (curSum > sum) {
                curSum -= left;
                left++;
                continue;
            }
            // when current sequence and is smaller than sum
            // also continue expand sequence
            right++;
            curSum += right;
        }

        return res;
    }

    // add current sequence to result
    private void addNum(ArrayList<ArrayList<Integer>> res, int left, int right) {
        ArrayList<Integer> subList = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            subList.add(i);
        }
        res.add(subList);
    }
}
