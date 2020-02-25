/**
 * [56-II] 数组中数字出现的次数 II
 *
 * 题目: 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * 思路: 将数组中所有数字的二进制表示的每一位都加起来. 若某一位的和能被 3 整除, 那么那个只出现一次的数字二进制表示中对应的那一位是 0;
 *      否则就是 1.
 *      例如: 1110
 *           1110
 *           1110
 *           1101
 *           ----
 *           4431 每位都 % 3 = 1101
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int singleNumber(int[] nums) {
        int ret = 0;
        // int number has 32 position in binary system.
        for (int i = 0; i < 32; i++) {
            // count the number of ones in each position.
            int cnt = 0;
            for (int num : nums) {
                num >>>= i;
                if ((num & 1) == 1) {
                    cnt++;
                }
            }
            // use cnt to restore the number that appears only once.
            if (cnt % 3 != 0) {
                ret += (1 << i);
            }
        }

        return ret;
    }
}