package Step09Kclosest;

import java.util.PriorityQueue;

/**
 * 9.가장 가까운 거리 찾기
 * 입력된 데이터의 작은값 정렬/큰값 정렬은 PriorityQueue가 제일빠르
 *
 * 응용예제 [가장 가까운 가게찾기]
 */
class DataSouce {
    int[][] getAllData() {
        return new int[][]{{1,3},{-2,2},{0,5},{2,-2}};
    }

}

class Model{
    DataSouce dataSouce;
    Model(DataSouce dataSource) {
        this.dataSouce = dataSource;
    }

    int[][] bestClosest() {
        int k =3;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> (a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]) );
        int[][] result = new int[k][2];
        int index= 0;

        for(int[] p: dataSouce.getAllData()) {
            queue.offer(p);
        }

        while(index < k) {
            result[index] = queue.poll();
            index++;
        }


        return result;
    }
}

public class Step09Kclosest {
    public static void main(String[] args) {
        Model model =  new Model(new DataSouce());
        int[][] result = model.bestClosest();

        for(int[] r: result) {
            System.out.println(r[0] + "/"+ r[1]);
        }


    }
}
