import java.util.ArrayList;
import java.util.List;

/**
 * [57-II] 和为 s 的连续正数序列
 *
 * 题目: 给定一个正整数 target, 输出所有和为 target 的连续正整数序列(至少含有两个数).
 *      (序列内的数字由小到大排列, 不同序列按照首个数字从小到大排列.)
 *
 * 思路: 从最小序列开始寻找, 使用 left 和 right 分别表示当前序列中的最小值和最大值, 因为序列至少需要两个数字, 所以初始化 left 为 1,
 *      right 为 2. 然后不快扩大或减小序列(增加 right 或 增加 left):
 *      a. 当前序列和等于 target 时, 同时增大 left 和 right, 继续查找.
 *         (此时增大 right 或 增大 left 都不可能再次使当前序列和等于 target, 所以同时增大 left 和 right)
 *      b. 当前序列和小于 target 时, 增大 right 来增加序列和.
 *      c. 当前序列和大于 target 时, 增加 left 来减小序列和.
 *      直至 left < (1 + sum) / 2 为止, 因为当 left == (1 + sum) / 2时, right == (1 + sum) / 2 + 1, 此时最小的序列和都大于
 *      target, 所以终止查找.
 *
 */
class Solution {
    /**
     * 时间复杂度: O(n ^ 2)
     * 空间复杂度: O(n ^ 2)
     */
    private List<int[]> ret = new ArrayList<>();

    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 2;
        int sum = left + right;
        int threshold = (target + 1) / 2;
        while (left < threshold) {
            if (sum == target) {
                // when current sequence's sum equal with target,
                // we got one sequence.
                addNum(left, right);
                sum -= left;
                left++;
                right++;
                sum += right;
            } else if (sum < target) {
                // when current sequence's sum is smaller than target,
                // move right pointer to increase sum.
                right++;
                sum += right;
            } else {
                // when current sequence's sum is bigger than target,
                // move right pointer to reduce sum.
                sum -= left;
                left++;
            }
        }

        return ret.toArray(new int[ret.size()][]);
    }

    // add current sequence to result.
    private void addNum(int left, int right) {
        int[] arr = new int[right - left + 1];
        int index = 0;
        for (int i = left; i <= right; i++) {
            arr[index++] = i;
        }
        ret.add(arr);
    }
}