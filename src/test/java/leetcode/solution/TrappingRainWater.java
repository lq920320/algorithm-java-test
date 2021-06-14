package leetcode.solution;

import org.junit.Test;

import java.util.Stack;

/**
 * #42. 接雨水
 * 难度：困难
 *
 * @author zetu
 * @date 2021/6/14
 */
public class TrappingRainWater {

    /**
     * #42. 接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * 示例 1：
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     * <p>
     * 提示：
     * n == height.length
     * 0 <= n <= 3 * 104
     * 0 <= height[i] <= 105
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water
     */
    @Test
    public void solutionTest() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height)); // 6
    }

    /**
     * 题解：https://github.com/chefyuan/algorithm-base/blob/main/animation-simulation/%E5%8D%95%E8%B0%83%E9%98%9F%E5%88%97%E5%8D%95%E8%B0%83%E6%A0%88/%E6%8E%A5%E9%9B%A8%E6%B0%B4.md
     *
     * @param height
     * @return {@link int}
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        // 特殊情况
        if (height.length < 3) {
            return 0;
        }
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 栈顶元素
                int popnum = stack.pop();
                // 相同元素的情况例1，1
                while (!stack.isEmpty() && height[popnum] == height[stack.peek()]) {
                    stack.pop();
                }
                // 计算该层的水的单位
                if (!stack.isEmpty()) {
                    int temp = height[stack.peek()];// 栈顶元素值
                    // 高
                    int hig = Math.min(temp - height[popnum], height[i] - height[popnum]);
                    // 宽
                    int wid = i - stack.peek() - 1;
                    water += hig * wid;
                }

            }
            //这里入栈的是索引
            stack.push(i);
        }
        return water;
    }
}
