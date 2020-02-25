/**
 * [66] 构建乘积数组
 *
 * 题目: 给定一个数组 A[0, 1, ..., n-1], 请构建一个数组 B[0, 1, ..., n - 1], 其中 B 中的元素 B[i] = A[0] × A[1] × ...
 *      × A[i - 1] × A[i + 1] × ... × A[n - 1]. 不能使用除法.
 *
 * 思路: B[i] = (A[0] * A[1] * ... * A[i - 1]) * (A[i + 1] * ... * A[n - 1]) = C[i] * 1 * D[i]
 *
 *      B[0] =       1   * A[1] * A[2] * ... * A[n - 2] * A[n - 1]
 *      B[1] =      A[0] *   1  * A[2] * ... * A[n - 2] * A[n - 1]
 *                                 ...
 *      B[n - 2] =  A[0] * A[1] * A[2] * ... *  1       * A[n - 1]
 *      B[n - 1] =  A[0] * A[1] * A[2] * ... * A[n - 2] *   1
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        int len = a.length;
        // ret array is B.
        int[] ret = new int[len];
        // first, from 0 to len - 1 put C into B.
        // C[0] = 1.
        ret[0] = 1;
        for (int i = 1; i < len; i++) {
            // use previous value to speed up calculate current value process.
            ret[i] = ret[i - 1] * a[i - 1];
        }
        // second, from len - 1 to 0 multiply D into B.
        // D[len - 1] = 1.
        int product = 1;
        for (int i = len - 2; i >= 0; i--) {
            // use previous value to speed up calculate current value process.
            // B[i] = C[i] * D[i]
            product *= a[i + 1];
            ret[i] *= product;
        }

        return ret;
    }

}
