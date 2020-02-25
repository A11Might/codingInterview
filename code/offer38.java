import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * [38] 字符串的排列
 * 
 * 题目: 返回给定字符串中字符的所有排列. 可以以任意顺序返回这个字符串数组, 但里面不能有重复元素.
 *
 * 思路: 减而治之(回溯算法): 先在给定序列中选择一个数字放在当前位置, 再对剩余的数字进行全排列, 即 f(n) = 1 + f(n - 1).
 */
class Solution {
    /**
     * 时间复杂度: O(A _n ^n)
     * 空间复杂度: O(n)
     */
    public String[] permutation(String s) {
        char[] chrs = s.toCharArray();
        List<String> ret = new ArrayList<>();
        process(chrs, ret, 0);
        return ret.toArray(new String[ret.size()]);
    }

    private void process(char[] chrs, List<String> ret, int index) {
        if (index == chrs.length) {
            ret.add(new String(chrs));
        }
        // use set to judge is current char used or not.
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chrs.length; i++) {
            if (set.contains(chrs[i])) {
                continue;
            }
            set.add(chrs[i]);
            swap(chrs, index, i);
            process(chrs, ret, index + 1);
            // backtrack: recover char array after recursion(very important).
            swap(chrs, index, i);
        }
    }

    private void swap(char[] chrs, int a, int b) {
        char temp = chrs[b];
        chrs[b] = chrs[a];
        chrs[a] = temp;
    }
}