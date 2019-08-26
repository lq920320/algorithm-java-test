package leetcode.solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author liuqian
 * @date 2019/8/6 16:58.
 * <p>
 * leetcode #224
 */
public class BasicCalculator {

    /*
     *实现一个基本的计算器来计算一个简单的字符串表达式的值。
     *
     * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
     *
     * 示例 1:
     *
     * 输入: "1 + 1"
     * 输出: 2
     *
     * 示例 2:
     *
     * 输入: " 2-1 + 2 "
     * 输出: 3
     *
     * 示例 3:
     *
     * 输入: "(1+(4+5+2)-3)+(6+8)"
     * 输出: 23
     *
     * 说明：
     *
     *     你可以假设所给定的表达式都是有效的。
     *     请不要使用内置的库函数 eval。
     *
     */
    @Test
    public void basicCalculator() {
        String expression = "(1+(4+5+2)-3)+(6+8)";
        String expression1 = "(10+(4+5+2)-3)+(16+28)";
        Assert.assertEquals(2, calculate("1 + 1"));
        Assert.assertEquals(3, calculate(" 2-1 + 2 "));
        Assert.assertEquals(23, calculate(expression));
        Assert.assertEquals(62, calculate(expression1));
        Assert.assertEquals(2, calculate2("1 + 1"));
        Assert.assertEquals(3, calculate2(" 2-1 + 2 "));
        Assert.assertEquals(23, calculate2(expression));
        Assert.assertEquals(62, calculate2(expression1));
//        Assert.assertEquals(2, calculate3("1 + 1"));
//        Assert.assertEquals(3, calculate3(" 2-1 + 2 "));
//        Assert.assertEquals(23, calculate3(expression));
//        Assert.assertEquals(62, calculate3(expression));
    }

    @Test
    public void charTest() {
        char ch = '3';
        System.out.println(ch - '0');
        String infixExpression = "8-7+((5+5)-8)-2+7";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println(postfixExpression);
        System.out.println(rpnCalculate(postfixExpression));
    }

    public int calculate(String s) {
        int operand = 0;
        int n = 0;
        Stack<Object> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                operand = (int) Math.pow(10, n) * (ch - '0') + operand;
                n += 1;
            } else if (ch != ' ') {
                if (n != 0) {
                    // 将操作数保存到 栈
                    // 因为我们遇到一些非数字
                    stack.push(operand);
                    n = 0;
                    operand = 0;
                }
                if (ch == '(') {
                    int res = calculateExpr(stack);
                    stack.pop();
                    // 将计算结果保存到 栈
                    // 该结果可以是括号内的子表达式
                    stack.push(res);
                } else {
                    // 对于其他非数字字符只需推入栈
                    stack.push(ch);
                }
            }
        }
        // 如果有的话，将最后一个操作数推送到堆栈。
        if (n != 0) {
            stack.push(operand);
        }

        // 计算堆栈中的剩余部分
        return calculateExpr(stack);
    }

    private int calculateExpr(Stack<Object> stack) {
        int result = 0;
        if (!stack.isEmpty()) {
            result = (int) stack.pop();
        }
        // 计算整个表达式知道我们对到 ')'
        while (!stack.isEmpty() && !((char) stack.peek() == ')')) {
            char sign = (char) stack.pop();
            if (sign == '+') {
                result += (int) stack.pop();
            } else {
                result -= (int) stack.pop();
            }
        }
        return result;
    }

    public int calculate2(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        int sign = 1; // 1 代表正，-1 代表负

        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                // 形成操作数，因为它可能超过一位数
                operand = 10 * operand + (ch - '0');
            } else if (ch == '+') {
                // 使用结果，符号，操作数计算左边的表达式
                result += sign * operand;

                // 保存最近遇到的 '+' 号
                sign = 1;
                // 重置操作数
                operand = 0;
            } else if (ch == '-') {
                result += sign * operand;
                sign = -1;
                operand = 0;
            } else if (ch == '(') {
                // 将结果入栈，为了等下的计算
                // 先是结果，再是符号
                stack.push(result);
                stack.push(sign);
                // 重置操作数和结果，接着开始计算新的子表达式
                sign = 1;
                result = 0;
            } else if (ch == ')') {
                // 使用结果，符号，操作数计算左边的表达式
                result += sign * operand;
                // ')' 在一组括号内标记表达式的结尾
                // 其结果乘以堆栈顶部的符号，因为stack.pop() 是括号前的符号
                result *= stack.pop();
                // 然后加上栈顶的下一个操作数
                // (operand on stack) + (sign on stack * (result from parenthesis))
                result += stack.pop();
                // 重置操作数
                operand = 0;
            }
        }
        return result + (sign * operand);
    }


    public int calculate3(String expression) {
        // 中缀转后缀
        String rpnExpression = infixToPostfix(expression);
        // 计算后缀
        return rpnCalculate(rpnExpression);
    }

    private String infixToPostfix(String s) {
        // 最终结果
        StringBuilder rpnExpression = new StringBuilder();
        // 运算符栈
        Stack<Character> operatorStack = new Stack<>();
        // 操作数
        int operand = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                // 形成操作数，因为它可能超过一位数
                operand = 10 * operand + (ch - '0');
            } else if (ch == '+') {
                // 将操作数作为输出
                rpnExpression.append(operand).append(" ");
                if (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    // 将操作符栈中的栈顶元素输出
                    rpnExpression.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(ch);
                // 重置操作数
                operand = 0;
            } else if (ch == '-') {
                rpnExpression.append(operand).append(" ");
                if (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    rpnExpression.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(ch);
                operand = 0;
            } else if (ch == '(') {
                rpnExpression.append(operand).append(" ");
                operatorStack.push(ch);
                operand = 0;
            } else if (ch == ')') {
                while (operatorStack.peek() != '(') {
                    rpnExpression.append(operatorStack.pop()).append(" ");
                }
                if (operatorStack.peek() == '(') {
                    operatorStack.pop();
                }
                rpnExpression.append(operand).append(" ");
                operand = 0;
            }
        }
        return rpnExpression.toString();
    }

    private int rpnCalculate(String rpnExpression) {
        // rpnExpression 是以空格为分隔符的 rpn 表达式
        String[] tokens = rpnExpression.split(" ");
        Stack<Integer> stack = new Stack<>();
        int result;
        for (String t : tokens) {
            switch (t) {
                case "+":
                    result = stack.pop() + stack.pop();
                    break;
                case "*":
                    result = stack.pop() * stack.pop();
                    break;
                case "/":
                    // 除法需要保持顺序，比如 "13", "5", "/" => 应该是 13 / 5 而不是 5 / 13
                    int last = stack.pop();
                    result = stack.pop() / last;
                    break;
                case "-":
                    // 减法顺序和除法一样
                    last = stack.pop();
                    result = stack.pop() - last;
                    break;
                default:
                    result = Integer.parseInt(t);
                    break;
            }
            // 将计算结果或者元素本身推入栈中
            stack.push(result);
        }
        return stack.pop();
    }

}
