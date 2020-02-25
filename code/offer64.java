/**
 * [64] 求 1 + 2 + ... + n
 * 
 * 题目: 求 1 + 2 + ... + n, 要求不能使用乘除法, for, while, if, else, switch, case 等关键字及条件判断语句(A ? B : C).
 * 
 * 思路: 不能使用乘除, 就是用加减; 不能使用迭代, 就用递归; 不能使用判断, 就用短路与来结束递归.
 *       a. 需利用短路与的短路特性实现递归终止.
 *       b. 当 n == 0 时, (n > 0) && ((sum += Sum_Solution(n - 1)) > 0)第一个条件为 false, 不会执行后面递归的主体部分, 递归终止.
 *       c. 当 n > 0 时, 执行 sum += Sum_Solution(n - 1), 实现递归计算 Sum_Solution(n).
 */
public class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int Sum_Solution(int n) {
        int sum = n;
        // use short out and to stop recursion when n equal 0.
        boolean flag = (n > 0) && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }
}
