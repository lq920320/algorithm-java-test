package leetcode.solution;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Test;

/**
 * @author liuqian
 * @date 2019/5/15  16:50
 * <p>
 * leetcode #226
 */
public class InvertBinaryTree {

  //  翻转一棵二叉树。
  //
  //  示例：
  //
  //  输入：
  //
  //        4
  //      /   \
  //     2     7
  //    / \   / \
  //   1   3 6   9
  //
  //   输出：
  //
  //        4
  //      /   \
  //     7     2
  //    / \   / \
  //   9   6 3   1

  /**
   * 翻转一棵二叉树
   */
  @Test
  public void invertBinaryTreeTest() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    TreeNode root1 = new TreeNode(4);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(7);
    root1.left.left = new TreeNode(1);
    root1.left.right = new TreeNode(3);
    root1.right.left = new TreeNode(6);
    root1.right.right = new TreeNode(9);

    System.out.println(objectMapper.writeValueAsString(root1));
    TreeNode root2 = invertTree(root1);
    System.out.println(objectMapper.writeValueAsString(root2));

  }

  public TreeNode invertTree(TreeNode root) {
    if (root != null) {
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
      invertTree(root.left);
      invertTree(root.right);
    }
    return root;
  }


  @Data
  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
