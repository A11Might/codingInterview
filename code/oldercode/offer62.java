package oldercode;

import java.util.ArrayList;

/**
 * [62] 圆圈中最后剩下的数字
 * 
 * 题目：约瑟夫环问题， 
 *       [0, n - 1]n个数字排成一圈，从0开始，每次删除第m个数字，求剩下的最后一个数字
 * 
 * 思路：1、用链表模拟整个过程 
 *       2、状态转移方程，f(n) = (f(n - 1) + m) % n if n > 1 
 *                            = 0 if n = 1 (只有一个数，剩下的数字就是0)
 */
public class Solution {
    public static int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        // structure the cycle from 0 to n - 1
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // from 0 to start the game
        // k is the position which should be delete not index(potition equal index plus one(very important)) 
        int k = 0;
        while (list.size() > 1) {
            // k is actually should be delete element's position 
            // if k equal with 0, imply current position is list last potition
            // if k not equal with 0, delete current potition's element and move current position to previous(vip)
            k = (k + m) % (list.size());
            if (k == 0) {
                list.remove(list.size() - 1);
            } else {
                list.remove(--k);
            }
        }

        return list.get(0);
    }

    public int LastRemaining_Solution2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int dp = 0; // f(1)
        for (int i = 2; i <= n; i++) {
            // f(i) = (f(i - 1) + m) % i
            dp = (dp + m) % i;
        }

        return dp;
    }
}
