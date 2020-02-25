/**
 * [10-IV] 矩形覆盖
 * 
 * 题目: 可以用 2 * 1 的小矩形横着或者竖着去覆盖更大的矩形. 请问用 n 个 2 * 1 的小矩形无重叠地覆盖一个 2 * n 的大矩形, 总共有多少种方法.
 * 
 * 思路: 要覆盖 2 * n 的大矩形, 可以先竖着覆盖一个 2 * 1 的矩形, 再覆盖 2 * (n - 1) 的矩形;
 *      或者可以先横着覆盖两个 2 * 1 的矩形, 再覆盖 2 * (n - 2) 的矩形.
 *      即 f(n) = f(n - 1) + f(n - 2), 实际上就是斐波那切数列.
 */
public class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int RectCover(int target) {
        if (target <= 1) {
            return target;
        }
        int pre = 0, succ = 1;
        for (int i = 2; i <= target; i++) {
            // state transition equation: f(i) = f(i - 1) + f(i - 2).
            int fib = (pre + succ) % (int) (1e9 + 7);
            pre = succ;
            succ = fib;
        }

        return succ;
    }
}
