import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengnaishan
 * @date 2020/3/1 0001
 * @describe :
 */
public class 二叉树的锯齿形层次遍历 {

    Map<String, List<Integer>> map =  new HashMap();
    public List<List<Integer>> levelOrder(二叉树的层次遍历.TreeNode root) {
        add(0, root);
        ArrayList result = new ArrayList();
        for(int i=0;map.get(String.valueOf(i)) != null;i++){
            result.add(map.get(String.valueOf(i)));
        }
        return result;
    }

    public void add(int deep, 二叉树的层次遍历.TreeNode node){
        if(node != null){
            List<Integer> levels = map.get(deep + "");
            if(levels == null){
                levels = new ArrayList<Integer>();
                map.put(deep + "", levels);
            }
            levels.add(node.val);

            if(deep % 2 == 0){
                add(deep + 1, node.right);
                add(deep + 1, node.left);
            }else{
                add(deep + 1, node.left);
                add(deep + 1, node.right);
            }
        }
    }


}
