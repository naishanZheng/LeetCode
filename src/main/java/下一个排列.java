import org.junit.Test;

/**
 * @author zhengnaishan
 * @date 2020/4/26 0026
 * @describe :
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 下一个排列 {
    int lastIndex = 0;

    public void nextPermutation(int[] nums) {
        lastIndex = nums.length - 1;
        if(lastIndex == 0){
            return;
        }else{
            getNext(nums, lastIndex - 1);
        }
    }

    void getNext(int[] nums, int deep){
        if(deep < 0){
            return;
        }
        int thisVaule = nums[deep];
        if (nums[deep] >= nums[lastIndex]){
           for(int i= deep; i < lastIndex; i++){
               nums[i] = nums[i+1];
           }
           nums[lastIndex] = thisVaule;
            getNext(nums, deep - 1);
           return ;
       }else{//找到位置
           for(int i= deep + 1 ; i<lastIndex + 1; i++){
               if(nums[i] > thisVaule){
                   nums[deep] = nums[i];
                   nums[i] = thisVaule;
                   return;
               }
           }
       }
    }


    @Test
    public void test(){
        int[] value = {5,1,1};
        nextPermutation(value);
        System.out.println(value);
    }
}
