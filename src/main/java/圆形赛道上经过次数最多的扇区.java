import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 圆形赛道上经过次数最多的扇区 {

    public List<Integer> mostVisited(int n, int[] rounds) {
        ArrayList<Integer> result = new ArrayList<>();

        int begin = rounds[0];
        int end = rounds[rounds.length - 1] >= begin ? rounds[rounds.length - 1] : n + rounds[rounds.length - 1];
        while(begin <= end){
            int k = begin <= n ? begin :  begin - n;
            result.add(k);
            begin++;
        }
        Collections.sort(result);
        return result;
    }

    @Test
    public void test(){
//        System.out.println(mostVisited(4, new int[]{1,3,1,2}));
//        System.out.println(mostVisited(2, new int[]{2,1,2,1,2,1,2,1,2}));
//        System.out.println(mostVisited(2, new int[]{1,3,5,7}));
        System.out.println(mostVisited(3, new int[]{3,2,1,2,1,3,2,1,2,1,3,2,3,1}));
    }
}
