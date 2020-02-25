import java.util.ArrayList;
import java.util.List;

/**
 * [62] 圆圈中最后剩下的数字
 * 
 * 题目: 约瑟夫环问题, 0, 1, ..., n-1 这 n 个数字排成一个圆圈, 从数字 0 开始, 每次从这个圆圈里删除第 m 个数字.
 *      返回圆圈中剩余的最后一个数字.
 *
 * 思路: 1. 用链表模拟整个过程.
 *      2. 约瑟夫环递推公式: f(n, m) = (f(n - 1, m) + m) % n.
 */
class Solution {
    /**
     * 时间复杂度: O(m * n)
     * 空间复杂度: O(n)
     */
    public int lastRemaining1(int n, int m) {
        // structure the cycle from 0 to n - 1.
        List<Integer> circle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            circle.add(i);
        }
        // from 0 index to start this game.
        int cur = 0;
        while (circle.size() > 1) {
            // cur is the element's index which should be delete(not its value).
            cur = (cur + (m - 1)) % circle.size();
            circle.remove(cur);
        }

        return circle.get(0);
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int lastRemaining2(int n, int m) {
        // base case: f(1) = 0.
        int res = 0;
        for (int i = 2; i <= n; i++) {
            // equation:  f(i) = (f(i - 1) + m) % i.
            res = (res + m) % i;
        }

        return res;
    }
}