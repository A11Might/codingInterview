import java.util.PriorityQueue;

/**
 * [41] 数据流中的中位数
 * 
 * 题目: 返回一个数据流中的中位数. 如果从数据流中读出奇数个数值, 那么中位数就是所有数值排序之后位于中间的数值. 如果从数据流中读出偶数个数值,
 *      那么中位数就是所有数值排序之后中间两个数的平均值.
 * 
 * 思路: 分别用大根堆和小根堆来存储数据流左半边的数和右半边的数, 并使用数据流读取的元素个数来平衡两个堆中元素的平衡(size 为偶数时插入大根堆;
 *      size 为奇数时插入小根堆). 返回中位数时若从数据流中读出奇数个数值, 则返回大根堆的堆顶; 若从数据流中读出偶数个数值, 则返回两个堆顶的
 *      平均值.
 */
class MedianFinder {

    // 'bigHeap' to storage left half of data flow .
    private PriorityQueue<Integer> bigHeap;
    // 'bigHeap' to storage right half of data flow .
    private PriorityQueue<Integer> smallHeap;
    // 'size' storage current number of read from data flow.
    private int size;

    /** initialize your data structure here. */
    public MedianFinder() {
        bigHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        smallHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        size = 0;
    }

    public void addNum(int num) {
        // should insure balance of two heaps's size when insert element.
        if ((size & 1) == 0) {
            // when current element is the number of even, should add into bigHeap.
            // because of all elements in bigHeap is smaller than smallHeap,
            // but current insert element isn't sure smaller than every element in smallHeap.
            // so first put current insert element into smallHeap,
            // then poll smallHeap top element which is smallest element in smallHeap,
            // and insert into bigHeap.
            smallHeap.add(num);
            bigHeap.add(smallHeap.poll());
        } else {
            // when current element is the number of odd, should add into smallHeap.
            // in the same way.
            bigHeap.add(num);
            smallHeap.add(bigHeap.poll());
        }
        size++;
    }

    public double findMedian() {
        if ((size & 1) == 0) {
            return (bigHeap.peek() + smallHeap.peek()) / 2.0;
        } else {
            return (double) bigHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */