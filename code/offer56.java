package offer;

/**
 * [56] 数组中数字出现的次数
 * 
 * 题目：给定整型数组中只有两个数字出现1次，其他的数字都出现2次，找出这两个只出现1次的数字
 * 
 * 思路：a、对所有数字异或，一样的数字抵消，最后剩下两个只出现1次的数字异或和xor
 *      b、找到xor中为1的位，该位置n为两数不同的地方
 *      c、使用位置n，将数组分为n位置等于0和等于1的两组，同时两个不一样的数字也分别在两组
 *      d、分别求两组所有数的异或和，即为两个只出现一次的数
 * 
 *      int DiffNum = Xor & (~Xor + 1);//取最低为为 1 的值 
 *      1101 0010 -> 0011    1101 & 0011 = 0001
 *
 *      int didffNum = (xor - 1) ^ xor & xor也可以
 */     
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int resultExclusiveOR = 0;
        // calculate the appear once number's resultExclusiveOR
        for (int num : array) {
            resultExclusiveOR ^= num;
        }
        // use below way to find the last 1 position of resultExclusiveOR
        int lastDiffPos = resultExclusiveOR & (resultExclusiveOR + 1);
        num1[0] = 0;
        num2[0] = 0;
        // use lastDiffPos split array to two pairs
        // one is this position equal and the other is not
        // respective calculate two pairs resultExclusiveOR
        for (int num : array) {
            if ((num & lastDiffPos) == 0) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }
}
