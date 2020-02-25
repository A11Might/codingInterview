/**
 * [44] 数字序列中某一位的数字
 *
 * 题目: 数字以 0123456789101112131415... 的格式序列化到一个字符序列中. 在这个序列中, 第 5 位(从下标 0 开始计数)是 5, 第 13 位是 1,
 *      第 19 位是 4, 等等. 返回任意第 n 位对应的数字.
 *
 * 思路: 找规律.
 */
class Solution {
    /**
     * 时间复杂度: O()
     * 空间复杂度: O()
     */
    public int findNthDigit(int n) {
        if (n < 0) {
            return -1;
        }
        // place represent digit's position numbers.
        int place = 1;
        while (true) {
            int numbers = countNumbers(place) * place;
            if (n < numbers) {
                return getDigitAtN(n, place);
            }
            n -= numbers;
            place++;
        }
    }

    // get 'place' positions digit form string's length.
    // 10, 90, 900, ...
    private int countNumbers(int place) {
        if (place == 1) {
            return 10;
        }

        return (int) Math.pow(10, place - 1) * 9;
    }

    // find nth number in 'place' position digit form string.
    private int getDigitAtN(int n, int place) {
        int beginNum = getBeginNum(place);
        int offset = n / place;
        String number = beginNum + offset + "";
        int position = n % place;

        return number.charAt(position) - '0';
    }

    // get 'place' positions digit's first digit.
    // 0, 10, 100
    private int getBeginNum(int place) {
        if (place == 1) {
            return 0;
        }

        return (int) Math.pow(10, place - 1);
    }
}