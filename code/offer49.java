/**
 * [49] 丑数
 * 
 * 题目: 把只包含因子 2, 3 和 5 的数称作丑数(Ugly Number). 返回按从小到大的顺序的第 n 个丑数.
 *      (1 是第一个丑数)
 * 
 * 思路: 丑数的质因子只有 2, 3 和 5, 所以每个丑数都是由另一个较小的丑数乘以 2, 3 和 5 所得, 所以从小到大按顺序存储乘积所得丑数即可.
 *      如下:  1 是第一个丑数
 *           (2 * 1)    3 * 1     5 * 1
 *            2 * 2    (3 * 1)    5 * 1
 *           (2 * 2)    3 * 2     5 * 1
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int nthUglyNumber(int n) {
        if (n < 7) {
            return n;
        }
        int[] res = new int[n];
        // first ugly number.
        res[0] = 1;
        // use three variable 'two', 'three' and 'five',
        // respective represent current minimum haven't use ugly number,
        // which will product 2, product 3 and product 5 for gain new ugly number.
        int two = 0, three = 0, five = 0;
        for (int i = 1; i < n; i++) {
            // storage the minimum number in current gained new ugly numbers.
            res[i] = Math.min(Math.min(res[two] * 2, res[three] * 3), res[five] * 5);
            // move current used ugly number's variable to point the next ugly number.
            if (res[i] == res[two] * 2) {
                two++;
            }
            if (res[i] == res[three] * 3) {
                three++;
            }
            if (res[i] == res[five] * 5) {
                five++;
            }
        }

        return res[n - 1];
    }
}
