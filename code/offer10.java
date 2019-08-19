package offer;

/**
 * [10] 斐波那切数列
 * 
 * 题目：输出斐波那契数列的第n项(第0项为0)
 * 
 * 思路：从前往后计算斐波那切数列
 */     
public class Solution {
    public int Fibonacci(int n) {
        int pre = 0, succ = 1;
        if (n == 0) {
            return pre;
        }
        if (n == 1) {
            return succ;
        }
        for (int i = 1; i < n; i++) {
            // move one step by one step
            succ = pre + succ;
            pre = succ - pre;
        }

        return succ;
    }
}
