package Step44Subsets;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * 4４.subsets 주어진 문자열이 가지는 하위 조합수
 *
 *
 *
 */
class DataSource {
    int[] getAllData() {
        return new int[] {
                1,2,3
        };
    }
}

class Model {
    private final DataSource dataSource;

    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    List<List<Integer>> subsets() {
        //input
        int[] data = this.dataSource.getAllData();

        //result
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(result, list, data, 0);

        return result;
    }

    private void dfs(List<List<Integer>> lists, List<Integer> cur, int[] nums, int start) {
        List<Integer> list = new ArrayList<>(cur);
        lists.add(list);
        System.out.println(lists);

        for(int i=start; i< nums.length; i++) {
            cur.add(nums[i]);
            dfs(lists, cur, nums, i+1);
            cur.remove(cur.size()-1);
        }
    }
}

public class Step44Subsets {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.subsets());
    }
}
