package offer;

/**
 * [64] 求1 + 2 + ... + n
 * 
 * 题目：求1+2+3+...+n
 *      (要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句A?B:C)
 * 
 * 思路：不能使用乘除，就是用加减，不能使用迭代就用递归，不能用判断，就用逻辑与
 *          a.需利用逻辑与的短路特性实现递归终止
 *          b.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0
 *          c.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)
 */
public class Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        // use logic and to stop recursion when n equal 0
        boolean flag = (n > 0) && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }
}
