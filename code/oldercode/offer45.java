package oldercode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * [45] 把数组排成最小的数
 * 
 * 题目：把给定数组里所有数字拼接起来排成一个数，返回最小值
 * 
 * 思路：按排序规则(若a + b < b + a, a排在在前)排序给定数组
 */
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : numbers) {
            list.add(num);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                // use string to compare
                // in case out of integer's range
                String str1 = o1 + "" + o2;
                String str2 = o2 + "" + o1;
                return str1.compareTo(str2);
            }
        });

        // joint ordered number
        String res = "";
        for (Integer num : list) {
            System.out.println(num);
            res += num;
        }
        return res;
    }
}
