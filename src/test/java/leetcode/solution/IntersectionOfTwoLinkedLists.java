package leetcode.solution;

import org.junit.Test;

import java.util.HashSet;

/**
 * #160. 相交链表
 * 难度：简单
 *
 * @author zetu
 * @date 2021/6/8
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
     * <p>
     * 图示两个链表在节点 c1 开始相交：
     * 题目数据 保证 整个链式结构中不存在环。
     * <p>
     * 注意，函数返回结果后，链表必须 保持其原始结构 。
     *
     * <p>
     * 示例 1：
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Intersected at '8'
     * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
     * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
     * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     * <p>
     * 示例 2：
     * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * 输出：Intersected at '2'
     * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
     * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
     * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
     * <p>
     * 示例 3：
     * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * 输出：null
     * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
     * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
     * 这两个链表不相交，因此返回 null 。
     * <p>
     * 提示：
     * listA 中节点数目为 m
     * listB 中节点数目为 n
     * 0 <= m, n <= 3 * 104
     * 1 <= Node.val <= 105
     * 0 <= skipA <= m
     * 0 <= skipB <= n
     * 如果 listA 和 listB 没有交点，intersectVal 为 0
     * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
     * <p>
     * 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
     */
    @Test
    public void solutionTest() {

    }

    /**
     * HashSet
     * 这个方法是比较简单的，主要思路就是，先遍历一个链表将链表的所有值都存到Hashset中，然后再遍历另一个链表，如果发现某个结点在Hashset中已经存在那我们直接返回该节点即可，代码也很简单。
     *
     * @param headA 链表1
     * @param headB 链表2
     * @return 相交的节点
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode tempa = headA;
        ListNode tempb = headB;
        // 定义Hashset
        HashSet<ListNode> arr = new HashSet<>();
        while (tempa != null) {
            arr.add(tempa);
            tempa = tempa.next;
        }
        while (tempb != null) {
            if (arr.contains(tempb)) {
                return tempb;
            }
            tempb = tempb.next;
        }
        return null;
    }

    /**
     * 双指针法
     * 我们利用双指针，当某一指针遍历完链表之后，然后掉头去另一个链表的头部，继续遍历。因为速度相同所以他们第二次遍历的时候肯定会相遇，是不是很浪漫啊！
     *
     * @param headA
     * @param headB
     * @return 相交节点
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // 定义两个节点
        ListNode tempa = headA;
        ListNode tempb = headB;
        // 循环
        while (tempa != tempb) {
            // 如果不为空就指针下移，为空就跳到另一链表的头部
            tempa = tempa != null ? tempa.next : headB;
            tempb = tempb != null ? tempb.next : headA;
        }
        return tempa;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
