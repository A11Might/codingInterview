package oldercode;

/**
 * [51] 数组中的逆序对
 * 
 * 题目：求出给定数组中的逆序对的总数，将其对1000000007取模的结果输出
 * 
 * 思路：类归并排序，在merge的时候，一组一组的获取逆序对数即可
 */
public class Solution {
    public int InversePairs(int [] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int res = InversePairsCore(array, 0, array.length - 1);
        return  res % 1000000007;
    }

    private int InversePairsCore(int[] arr, int lo, int hi) {
        if (lo == hi) {
            return 0;
        }
        int mid = ((hi - lo) >> 1) + lo;
        int leftInversePairs = InversePairsCore(arr, lo, mid) % 1000000007;
        int rightInversePairs = InversePairsCore(arr, mid + 1, hi) % 1000000007;
        return  leftInversePairs + rightInversePairs + merge(arr, lo, mid, hi);
    }

    private int merge(int[] arr, int lo, int mid, int hi) {
        int[] temp = new int[hi - lo + 1];
        int index = 0;
        int count = 0;
        int p1 = lo, p2 = mid + 1;
        while (p1 <= mid && p2 <= hi) {
            // when left part current element p1 is bigger than right one p2
            // because of left part and right part is ordered
            // so all of elements from p1 to mid are bigger than p2
            // got mid - p1 + 1 inversepairs in one time
            // when left part current element p1 isn't bigger than right one p2
            // countn't get inversepairs but should sort left pair and right tegether
            // for after compare in a temp array
            if (arr[p1] > arr[p2]) {
                count += mid - p1 + 1;
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
                temp[index++] = arr[p2++];
            } else {
                temp[index++] = arr[p1++];
            }
        }
        // left or right part haven't finish
        while (p1 <= mid) {
            temp[index++] = arr[p1++];
        }
        while (p2 <= hi) {
            temp[index++] = arr[p2++];
        }
        // copy ordered array to original array
        // because only ordered array can take one group inversepairs
        for (int i = 0; i < temp.length; i++) {
            arr[lo++] = temp[i];
        }

        return count % 1000000007;
    }
}
