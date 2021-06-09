package leetcode.solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * #881. 救生艇
 * 难度：中等
 *
 * @author zetu
 * @date 2021/6/9
 */
public class BoatsToSavePeople {

    /**
     * #881. 救生艇
     * <p>
     * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
     * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
     * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
     * <p>
     * 示例 1：
     * 输入：people = [1,2], limit = 3
     * 输出：1
     * 解释：1 艘船载 (1, 2)
     * <p>
     * 示例 2：
     * 输入：people = [3,2,2,1], limit = 3
     * 输出：3
     * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
     * <p>
     * 示例 3：
     * 输入：people = [3,5,3,4], limit = 5
     * 输出：4
     * 解释：4 艘船分别载 (3), (3), (4), (5)
     * 提示：
     * <p>
     * 1 <= people.length <= 50000
     * 1 <= people[i] <= limit <= 30000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/boats-to-save-people
     */
    @Test
    public void solutionTest() {
        int[] people = {3, 5, 3, 4};
        int limit = 5;
        // 4
        System.out.println(solution(people, limit));
    }

    /**
     * 思路：双指针
     * 如果最重的人可以与最轻的人共用一艘船，那么就这样安排。否则，最重的人无法与任何人配对，那么他们将自己独自乘一艘船。
     * 这么做的原因是，如果最轻的人可以与任何人配对，那么他们也可以与最重的人配对。
     * <p>
     * 代码实现思路：
     * 现将人的体重排序，然后左右指针往中间移动
     *
     * @param people
     * @param limit
     * @return 所需最小船数量
     */
    public int solution(int[] people, int limit) {
        // 首先进行排序
        Arrays.sort(people);
        // 左右指针
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }

        return ans;
    }
}
