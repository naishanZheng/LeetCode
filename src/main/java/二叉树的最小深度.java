import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhengnaishan
 * @date 2020/4/4 0004
 * @describe :
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level  = 1;
        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i=0; i<count; i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    return level;
                }
                if(node.left != null){
                    queue.add(node.left);//队列，先进后出
                }
                if(node.right != null){
                    queue.add(node.right);//
                }
            }
            level ++;
        }

        return  -1;
    }
}
