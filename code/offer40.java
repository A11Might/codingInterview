import java.util.PriorityQueue;

/**
 * [40] 最小的 k 个数
 * 
 * 题目: 输入整数数组 arr, 找出其中最小的 k 个数.
 * 
 * 思路: 1. 同 39. 数组中出现次数超过一半的数字, 利用快排的 partition 函数:
 *         快速排序的 partition() 方法, 会返回一个整数 j 使得 a[lo ... j - 1] 小于等于 a[j], 且 a[j + 1 ... hi] 大于等于 a[j],
 *         此时 a[j] 就是数组的第 j 大元素. 可以利用这个特性找出数组的第 K 个元素.
 *      2. 遍历数组, 使用大根堆维护到目前为止最小的 k 个数, 最后返回这 k 个元素即可.
 */
class Solution {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int index = partition(arr, lo, hi);
            if (index == k - 1) {
                // find the kth smallest element.
                break;
            } else if (index < k - 1) {
                lo = index + 1;
            } else {
                hi = index - 1;
            }
        }

        // partition function will change the array,
        // let k elements in the front is the smallest k elements.
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }

    // divide target range array to smaller hi value part and other part.
    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int smaller = start - 1;
        while (start < end) {
            if (arr[start] < pivot) {
                swap(arr, start++, ++smaller);
            } else {
                start++;
            }
        }
        swap(arr, end, ++smaller);
        return smaller;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    /**
     * 时间复杂度: O(n * logk)
     * 空间复杂度: O(k)
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>(
                (o1, o2) -> o2 - o1
        );
        for (int num : arr) {
            bigHeap.add(num);
            // keep the size of big root heap is k.
            if (bigHeap.size() > k) {
                bigHeap.poll();
            }
        }

        return bigHeap.stream().mapToInt(Integer::intValue).toArray();
    }
}