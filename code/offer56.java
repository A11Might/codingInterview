/**
 * [56-I] 数组中数字出现的次数
 * 
 * 题目: 给定一个整型数组 nums, 其中除两个数字之外, 其他数字都出现了两次. 返回这两个只出现一次的数字.
 *      (要求时间复杂度是 O(n), 空间复杂度是 O(1))
 * 
 * 思路: a. 对所有数字求异或, 相同的数字会抵消, 最后剩下两个只出现 1 次的数字的异或和 xor.
 *      b. 找到 xor 中为 1 的位, 该位置 n 为两数不同的地方.
 *      c. 使用位置 n, 将数组分为 n 位置等于 0 和等于 1 的两组, 同时两个不一样的数字也分别在两组.
 *      d. 分别求两组所有数的异或和, 最终结果即为两个只出现一次的数.
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        // calculate the Exclusive OR of two numbers that appears only once.
        for (int num : nums) {
            xor ^= num;
        }
        // use below way to find the last 1's position in xor.
        xor = (xor & (xor - 1)) ^ xor;
        // use last different position split array to two parts,
        // one is equal with this position and the other is not.
        // then respective calculate two parts' sum of Exclusive OR,
        // the finally result is answer.
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((xor & num) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[] {num1, num2};
    }
}