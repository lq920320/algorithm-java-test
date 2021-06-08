package leetcode.solution;

import org.junit.Test;

/**
 * #328. 奇偶链表
 * 难度：中等
 *
 * @author zetu
 * @date 2021/6/8
 */
public class OddEvenLinkedList {

    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * <p>
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     * <p>
     * 示例 1:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     * <p>
     * 示例 2:
     * 输入: 2->1->3->5->6->4->7->NULL
     * 输出: 2->3->6->7->1->5->4->NULL
     * 说明:
     * <p>
     * 应当保持奇数节点和偶数节点的相对顺序。
     * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
     */
    @Test
    public void solutionTest() {

    }

    /**
     * 题目也很容易理解就是让我们将原来奇数位的结点放一起，偶数位的结点放一起。这里需要注意，和结点值无关，是奇数位和偶数位结点。
     * <p>
     * 我们可以先将奇数位合在一起，再将偶数位合在一起，最后再将两个链表合并很简单
     *
     * @param head 链表
     * @return 奇偶链表
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;

        while (odd.next != null && even.next != null) {
            // 将偶数位合在一起，奇数位合在一起
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        // 连接
        odd.next = evenhead;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
