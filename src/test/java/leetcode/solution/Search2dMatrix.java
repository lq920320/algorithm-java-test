package leetcode.solution;

import org.junit.Test;

/**
 * #74. 搜索二维矩阵
 * 难度：中等
 *
 * @author zetu
 * @date 2021/6/11
 */
public class Search2dMatrix {

    /**
     * 编写一个高效的算法来判断 m*n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * <p>
     * 示例 1：
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * 输出：true
     * <p>
     * 示例 2：
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
     * 输出：false
     * <p>
     * 提示：
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 100
     * -10^4 <= matrix[i][j], target <= 10^4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
     */
    @Test
    public void solutionTest() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        System.out.println(searchMatrix(matrix, 13)); // false
        System.out.println(searchMatrix(matrix, 7)); // true
        System.out.println(searchMatrix(matrix, 3)); // true

    }

    /**
     * 搜索二维矩阵
     * 题解：https://github.com/chefyuan/algorithm-base/blob/main/animation-simulation/%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE%E5%8F%8A%E5%85%B6%E5%8F%98%E7%A7%8D/%E4%BA%8C%E7%BB%B4%E6%95%B0%E7%BB%84%E7%9A%84%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE.md
     *
     * @param matrix
     * @param target
     * @return {@link boolean} 是否存在
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        // 行数
        int row = matrix.length;
        // 列数
        int col = matrix[0].length;
        int left = 0;
        // 行数乘列数 - 1，右指针
        int right = row * col - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            // 将一维坐标变为二维坐标
            int rownum = mid / col;
            int colnum = mid % col;
            if (matrix[rownum][colnum] == target) {
                return true;
            } else if (matrix[rownum][colnum] > target) {
                right = mid - 1;
            } else if (matrix[rownum][colnum] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}
