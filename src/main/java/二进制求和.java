import org.junit.Test;

import java.util.LinkedList;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class 二进制求和 {
    char jinwei = '0';//进位
    public String addBinary(String a, String b) {
        LinkedList<Character> qunue = new LinkedList<>();
        for(int i=1; i <= Math.max(a.length(), b.length()); i++){
            char first;
            char last;
            first = a.length() >= i ? a.charAt(a.length() - i) : '0';
            last = b.length() >= i ? b.charAt(b.length() - i) : '0';
            char[] addResult = add(first, last, jinwei);
            jinwei = addResult[0];
            qunue.push(addResult[1]);
        }
        StringBuffer sb = new StringBuffer();
        if(jinwei == '1'){
            sb.append(jinwei);
        }
        qunue.forEach(n->sb.append(n));
        return sb.toString();
    }

    @Test
    public void test(){
//        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("0", "0"));
        System.out.println(addBinary("0", "1"));
        System.out.println(addBinary("1", "1"));
    }

    private char[] add(char a, char b, char j) {
        int value = Integer.parseInt(String.valueOf(a)) + Integer.parseInt(String.valueOf(b)) + Integer.parseInt(String.valueOf(j));
        if (value == 0) {
            return new char[]{'0', '0'};
        } else if (value == 1) {
            return new char[]{'0', '1'};
        } else if (value == 2){
            return new char[]{'1', '0'};
        }else{
            return new char[]{'1', '1'};
        }
    }
}
