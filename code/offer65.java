/**
 * [65] 不用加减乘除做加法
 * 
 * 题目: 求两个整数之和, 要求在函数体内不得使用 "+", "-", "*", "/" 四则运算符号.
 * 
 * 思路: 二进制下计算 num1 + num2, 得到 sum 和 carry:
 *      a. sum = num1 ^ num2 表示没有考虑进位的情况下两数的和,
 *         例如: 0 ^ 0, 1 ^ 1 == 0;
 *              0 ^ 1, 1 ^ 0 == 1.
 *      b. carry = (num1 & num2) << 1 表示两数和的所有进位,
 *         例如: 0 & 0, 0 & 1, 1 & 0 == 0 后 0 << 1 == 0;
 *              1 & 1 == 1 后 1 << 1 == 10.
 *      c. 然后将 sum 和 carry 再使用相同的方法相加, 重复abc步骤直至没有进位(carry == 0), 则 sum 即为两数之和.
 */
class Solution {
    /**
     * 时间复杂度: O()
     * 空间复杂度: O()
     */
    public int add(int a, int b) {
        int sum = 0 ,carry = 0;
        // constant calculate the sum of 'sum' and 'carry',
        // until carry is equal zero.
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        } while (carry != 0);

        return sum;
    }
}