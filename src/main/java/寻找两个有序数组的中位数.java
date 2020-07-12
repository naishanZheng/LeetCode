import org.junit.Test;

/**
 * @author zhengnaishan
 * @date 2020/4/22 0022
 * @describe :
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 寻找两个有序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m1 = nums1.length / 2;
        int m2 = nums2.length / 2;

        boolean falt = (nums1.length + nums2.length) % 2 != 0;


        while(true){

            if(nums1.length == 0){
                return nums2[m2];
            }
            if(nums2.length == 0){
                return nums1[m1];
            }

            if(nums1.length == 1 && nums2.length == 1){
                return (nums1[0] + nums2[0]) /2;
            }

            //把满值返回先
            if(m1 == nums1.length - 1){
                if(falt){
                    if(nums2[m2] > nums1[m1]){
                        return nums2[m2-1];
                    }else{
                        return nums2[m2];
                    }
                }else{
                    return (nums2[m2] + nums2[m2 + 1]) / 2;
                }
            }

            if(m2 == nums2.length - 1){
                if(falt){
                    if(nums1[m1] > nums2[m2]){
                        return nums1[m1-1];
                    }else{
                        return nums1[m1];
                    }
                }else{
                    return (nums1[m1] + nums1[m1 + 1]) / 2;
                }
            }

            if(m2 < nums1.length - 1 && nums1[m1] > nums2[m2 + 1]){
                m2 = (m2 + nums2.length) / 2;
                m1 = nums1.length + nums2.length - m2;
            }else if(m1 < nums1.length - 1 && nums1[m1 + 1] < nums2[m2]){
                //m1右移
                m1 = (m1 + nums1.length) / 2;
                m2 = nums1.length + nums2.length - m1;
            }else if(nums1[m1] < nums2[m2 + 1] && nums2[m2] < nums1[m1+1]){
                if((nums1.length + nums2.length) % 2 ==0 ){
                   return (nums1[m1] + nums2[m2]) /  2;
                }else{
                    return Math.max(nums1[m1], nums2[m2]);
                }
            }

        }

    }

    @Test
    public void test(){
        System.out.println(findMedianSortedArrays(new int[]{3,9}, new int[]{2}));
    }

}
