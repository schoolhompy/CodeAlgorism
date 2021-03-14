package Step18ThLargestElement;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 18.n번쨰 큰수 구하기
 * 단순 숫자 배열일때는 sort를
 * 객체일떄는 priorityqueue 를 사용하는게 좋다.
 *
 * 응용예제 [n번째 등수]
 */

class DataSource {
    int[] getAllData() {
        return new int[] { 3,2,1,5,6,4};
    }
}

class Model {
    private final DataSource dataSource;

    private int whichTopLevel = 2;

    public void setWhichTopLevel(int whichTopLevel) {
        this.whichTopLevel = whichTopLevel;
    }

    Model(DataSource dataSource){
        this.dataSource = dataSource;
    }


    int getThLargestElementWithSort() {
        int[] data = this.dataSource.getAllData();

        Arrays.sort(data);
        return data[data.length - this.whichTopLevel];
    }


    int getThLargestElementWithQueue() {
        int[] data = this.dataSource.getAllData();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> a-b);
        for(int v:data) {
            priorityQueue.offer(v);
            if (priorityQueue.size() > this.whichTopLevel) priorityQueue.poll();
        }


        return priorityQueue.peek();
    }
}

public class Step18ThLargestElement {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.getThLargestElementWithSort());
        System.out.println(model.getThLargestElementWithQueue());
    }
}
