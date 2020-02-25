package oldercode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * [41] 数据流中的中位数
 * 
 * 题目：求一个数据流中的中位数
 * 
 * 思路：使用大根堆和小根堆分别存储中位数左边的数和右边的数
 */
public class Solution {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
        
    });
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }

    });

    public void Insert(Integer num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        if (num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        // after insert new element, judge should modify or not
        modifyTwoHeapSize();
    }

    public Double GetMedian() {
        int sizeMax = maxHeap.size();
        int sizeMin = minHeap.size();
        // two heaps are empty
        if (sizeMax + sizeMin == 0) {
            return null;
        }
        // two heaps's size is even
        if (((sizeMax + sizeMin) & 1) == 0) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
        // two heaps's size is uneven
        return (double) (sizeMax > sizeMin ? maxHeap.peek() : minHeap.peek());
    }

    // when two heaps's size difference bigger than one, modify them
    private void modifyTwoHeapSize() {
        if (maxHeap.size() == (minHeap.size() + 2)) {
            minHeap.add(maxHeap.poll());
        }
        if ((maxHeap.size() + 2) == minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
}
