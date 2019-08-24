package offer;

/**
 * [65] 不用加减乘除做加法
 * 
 * 题目：求两个整数之和
 *       (要求在函数体内不得使用+、-、*、/四则运算符号)
 * 
 * 思路：二进制下num1 + num2，
 *          a、不考虑进位每一位相加，num1 ^ num2(0 + 0, 1 + 1 == 0; 0 + 1, 1 + 0 == 1)
 *          b、考虑进位，(num1 & num2) << 1(0 + 0, 0 + 1, 1 + 0 == 0; 1 + 1 == 1; 产生进位在向左移一位) 
 *          c、将前两步结果相加，相加过程重复前两步，直至不产生进位
 */
public class Solution {
    public int Add(int num1,int num2) {
          int sum = 0, carry = 0;
          do {
              sum = num1 ^ num2;
              carry = (num1 & num2) << 1;
              num1 = sum;
              num2 = carry;
          } while (num2 != 0);

          return num1;
    }
}
