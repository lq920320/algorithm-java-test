package leetcode.solution;

import org.junit.Test;

/**
 * #876. 链表的中间结点
 * 难度：简单
 *
 * @author zetu
 * @date 2021/5/17
 */
public class MiddleOfLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * #876. 链表的中间结点
     * <p>
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * <p>
     * 示例 1：
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     * 示例：
     * <p>
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     * <p>
     * 提示：
     * <p>
     * 给定链表的结点数介于 1 和 100 之间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
     */
    @Test
    public void solutionTest() {
        // [1,2,3,4,5]
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        // 4
        System.out.println(solution1(listNode).val);

        // [1,2,3,4,5,6,7,8,9,10]
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(2);
        listNode2.next.next = new ListNode(3);
        listNode2.next.next.next = new ListNode(4);
        listNode2.next.next.next.next = new ListNode(5);
        listNode2.next.next.next.next.next = new ListNode(6);
        listNode2.next.next.next.next.next.next = new ListNode(7);
        listNode2.next.next.next.next.next.next.next = new ListNode(8);
        listNode2.next.next.next.next.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next.next.next.next.next = new ListNode(10);
        // 6
        System.out.println(solution1(listNode2).val);
    }

    /**
     * 双指针法，快慢指针
     * 这种类型的双指针是我们做链表的题目经常用到的，叫做快慢指针。
     * 一个指针走的快，一个指针走的慢，这个题目我们可以让快指针一次走两步，慢指针一次走一步，当快指针到达链表尾部的时候，慢指针不就到达中间节点了吗？
     * 链表中节点的个数有可能为奇数也有可能为偶数，这是两种情况，但是我们输出是相同的，那就是输出slow指针指向的节点
     *
     * @param head
     * @return midNode
     */
    public ListNode solution1(ListNode head) {
        // 快指针
        ListNode fast = head;
        // 慢指针
        ListNode slow = head;
        // 循环条件，思考一下跳出循环的情况
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 返回slow指针指向的节点
        return slow;
    }

}
