package offer;

/**
 * [66] 构建乘积数组
 * 
 * 题目：给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
 *      (不能使用除法)
 * 
 * 思路：B[i] = (A[0] * A[1] * ... * A[i - 1]) * (A[i + 1] * ... * A[n - 1]) = C[i] * 1 * D[i]
 * 
 *      B[0] =       1   * A[1] * A[2] * ... * A[n - 2] * A[n - 1]
 *      B[1] =      A[0] *   1  * A[2] * ... * A[n - 2] * A[n - 1]
 *                                 ...
 *      B[n - 2] =  A[0] * A[1] * A[2] * ... *  1       * A[n - 1]
 *      B[n - 1] =  A[0] * A[1] * A[2] * ... * A[n - 2] *   1
 */
public class Solution {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        // res array is B
        int n = A.length;
        int[] res = new int[n];
        // first, from 0 to n - 1 put C into B
        res[0] = 1; // C[0]
        for (int i = 1; i < n; i++) {
            // use previous value to speed up calculate current value process
            res[i] = res[i - 1] * A[i - 1];
        }
        // second, from n - 1 to 0 multiply D into B
        int temp = 1; // D[n - 1]
        for (int i = n - 2; i >= 0; i--) {
            // use previous value to speed up calculate current value process
            temp *= A[i + 1];
            // B[i] = C[i] * D[i]
            res[i] *= temp;
        }

        return res;
    }

}
