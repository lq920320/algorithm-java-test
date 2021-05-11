package leetcode.solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * 难度：中等
 *
 * @author zetu
 * @date 2021/5/11
 */
public class SpiralMatrixII {

    /**
     * 59. 螺旋矩阵 II
     * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：[[1]]
     * <p>
     * 提示：
     * 1 <= n <= 20
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
     */
    @Test
    public void spiralMatrix() {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    /**
     * 返回一个 n x n 的二维数组
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];

        int left = 0;
        int right = n - 1;
        int top = 0;
        int buttom = n - 1;
        // 起始值
        int num = 1;
        int numsize = n * n;
        while (num <= numsize) {
            for (int i = left; i <= right; ++i) {
                arr[top][i] = num++;
            }
            top++;
            for (int i = top; i <= buttom; ++i) {
                arr[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; --i) {
                arr[buttom][i] = num++;
            }
            buttom--;
            for (int i = buttom; i >= top; --i) {
                arr[i][left] = num++;
            }
            left++;
        }
        return arr;
    }
}
