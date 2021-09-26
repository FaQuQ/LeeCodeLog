package 两个字符串删除操作;


/***
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 *  
 *
 * 示例：
 *
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /***
     * 给定两个字符串
     *  ，分别删除若干字符之后使得两个字符串相同，则剩下的字符为两个字符串的公共子序列。为了使删除操作的次数最少，剩下的字符应尽可能多。
     *  当剩下的字符为两个字符串的最长公共子序列时，删除操作的次数最少。
     *  因此，可以计算两个字符串的最长公共子序列的长度，然后分别计算两个字符串的长度和最长公共子序列的长度之差，
     *  即为两个字符串分别需要删除的字符数，两个字符串各自需要删除的字符数之和即为最少的删除操作的总次数。
     *
     * ​
     *   最长公共子序列的长度，记为lcs，则最少删除操作次数为m−lcs+n−lcs。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings/solution/liang-ge-zi-fu-chuan-de-shan-chu-cao-zuo-14uw/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public static int minDistance(String word1, String word2) {

        int m = word1.length();int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 1;i <= m;i++){
            char mChar = word1.charAt(i-1);
            for (int j = 1;j <= n;j++){
                char nChar = word2.charAt(j-1);

                if (mChar == nChar){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }

        }

        int lns = dp[m][n];

        return m-lns+n-lns;

    }

    public static void main(String[] args) {
        System.out.println(minDistance("3224","1223"));
    }

}
