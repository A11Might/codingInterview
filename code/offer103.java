/**
 * [10-III] 变态跳台阶
 * 
 * 题目: 一只青蛙一次可以跳上 1 级台阶, 也可以跳上 2 级 ... 它也可以跳上 n 级. 求该青蛙跳上一个 n 级的台阶总共有多少种跳法.
 * 
 * 思路: 动态规划, f(n) 表示 n 个台阶总共有多少种跳法;
 *               状态转移方程: f(n) = f(n - 1) + f(n - 2) + ... + f(0)
 *                                                                             ==> f(n) = 2 * f(n - 1)
 *                           f(n - 1) = f(n - 2) + f(n - 3) + ... + f(0)
 *
 */     
public class Solution {
    public int JumpFloorII(int n) {
        int dp = 1;
        for (int i = 2; i <= n; i++) {
            // state transition equation: f(n) = 2 * f(n - 1).
            dp = 2 * dp;
        }

        return dp;
    }
}
