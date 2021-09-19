package 只有两个键的键盘;

/***
 * 650. 只有两个键的键盘
 * 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
 *
 * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
 * Paste（粘贴）：粘贴 上一次 复制的字符。
 * 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：3
 * 输出：3
 * 解释：
 * 最初, 只有一个字符 'A'。
 * 第 1 步, 使用 Copy All 操作。
 * 第 2 步, 使用 Paste 操作来获得 'AA'。
 * 第 3 步, 使用 Paste 操作来获得 'AAA'。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= n <= 1000
 */

public class Solution {

    /***
     * 数学
     * 如果我们将「11 次 Copy All + xx 次 Paste」看做一次“动作”的话。
     *
     * 那么 一次“动作”所产生的效果就是将原来的字符串变为原来的 x + 1x+1 倍。
     *
     * 最终的最小操作次数方案可以等价以下操作流程：
     *
     * 起始对长度为 11 的记事本字符进行 11 次 Copy All + k_1 - 1k
     * 1
     * ​
     *  −1 次 Paste 操作（消耗次数为 k_1k
     * 1
     * ​
     *  ，得到长度为 k_1k
     * 1
     * ​
     *   的记事本长度）；
     * 对长度为为 k_1k
     * 1
     * ​
     *   的记事本字符进行 11 次 Copy All + k_2 - 1k
     * 2
     * ​
     *  −1 次 Paste 操作（消耗次数为 k_1 + k_2k
     * 1
     * ​
     *  +k
     * 2
     * ​
     *  ，得到长度为 k_1 * k_2k
     * 1
     * ​
     *  ∗k
     * 2
     * ​
     *   的记事本长度）
     * ...
     * 最终经过 kk 次“动作”之后，得到长度为 nn 的记事本长度，即有：
     *
     * n = k_1 * k_2 * ... * k_x
     * n=k
     * 1
     * ​
     *  ∗k
     * 2
     * ​
     *  ∗...∗k
     * x
     * ​
     *
     *
     * 问题转化为：如何对 nn 进行拆分，可以使得 k_1 + k_2 + ... + k_xk
     * 1
     * ​
     *  +k
     * 2
     * ​
     *  +...+k
     * x
     * ​
     *   最小。
     *
     * 对于任意一个 k_ik
     * i
     * ​
     *  （合数）而言，根据定理 a * b >= a + ba∗b>=a+b 可知进一步的拆分必然不会导致结果变差。
     *
     * 因此，我们只需要使用「试除法」对 nn 执行分解质因数操作，累加所有的操作次数，即可得到答案。
     *
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/2-keys-keyboard/solution/gong-shui-san-xie-yi-ti-san-jie-dong-tai-f035/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int minSteps(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                ans += i;
                n /= i;
            }
        }
        if (n != 1) ans += n;
        return ans;
    }


    /***
     * 普通解法：
     * 遍历判断每次复制是否符合条件（整除）
     * 符合条件则复制粘贴，不符合则粘贴之前的复制
     */
    public static int minSteps1(int n) {

        //已存在 3 AA
        int param = 1;
        //剪切板
        int copyTab = 0;
        int i = 0;
        if(n == 1){
            return 0;
        }
        while(n > 0){
            i++;

            if ((n-param) % param == 0){
                copyTab = param;
                System.out.println("第"+i+"步，使用Copy All");
                i++;
                param += copyTab;
                n = n - param;
                System.out.println("第"+i+"步，使用Paste");
            }
            else
            {
                param += copyTab;
                n = n - copyTab;
                System.out.println("第"+i+"步，使用Paste");
            }



        }


        return i;

    }



}
