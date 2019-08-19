package offer;

/**
 * [10] 变态跳台阶
 * 
 * 题目：一次可以上1级台阶，也可以上2级……也可以上n级，求上一个n级的台阶总共有多少种方法
 * 
 * 思路：状态转移方程：f(n) = f(n - 1) + f(n - 2) + ... + f(0)
 *                   f(n - 1) = f(n - 2) + f(n - 3) + ... + f(0)
 *               ==> f(n) = 2 * f(n - 1)
 */     
public class Solution {
    public int JumpFloorII(int n) {
        int dp = 1;
        for (int i = 2; i <= n; i++) {
            dp = 2 * dp;
        }

        return dp;
    }
}
