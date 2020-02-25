package oldercode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * [38] 字符串的排列
 * 
 * 题目：按字典序打印出该字符串中字符的所有排列(字符串可能有字符重复，只包包含小写字母)
 * 
 * 思路：第一步，求所有可能出现在第一个位置的字符(即把第一个字符和后面的所有的字符交换)
 *      第二步，固定第一个字符，递归求后面所有字符的全排列
 */
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chrs = str.toCharArray();
        permutationCore(chrs, 0, res);
        // make list in dictionary order
        Collections.sort(res);
        return res;
    }

    private void permutationCore(char[] chrs, int index, ArrayList<String> res) {
        // when index equal list's length
        // add complete string to list
        if (index == chrs.length) {
            res.add(String.valueOf(chrs));
            return;
        }
        // use set to judge is this char appeared or not
        // recover char array after recursion(very important)
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chrs.length; i++) {
            if (!set.contains(chrs[i])) {
                set.add(chrs[i]);
                swap(chrs, index, i);
                permutationCore(chrs, index + 1, res);
                swap(chrs, index, i);
            }
        }
    }

    private void swap(char[] chrs, int a, int b) {
        char temp = chrs[b];
        chrs[b] = chrs[a];
        chrs[a] = temp;
    }
}
