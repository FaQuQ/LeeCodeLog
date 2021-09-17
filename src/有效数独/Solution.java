package 有效数独;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/
 * 36. 有效的数独
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 */

public class Solution {

    public boolean isValidSudoku(char[][] board) {

        /**
         * 使用哈希表
         * 记录行、列、9宫格中，数字1-9是否出现过，所以使用boolean类型
         */
        boolean[][] rows = new boolean[10][10];
        boolean[][] cols = new boolean[10][10];
        boolean[][][] box = new boolean[3][3][10];

        //遍历board中每个元素
        for (int i = 0;i < 9;i++){
            for (int j = 0;j < 9;j++){

                if (board[i][j] == '.'){
                    continue;
                }

                //char转换为int
                int num = board[i][j] - '0';

                //如果为true则表示该数字在 行、列、九宫格中重复出现
                if (rows[i][num] || cols[j][num] || box[i/3][j/3][num]){
                    return false;
                }

                //true标记为该数字已出现
                rows[i][num] = cols[j][num] = box[i/3][j/3][num] = true;
            }
        }

        return true;

    }

}
