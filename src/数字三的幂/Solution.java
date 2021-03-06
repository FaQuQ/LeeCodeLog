package 数字三的幂;

/**
 * @ClassName Solution
 * //326. 3的幂
 * //        给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * //
 * //        整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * //https://leetcode-cn.com/problems/power-of-three/
 **/
public class Solution {
    /***
     * 倍数 & 约数
     * 题目要求不能使用循环或递归来做，而传参 n 的数据类型为 int，这引导我们首先分析出 int 范围内的最大 3 次幂是多少，约为 3^{19} = 11622614673
     * 19
     *  =1162261467。
     *
     * 如果 n 为 3 的幂的话，那么必然满足 n * 3^k = 1162261467，即 n 与 1162261467 存在倍数关系。
     *
     * 因此，我们只需要判断 n 是否为 1162261467 的约数即可。
     *
     * 注意：这并不是快速判断 x 的幂的通用做法，当且仅当 x为质数可用。
     *
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/power-of-three/solution/gong-shui-san-xie-yi-ti-san-jie-shu-xue-8oiip/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public static boolean isPowerOfThree(int n) {

        return n > 0 && 1162261467 % n == 0;

    }
}
