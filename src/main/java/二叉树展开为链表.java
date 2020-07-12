import org.junit.Test;

/**
 * @author zhengnaishan
 * @date 2020/4/6 0006
 * @describe :
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class 二叉树展开为链表 {
    /**
     * 二叉树前序遍历
     */
    public void flatten(TreeNode root) {
        TreeNode begin = root.left != null ? root.left : root.right;
        last = root;
        putRight(begin);

    }
     TreeNode last;
     public void putRight(TreeNode node){
        if(node == null){
            return;
        }
        TreeNode right = node.right;
        last.right = node;
        last = node;
        putRight(node.left);
        putRight(right);
        node.left = null;
    }


    @Test
    public void test(){
        TreeNode tree1 = new TreeNode(1);
        TreeNode tree2 = new TreeNode(2);
        TreeNode tree3 = new TreeNode(3);
        TreeNode tree4 = new TreeNode(4);
        TreeNode tree5 = new TreeNode(5);
        TreeNode tree6 = new TreeNode(6);
        tree1.left = tree2;
        tree1.right = tree5;
        tree2.left = tree3;
        tree2.right = tree4;
        tree5.right = tree6;
        flatten(tree1);
    }
}
