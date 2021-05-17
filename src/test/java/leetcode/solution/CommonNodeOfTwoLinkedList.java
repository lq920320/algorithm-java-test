package leetcode.solution;

import org.junit.Test;

import java.util.HashSet;

/**
 * #剑指 Offer 52. 两个链表的第一个公共节点
 * 难度：简单
 *
 * @author zetu
 * @date 2021/5/17
 */
public class CommonNodeOfTwoLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 输入两个链表，找出它们的第一个公共节点。
     * <p>
     * 如下面的两个链表：
     * 在节点 c1 开始相交。
     * 示例 1：
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     * <p>
     * 示例2：
     * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * 输出：Reference of the node with value = 2
     * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
     * <p>
     * 示例 3：
     * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * 输出：null
     * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
     * 解释：这两个链表不相交，因此返回 null。
     * <p>
     * 注意：
     * <p>
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     * 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
     */
    @Test
    public void solutionTest() {
        // listA = [4,1,8,4,5], listB = [5,0,1,8,4,5]
    }


    /**
     * HashSet
     * 主要思路就是，先遍历一个链表将链表的所有值都存到Hashset中，然后再遍历另一个链表，如果发现某个结点在Hashset中已经存在那我们直接返回该节点即可，代码也很简单。
     *
     * @param headA
     * @param headB
     * @return {@link ListNode} 公共节点
     */
    public ListNode solution1(ListNode headA, ListNode headB) {
        ListNode tempa = headA;
        ListNode tempb = headB;
        //定义Hashset
        HashSet<ListNode> arr = new HashSet<>();
        while (tempa != null) {
            arr.add(tempa);
            tempa = tempa.next;
        }
        while (tempb != null) {
            // ??? 跑不过测试
            if (arr.contains(tempb)) {
                return tempb;
            }
            tempb = tempb.next;
        }
        return null;
    }

    /**
     * 双指针法
     *
     * @param headA
     * @param headB
     * @return {@link ListNode} 共同节点
     */
    public ListNode solution2(ListNode headA, ListNode headB) {
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


}
