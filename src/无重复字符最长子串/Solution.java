package 无重复字符最长子串;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 * 
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution {
    /**
     * 我们不妨以示例一中的字符串 abcabcbb 为例，找出从每一个字符开始的，不包含重复字符的最长子串，那么其中最长的那个字符串即为答案。对于示例一中的字符串，我们列举出这些结果，其中括号中表示选中的字符以及最长的字符串：
     *
     * 以 (a)bcabcbb 开始的最长字符串为 (abc)abcbb
     * 以 a(b)cabcbb 开始的最长字符串为 a(bca)bcbb
     * 以 ab(c)abcbb 开始的最长字符串为 ab(cab)cbb
     * 以 abc(a)bcbb 开始的最长字符串为 abc(abc)bb
     * 以 abca(b)cbb 开始的最长字符串为 abca(bc)bb
     * 以 abcab(c)bb 开始的最长字符串为 abcab(cb)b
     * 以 abcabc(b)b 开始的最长字符串为 abcabc(b)b
     * 以 abcabcb(b) 开始的最长字符串为 abcabcb(b)
     *
     */
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<Character>();

        int index = 0;
        int intAnswer = 0;

        for (int i = 0;i <= s.length() - 1;i++){

            if (charSet.size() != 0){
                charSet.remove(s.charAt(i-1));
            }

            //指针向右移动，直到发现重复的字符
            while (index <= s.length() - 1 && !charSet.contains(s.charAt(index))){
                charSet.add(s.charAt(index));
                index++;

            }

            //上方while发现重复字符后，记录下该段无重复字符的 子串数量。
            // 和之前发现的数量进行对比取最大，遍历完成后就是最大无重复字串数量
            intAnswer = Math.max(intAnswer ,index - i);

        }

        return intAnswer;

    }

}
