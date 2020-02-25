import java.util.Arrays;

/**
 * [17] 打印从 1 到最大的 n 位数
 *
 * 题目: 输入数字 n, 按顺序打印出从 1 到最大的 n 位十进制数. 比如输入 3, 则打印出 1, 2, 3 一直到最大的 3 位数即 999.
 *
 * 思路: 1. 先求出最大的 n 位数, 再从 1 开始逐个打印.
 *
 *      若最大的 n 位数使用整数和长整数都会溢出, 可以使用 char 数组进行储存.
 *      2. 模拟整数的加法: 初始化字符数组表示 0, 然后每次将字符数组表示的数字加一.
 *      3. 全排列: 把数字的每一位都从 0 到 9 排列一遍, 就得到了所有的十进制数.
 */
class Solution {
    /**
     * 时间复杂度: O(m) (m 为最大的 n 位数)
     * 空间复杂度: O(1)
     */
    public int[] printNumbers1(int n) {
        int len = 0;
        while (n-- > 0) {
            len = len * 10 + 9;
        }
        int[] ret = new int[len];
        for (int i = 1; i <= len; i++) {
            ret[i - 1] = i;
        }

        return ret;
    }

    /**
     * 时间复杂度: O(m) (m 为最大的 n 位数)
     * 空间复杂度: O(n)
     */
    public void print1ToMaxOfNDigits2(int n) {
        if (n < 0) {
            return;
        }
        // initialize number to 0.
        char[] number = new char[n];
        Arrays.fill(number, '0');

        // plus one to the number every time,
        // if number isn't overflow, print this number.
        while (!isOverflowAfterIncrement(number)) {
            printNumber(number);
        }
    }

    private boolean isOverflowAfterIncrement(char[] number) {
        int len = number.length;
        boolean isOverflow = false;
        int carry = 0;
        for (int i = len - 1; i >= 0; i--) {
            int curSum = number[i] - '0' + carry;
            // plus one.
            if (i == len - 1) {
                curSum++;
            }
            if (curSum >= 10) {
                // the highest position carry one,
                // means current number is the biggest value of n position.
                if (i == 0) {
                    isOverflow = true;
                } else {
                    carry = curSum / 10;
                    curSum = curSum % 10;
                    number[i] = (char) ('0' + curSum);
                }
            } else {
                // if haven't carry,
                // means current number finish plus one.
                number[i] = (char) ('0' + curSum);
                break;
            }
        }

        return isOverflow;
    }

    // print number
    private void printNumber(char[] number) {
        int len = number.length;
        int index = 0;
        // skip 0 which in the front.
        while (index < len && number[index] == '0') {
            index++;
        }
        while (index < len) {
            System.out.print(number[index++]);
        }
        System.out.println();
    }

    /**
     * 时间复杂度: O(m) (m 为最大的 n 位数)
     * 空间复杂度: O(n)
     */
    public void print1ToMaxOfNDigits3(int n) {
        if (n < 0) {
            return;
        }
        process(n, new char[n], 0);
    }

    private void process(int n, char[] number, int index) {
        if (index == n) {
            printNumber(number);
            return;
        }
        // every position will put char from 0 to 9.
        for (int i = 0; i <= 9; i++) {
            number[index] = (char) ('0' + i);
            process(n, number, index + 1);
        }
    }
}