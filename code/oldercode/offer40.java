package oldercode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * [40] 最小的k个数
 * 
 * 题目：找出数组中最小的K个数
 * 
 * 思路：1、利用快排的partition函数，同39.数组中出现次数超过一半的数字 
 *      2、遍历数组，使用大小为k的堆，维护到目前为止最小的k个数
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        if (input == null || input.length == 0 || input.length < k || k == 0) {
            return new ArrayList<>();
        }
        // find kth element between start and end
        int start = 0, end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k - 1) {
            if (index < k - 1) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(input, start, end);
        }

        // collect all k elements
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= index; i++) {
            res.add(input[i]);
        }
        return res;
    }

    // divide target range array to smaller a random value part and other
    private int partition(int[] arr, int start, int end) {
        // random selecte one value of target range array as divide value
        swap(arr, start + (int) Math.random() * (end - start + 1), end);
        int smaller = start - 1;
        while (start < end) {
            if (arr[start] < arr[end]) {
                swap(arr, ++smaller, start++);
            } else {
                start++;
            }
        }
        // move end element to right position
        swap(arr, ++smaller, end);
        return smaller;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        if (input == null || input.length == 0 || input.length < k || k == 0) {
            return new ArrayList<>();
        }
        // make a big root heap size of k
        // traverse input 
        // when heap is full and heap's top is bigger than current element
        // use current element replace heap's top
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>(new MyComparator());
        for (int num : input) {
            if (bigHeap.size() < k) {
                bigHeap.add(num);
            } else {
                if (num < bigHeap.peek()) {
                    bigHeap.poll();
                    bigHeap.add(num);
                }
            }
        }

        // collect all k elements
        ArrayList<Integer> res = new ArrayList<>();
        while (!bigHeap.isEmpty()) {
            res.add(bigHeap.poll());
        }
        return res;
    }

    // big root heap comparator
    class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }

    }
}
