package Step13FindAnagramsMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 13.원본의 원소가 무작위로 들어 있는 다른 그룹에서 배치된 번호 찾기
 *
 * 응용예제 [출석부 학생의 성적등수, 운동회 등수]
 */

class DataSource {
    int[][] getAllData() {
        return new int[][]{
                {11, 27, 45, 31, 50},
                {50, 11, 31, 45, 27}
        };
    }
}

class Model {
    DataSource dataSource;
    Model (DataSource dataSource) {
        this.dataSource = dataSource;
    }

    int[] getMatchedPos() {
        int[] a = this.dataSource.getAllData()[0];
        int[] b = this.dataSource.getAllData()[1];

        int[] result = new int [a.length];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<a.length; i++) {
            map.put(b[i], i);
        }

        for(int i=0; i<a.length; i++) {
            result[i] = map.get(a[i]);
        }
        return result;
    }
}

public class Step13FindAnagramsMapping {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        for(int v: model.getMatchedPos()) {
            System.out.println(v);
        }
    }

}
