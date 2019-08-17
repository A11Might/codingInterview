package offer;

/**
 * [49] 丑数
 * 
 * 题目：只包含质因子2、3和5的数称作丑数,从小到大的顺序的第N个丑数(1当做是第一个丑数)
 * 
 * 思路：丑数的质因子只有2、3和5，所以每个丑数都是由另一个较小的丑数乘以2、3和5所得
 *      从小到大按顺序存储乘积所得丑数即可，如下1是第一个丑数
 *      (2 * 1)    3 * 1     5 * 1
 *       2 * 2    (3 * 1)    5 * 1
 *      (2 * 2)    3 * 2     5 * 1
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }
        int[] res = new int[index];
        // first know uglynumber
        res[0] = 1;
        // use three variable a, b and c respective
        // represent know uglynumber product 2, product 3 and product 5 
        // for gain new uglynumber
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < index; i++) {
            // store current gain minimum new uglynumber
            res[i] = Math.min(Math.min(res[a] * 2, res[b] * 3), res[c] * 5);
            // when one know uglynumber used for product 2, 3 or 5 gain a new uglynumber
            // move this variable to the next one
            if (res[i] == res[a] * 2) a++;
            if (res[i] == res[b] * 3) b++;
            if (res[i] == res[c] * 5) c++;
        }

        return res[index - 1];
    }
}
