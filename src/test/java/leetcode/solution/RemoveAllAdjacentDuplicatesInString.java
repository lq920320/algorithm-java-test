package leetcode.solution;

import org.junit.Test;

import java.util.Stack;

/**
 * #1047. 删除字符串中的所有相邻重复项
 * 难度：简单
 *
 * @author zetu
 * @date 2021/6/10
 */
public class RemoveAllAdjacentDuplicatesInString {

    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     * <p>
     * 示例：
     * 输入："abbaca"
     * 输出："ca"
     * 解释：
     * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
     * <p>
     * 提示：
     * 1 <= S.length <= 20000
     * S 仅由小写英文字母组成。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
     */
    @Test
    public void solutionTest() {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
        String s2 = "abbaca";
        System.out.println(removeDuplicates2(s2));
    }

    /**
     * 把字符压入栈中，如果发现重复的就出栈，否则入栈，最后返回栈中的数据
     *
     * @param s
     * @return {@link String}  去重后的结果
     */
    public String removeDuplicates(String s) {
        // 特殊情况
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            if (stack.contains(aChar)) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : stack) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

    /**
     * 我们将字符入栈，然后新的字符入栈之前先于栈顶元素对比，判断是否和栈顶元素一致，如果一致则栈顶元素出栈，指针移到下一位，则就实现了去除重复元素。如果和栈顶元素不同或栈为空则将当前元素入栈。直至字符串遍历结束，另外我们需要注意的是栈是先进后出，最后我们元素出栈的时候，我们需要对字符串反转一下才为我们的答案。
     *
     * @param S
     * @return 栈中的数据
     */
    public String removeDuplicates2(String S) {
        // 特殊情况
        if (S.length() == 0 || S.length() == 1) {
            return S;
        }
        Stack<Character> stack = new Stack<>();
        char[] s = S.toCharArray();// 先将字符串变成字符数组

        // 遍历数组
        for (int i = 0; i < S.length(); i++) {
            // 为空或者和栈顶元素不同时入栈
            if (stack.isEmpty() || s[i] != stack.peek()) {
                stack.push(s[i]);
            } else {
                // 相同出栈
                stack.pop();
            }
        }

        StringBuilder str = new StringBuilder();
        // 字符出栈
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        // 翻转字符并返回
        return str.reverse().toString();
    }

}
