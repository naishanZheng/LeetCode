import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @author zhengnaishan
 * @date 2020/3/1 0001
 * @describe :
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的层次遍历 {
    Map<String, List<Integer>> map =  new  HashMap();
    public List<List<Integer>> levelOrder(TreeNode root) {
        add(0, root);
        ArrayList result = new ArrayList();
        for(int i=0;map.get(String.valueOf(i)) != null;i++){
            result.add(map.get(String.valueOf(i)));
        }
        return result;
    }

    public void add(int deep, TreeNode node){
        if(node != null){
            List<Integer> levels = map.get(deep + "");
            if(levels == null){
                levels = new ArrayList<Integer>();
                map.put(deep + "", levels);
            }
            levels.add(node.val);

            add(deep + 1, node.left);
            add(deep + 1, node.right);
        }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 队列方式
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null)
            return new ArrayList();
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while(count > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                count--;
            }
            res.add(list);
        }
        return res;
    }
}
