package leetcode.solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * # 54. 螺旋矩阵
 * 难度：中等
 *
 * @author zetu
 * @date 2021/4/29
 */
public class SpiralMatrix {

    /**
     * 54. 螺旋矩阵
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * <p>
     * 示例 1：
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * <p>
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     * 1   2   3   4
     * 5   6   7   8
     * 9   10  11  12
     * <p>
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     * <p>
     * 提示：
     * <p>
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/spiral-matrix
     */
    @Test
    public void spiralMatrixTest() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        // [1,2,3,4,8,12,11,10,9,5,6,7]
        System.out.println(spiralOrder(matrix));
    }

    /**
     * 类似于剥洋葱似的解法
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        // 定义4个边界值，左右和上下，当到了边界当时候，就结束
        int left = 0, right = matrix[0].length - 1;
        int top = 0, down = matrix.length - 1;

        while (true) {
            // 横着从左到右
            for (int i = left; i <= right; ++i) {
                arr.add(matrix[top][i]);
            }
            top++;
            if (top > down) {
                break;
            }
            // 竖着从上到下
            for (int i = top; i <= down; ++i) {
                arr.add(matrix[i][right]);
            }
            right--;
            if (left > right) {
                break;
            }
            // 横着从右到左
            for (int i = right; i >= left; --i) {
                arr.add(matrix[down][i]);
            }
            down--;
            if (top > down) {
                break;
            }
            // 竖着从下到上
            for (int i = down; i >= top; --i) {
                arr.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return arr;
    }
}
