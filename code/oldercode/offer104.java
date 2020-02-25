package oldercode;

/**
 * [10] 矩形覆盖
 * 
 * 题目：可以用2*1的小矩形横着或者竖着去覆盖更大的矩形，问用n个2*1的
 *       小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
 * 
 * 思路：第一块小矩形竖着放，则其余未覆盖为f(n - 1)
 *      第一块小矩形横着放，左下角还需横放一个小矩形，则其余未覆盖为f(n - 2)
 *      即f(n) = f(n - 1) + f(n - 2)，实际上是斐波那切数列
 */     
public class Solution {
    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int pre = 1, succ = 2;
        for (int i = 2; i < target; i++) {
            // move one step by one step
            succ = pre + succ;
            pre = succ - pre;
        }

        return succ;
    }
}
