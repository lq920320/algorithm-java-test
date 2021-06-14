package leetcode.solution;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * #剑指 Offer 59 - I. 滑动窗口的最大值
 * 难度：困难
 *
 * @author zetu
 * @date 2021/6/14
 */
public class MaxSlidingWindow {

    /**
     * #剑指 Offer 59 - I. 滑动窗口的最大值
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     * <p>
     * 示例:
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     * <p>
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * <p>
     * 提示：
     * <p>
     * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
     */
    @Test
    public void solutionTest() {

    }

    /**
     * 1.想将我们第一个窗口的所有值存入单调双端队列中，单调队列里面的值为单调递减的。如果发现队尾元素小于要加入的元素，则将队尾元素出队，直到队尾元素大于新元素时，再让新元素入队，目的就是维护一个单调递减的队列。
     * <p>
     * 2.我们将第一个窗口的所有值，按照单调队列的规则入队之后，因为队列为单调递减，所以队头元素必为当前窗口的最大值，则将队头元素添加到数组中。
     * <p>
     * 3.移动窗口，判断当前窗口前的元素是否和队头元素相等，如果相等则出队。
     * <p>
     * 4.继续然后按照规则进行入队，维护单调递减队列。
     * <p>
     * 5.每次将队头元素存到返回数组里。
     * <p>
     * 5.返回数组
     *
     * @param nums
     * @param k
     * @return {@link int[]}
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return nums;
        }
        int[] arr = new int[len - k + 1];
        int arr_index = 0;
        // 我们需要维护一个单调递增的双向队列
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.offerLast(nums[i]);
        }
        arr[arr_index++] = deque.peekFirst();
        for (int j = k; j < len; j++) {
            if (nums[j - k] == deque.peekFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.offerLast(nums[j]);
            arr[arr_index++] = deque.peekFirst();
        }
        return arr;
    }
}
