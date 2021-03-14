package Step15SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 15.나선형 배열탐색
 *
 * 응용예제 []
 */
class DataSouce {
    int[][] getAllData() {
        return new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
    }
}

class Model {
    private final DataSouce dataSource;

    Model(DataSouce dataSouce) {
        this.dataSource = dataSouce;
    }

    List<Integer> runSpiral() {
        int[][] data = this.dataSource.getAllData();

        List<Integer> result = new ArrayList<>();

        int rowStart = 0;
        int rowEnd = data[0].length -1;
        int colStart =0;
        int colEnd = data[0].length -1;

        while(rowStart <= rowEnd && colStart <= colEnd ) {
            //left
            for(int i=colStart; i<=colEnd;i++) {
                result.add(data[rowStart][i]);
            }
            rowStart++;

            //down
            for(int i=rowStart; i<=rowEnd;i++) {
                result.add(data[i][colEnd]);
            }
            colEnd--;

            //right
            if(rowStart <= rowEnd)
            for(int i=colEnd; i>=colStart;i--) {
                result.add(data[rowEnd][i]);
            }
            rowEnd--;

            //up
            if(colStart <= colEnd)
                for(int i=rowEnd; i>=rowStart;i--) {
                    result.add(data[rowEnd][i]);
                }
            colStart++;

        }
        return result;
    }

}

public class Step15SpiralMatrix {
    public static void main(String[] args) {
        Model model = new Model(new DataSouce());

       System.out.print(model.runSpiral());
    }
}
