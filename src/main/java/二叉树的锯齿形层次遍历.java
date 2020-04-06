import java.util.*;

/**
 * @author zhengnaishan
 * @date 2020/3/1 0001
 * @describe :
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的锯齿形层次遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int level = 1;
        while(!queue.isEmpty()){
            int count = queue.size();
            LinkedList<Integer> list = new LinkedList<Integer>();

            for(int i=0; i<count; i++){
                TreeNode node = queue.poll();
                if(level % 2 == 1){
                    list.add(node.val);
                }else{
                    list.push(node.val);
                }
                if(node.left != null){
                    queue.add(node.left);//队列，先进后出
                }
                if(node.right != null){
                    queue.add(node.right);//
                }
            }
            result.add(list);
            level ++;
        }
        return  result;
    }


}
