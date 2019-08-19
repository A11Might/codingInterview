package offer;

/**
 * [10] 青蛙跳台阶问题
 * 
 * 题目：一次上1级台阶，也上2级,求上n级的台阶共有多少种跳法
 *      (先后次序不同算不同的结果)
 * 
 * 思路：状态转移方程：f(n) = f(n - 1) + f(n - 2)
 *       实际上就是斐波那切数列
 */     
public class Solution {
    public int JumpFloor(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre = 1, succ = 2;
        for (int i = 2; i < n; i++) {
            // move one step by one step
            succ = pre + succ;
            pre = succ - pre;
        }

        return succ;
    }
}
