import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengnaishan
 * @date 2020/4/6 0006
 * @describe :
 * <p>
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class 二叉树的层次遍历2 {

    Map<String, List<Integer>> map =  new  HashMap();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        int deepLevel = add(0, root);
        ArrayList result = new ArrayList();
        for( ; deepLevel >= 0; deepLevel --){
            result.add(map.get(String.valueOf(deepLevel)));
        }
        return result;
    }

    public int add(int deep, TreeNode node){
        if(node != null){
            List<Integer> levels = map.get(deep + "");
            if(levels == null){
                levels = new ArrayList<Integer>();
                map.put(deep + "", levels);
            }
            levels.add(node.val);

            int deepLeft = add(deep + 1, node.left);
            int deepRight = add(deep + 1, node.right);
            return Math.max(deepLeft, deepRight);
        }
        return deep - 1;
    }
}
