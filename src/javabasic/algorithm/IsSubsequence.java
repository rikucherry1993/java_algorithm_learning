package javabasic.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * collection of LeetCode questions
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 */
public class IsSubsequence {

    public static void main(String[] args){
        boolean result = IsSubsequence.isSubsequence(s_392, t_392);
        System.out.println("执行结果是：" + result);
        System.out.println("期待结果是：true");
    }

    /*#392 Validate subsequence*/
    public static final String s_392 = "l";
    public static final String t_392 = "leeeeeeeeetoodeee";

    /**
     * my solution
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     */
    public static boolean isSubsequence(String s, String t) {

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        List<Character> lt = new ArrayList<Character>();
        for (char c : ct) {
            lt.add(c);
        }

        int prevIdx = -1;

        for (char c : cs) {
            int curIdx = lt.indexOf(c);
            while (curIdx <= prevIdx && lt.contains(c)) {
                lt.set(curIdx, null);
                curIdx = lt.indexOf(c);
            }
            if (curIdx > prevIdx) {prevIdx = curIdx;}
            else return false;
        }
        return true;
    }

}
