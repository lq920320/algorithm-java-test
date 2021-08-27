package leetcode.solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * # 234. 回文链表
 * 难度：简单
 *
 * @author zetu
 * @date 2021/5/20
 */
public class PalindromeLinkedList {

    /**
     * 请判断一个链表是否为回文链表。
     * <p>
     * 示例 1:
     * 输入: 1->2
     * 输出: false
     * <p>
     * 示例 2:
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
     */
    @Test
    public void solutionTest() {

    }

    public boolean isPalindrome(ListNode head) {
        //这里需要用动态数组，因为我们不知道链表的长度
        List<Integer> arr = new ArrayList<>();
        ListNode copynode = head;
        //将链表的值复制到数组中
        while (copynode != null) {
            arr.add(copynode.val);
            copynode = copynode.next;
        }
        // 双指针遍历数组
        int back = 0;
        int pro = arr.size() - 1;
        while (back < pro) {
            //判断两个指针的值是否相等
            if (!arr.get(pro).equals(arr.get(back))) {
                return false;
            }
            //移动指针
            back++;
            pro--;
        }
        return true;
    }


    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 找到中间节点，也就是翻转的头节点,这个在昨天的题目中讲到
        // 但是今天和昨天有一些不一样的地方就是，如果有两个中间节点返回第一个，昨天的题目是第二个
        ListNode midenode = searchmidnode(head);
        // 原地翻转链表，需要两个辅助指针。这个也是面试题目，大家可以做一下
        // 这里我们用的是midnode.next需要注意，因为我们找到的是中点，但是我们翻转的是后半部分
        ListNode backhalf = reverse(midenode.next);
        //遍历两部分链表，判断值是否相等
        ListNode p1 = head;
        ListNode p2 = backhalf;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        // 还原链表并返回结果,这一步是需要注意的，我们不可以破坏初始结构，我们只是判断是否为回文，
        //当然如果没有这一步也是可以AC，但是面试的时候题目要求可能会有这一条。
        midenode.next = reverse(backhalf);
        return true;
    }

    //找到中间的部分
    public ListNode searchmidnode(ListNode head) {
        ListNode fast;
        ListNode slow;
        fast = head;
        slow = head;
        //找到中点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //翻转链表
    public ListNode reverse(ListNode slow) {
        ListNode low = null;
        ListNode temp = null;
        //翻转链表
        while (slow != null) {
            temp = slow.next;
            slow.next = low;
            low = slow;
            slow = temp;
        }
        return low;
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
