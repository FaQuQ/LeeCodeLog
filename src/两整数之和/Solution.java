package 两整数之和;

//https://leetcode-cn.com/problems/sum-of-two-integers/

public class Solution {
        public static int getSum(int a, int b) {
            while (b != 0) {
                int carry = (a & b) << 1;
                a = a ^ b;
                b = carry;
            }
            return a;
        }


    public static void main(String[] args) {
        System.out.println(getSum(2,3));
    }

}
