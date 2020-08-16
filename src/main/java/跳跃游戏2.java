import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 *     顺序寻找每一次最远跳跃点（p）,最小跳跃次数jumpCnt
 *     上一次跳跃和下一次跳跃之间的元素最远跳跃次数为jumpCnt
 *       maxNext = Math.max(nums[i], maxNext - 1);
 *
 */

public class 跳跃游戏2 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length <= nums[0] + 1) {
            return 1;
        }
        int jumpCnt = 0;
        int length = nums[0];//上一跳到下一跳可用长度
        int maxNext = nums[0];//当前位置距离下一跳最远距离
        for (int i = 1; i < nums.length; i++) {
            if (--length <= 0) {
                jumpCnt++;
                length = Math.max(maxNext - 1, nums[i]);
                if(i == nums.length - 1){
                    return jumpCnt;
                }
            }
            maxNext = Math.max(nums[i], maxNext - 1);
        }
        return jumpCnt + 1;
    }


    @Test
    public void test() {
        Assert.assertTrue(jump(new int[]{2, 3, 1, 1, 4}) == 2);;
        Assert.assertTrue(jump(new int[]{1, 1, 1, 1}) == 3);
        Assert.assertTrue(jump(new int[]{1, 2, 3}) == 2);
        Assert.assertTrue(jump(new int[]{1, 3, 2}) == 2);
    }
}
