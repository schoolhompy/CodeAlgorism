package Step37TopologicalSort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 37.위상정렬을 이용한 학점이수 스케쥴
 *
 * 0과목을 이수하기위해서는 1과목을 이후새야하고 1-2,2-3 순으로 이수가 완료되어야 한다.
 * 하나라도 이수를 못했다면 졸업을 못한다.
 */


class DataSource {
    int[][] getAllData() {
        return new int[][] {
                {1,0},
                {2,1},
                {3,2}
        };
    }
}

class Model {

    private final DataSource dataSource;

    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    boolean topologicalSort(int courseNumber) {
        int[][] data = this.dataSource.getAllData();

        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[courseNumber];

        int numLength = data.length;
        for(int i=0; i<numLength;i++) {
            inDegree[data[i][1]]++;
        }

        int inDegreeLength = inDegree.length;
        for (int i=0; i< inDegreeLength; i++) {
            if(inDegree[i] ==0) queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int firstZeroBal = queue.poll();

            for(int i=0; i<numLength; i++) {
                if(firstZeroBal == data[i][0]) {
                    inDegree[data[i][1]]--;
                    if(inDegree[data[i][1]]==0) queue.offer(data[i][1]);
                }
            }
        }

        for(int i=0; i< inDegreeLength; i++) {
            if(inDegree[i] != 0) return  false;
        }

        return true;
    }

}
public class Step37TopologicalSort {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.topologicalSort(4));
    }
}
