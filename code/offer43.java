/**
 * [43] 1 ~ n 整数中 1 出现的次数
 * 
 * 题目: 返回 1 ~ n 这 n 个整数的十进制表示中 1 出现的次数.
 *
 * 思路: http://blog.huqihh.com/2019-09-04-Number1times/
 *      (算每一位出现 1 的次数, 如 11 个位上算一次, 十位上再算一次)
 */
class Solution {
    /**
     * 时间复杂度: O(logn)
     * 空间复杂度: O(1)
     */
    public int countDigitOne(int n) {
        // calculate every position's 1 take palace times from lowest to highest position.
        // 'weight' is number on one position.
        // 'pre' is current weight's previous part.
        // 'base' is current weight's position such as lowest is 1, higher is 10.
        // 'cnt' is current 1 take place times
        int pre = n, weight = 0, base = 1, cnt = 0;
        while (pre > 0) {
            weight = pre % 10;
            pre = pre / 10;
            // when weight equal 1,
            // weight's previous part has pre + 1 conditions and weight's succeed part has 'base' conditions.
            // so when weight equal 1 will have pre * base conditions at last,
            // because when previous part equal previous part's maximum value,
            // should according weight to judge have other conditions or not(very important).
            cnt += pre * base;
            // above 'cnt' had include (0 - pre0base) all conditions what weight's position equal 1.
            // like 245, above just count 0 to 200, hundred position's take place 1 conditions, 200 to 245 hasn't count.
            // when weight equal 1, can continue count succeed part + 1 times,
            // when weight bigger than 1 , can continue count base times,
            // when weight equal 0, continue count.
            if (weight == 1) {
                cnt += (n % base) + 1;
            } else if (weight > 1) {
                cnt += base;
            }
            // move to higher position.
            base *= 10;
        }

        return cnt;
    }
}