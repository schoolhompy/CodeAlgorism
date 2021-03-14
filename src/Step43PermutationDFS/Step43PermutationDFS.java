package Step43PermutationDFS;

import java.util.ArrayList;
import java.util.List;

class DataSource {
    int[] getAllData() {
        return new int[]{
                1,2,3
        };
    }
}

class Model {
    private final DataSource dataSource;

    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    List<List<Integer>> permuteDfs() {
        //input
        int[] data = this.dataSource.getAllData();

        //result
        List<List<Integer>> result = new ArrayList<>();

        //process
        List<Integer> list = new ArrayList<>();
        dfs(data, result, list);

        return result;
    }

    private void dfs(int[] data, List<List<Integer>> lists, List<Integer> cur) {
        if(cur.size() == data.length) {
            List<Integer> list = new ArrayList<>(cur);
            lists.add(list);
        }
        for (int i = 0; i < data.length; i++) {
            if(cur.contains(data[i])) continue;
            cur.add(data[i]);
            dfs(data, lists, cur);
            cur.remove(cur.size() -1);
        }
    }
}

public class Step43PermutationDFS {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.permuteDfs());
    }
}
