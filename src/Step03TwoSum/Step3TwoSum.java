package Step03TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 3.두수의 합이 타멧과 같을때 두수의 index번호를 알아맞추자
 * {2, 8, 10, 21} 데이터일때 target 10 이 index 1,2
 *  findMap 에는
 *  1.(타겟에서 현재값을뺴고 다음찾을값), 현재 i => 모든 i에대해 저장됨.
 *  2.key중에서 타켓에서 뺸 나머지값과 일지하는 값이 현재i에 나타나면
 *    저장된 i와 현재 i 에 인간식별번호 +1 을 해서 index를 돌려좀
 *  응용예제 [두성적의 합이 70점인 과목만 추려내기]
 */

class DataSource1 implements Repositry{
    @Override
    public int[] getAllData() {
        return new int[]{10, 8, 21, 2};
    }
}

class DataSource2 implements Repositry {
    @Override
    public int[] getAllData() {
        return new int[]{5, 4, 3, 2, 1};
    }
}

interface Repositry {
    int[] getAllData();
}

class Model {
    private int target;
    Model(int target) {
        this.target = target;
    }
    public void setTarget(int target) {
        this.target = target;
    }


    public int[] findTwoSum(Repositry dataSource) {
        int[] result = new int[2];

        int[] sourceData = dataSource.getAllData();
        Map<Integer, Integer> findMap = new HashMap<>();

        for (int i = 0; i < sourceData.length; i++) {

            if (findMap.containsKey(sourceData[i])) {
                int value = findMap.get(sourceData[i]);
                result[0] = value + 1;
                result[1] = i + 1;
            } else {
                findMap.put(target - sourceData[i], i);
            }
        }

        findMap.forEach((key, value) -> System.out.println(key + "/" + value));

        return result;
    }
}

public class Step3TwoSum {
    public static void main(String[] args) {
        DataSource1 datasource1 = new DataSource1();
        Model model = new Model(10);

        int[] result = model.findTwoSum(datasource1);
        for (int k : result) {
            System.out.println(k);
        }


        DataSource2 datasource2 = new DataSource2();
        model.setTarget(4);
        result = model.findTwoSum(datasource2);
        for (int j : result) {
            System.out.println(j);
        }
    }

}
