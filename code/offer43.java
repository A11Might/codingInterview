package offer;

/**
 * [43] 1-n整数中1出现的次数
 * 
 * 题目：求出任意非负整数区间中1出现的次数(从1 到 n 中1出现的次数)
 * 
 * 思路：https://blog.csdn.net/yi_Afly/article/details/52012593讲得很棒
 *      (算每一位出现1的次数，如11个位上算一次，十位上再算一次)
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) {
            return 0;
        }
        // calculate every position's 1 take palace times lowest to highest position
        // weight is one position number from lowest to highest
        // rount is current weight's prepart
        // base is current weight's position such as lowest is 1, higher is 10
        // count is current 1 take place times
        int rount = n, weight = 0, base = 1, count = 0;
        while (rount > 0) {
            // current position's number
            weight = rount % 10;
            // current position's prepart
            rount /= 10;
            // when weight equal 1, weight's prepart has rount conditions and weight's succpart has base conditions
            // so when weight equal 1 will have rount * base conditions at last
            count += rount * base;
            // above count had include (0 - rount0base) all conditions what weight's position equal 1
            // like 245, above just count 0 to 200, hundred position's take place 1 conditions, 200 to 245 hasn't count
            // when weight equal 1, can continue count succpart + 1 times
            // when weight bigger than 1 , can continue count base times
            // when weight equal 0, continue count
            if (weight == 1) {
                count += (n % base) + 1;
            } else if (weight > 1) {
                count += base;
            }
            // move to higher position
            base *= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.NumberOf1Between1AndN_Solution(15);
    }
}
