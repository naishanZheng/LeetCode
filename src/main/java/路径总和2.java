import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhengnaishan
 * @date 2020/4/4 0004
 * @describe :
 * <p>
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class 路径总和2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList request = new ArrayList();
        return getNext(request, root, sum);

    }

    List<List<Integer>> getNext(List<Integer> request, TreeNode node, int num) {
        ArrayList result = new ArrayList();
        if (node == null) {
            return result;
        }
        if (num == node.val && node.right == null && node.left == null) {
            request.add(node.val);
            result.add(request);
            return result;
        }

        request.add(node.val);
        ArrayList<Integer> left = new ArrayList(request);
        ArrayList<Integer> right = new ArrayList(request);

        List<List<Integer>> leftResult = getNext(left, node.left, num - node.val);
        List<List<Integer>> rightResult = getNext(right, node.right, num - node.val);

        if (leftResult != null && !leftResult.isEmpty()) {
            result.addAll(leftResult);
        }
        if (rightResult != null && !rightResult.isEmpty()) {
            result.addAll(rightResult);
        }
        return result;
    }
}
