package Step04DailyTemperature;

import java.util.Stack;

/**
 * 4.스택을 이용
 * 정해진 데이터를 앞 또는 뒤로 옮기는것.
 * i    --> 0,1,2,3,4,5,6,7,8
 * data --> 73,74,75,71,69,72,76,73
 * stack -> 0,1,2,3,4,5,6,7,8
 * 처리    > (74, 1) - (73,0) = index 1 > 0 스택에서 제거
 *        > (75, 2) - (74,1) = index 1 > 1 스택에서 제거
 *        > Stack (75, 2),(71, 3),(69, 4),
 *        > (72, 6) - (69,4) = index 2 > 4 스택에서 제거
 *        > (76, 7) - (71,3) = index 4 > 3 스택에서 제거
 *        > Stack (76, 7)
 *        > Stack (73, 8)
 *
 * [_74(i1)_] [_75(i2)_] [_72(i5)_] [_76(i6)_]
 *---------------------------------------------
 *                       [_69(i4)_]
 *                       [*71(i3)*]
 * [*73(i0)*] [*74(i1)*] [_75(i2)_] [*75(i2)*]
 *---------------------------------------------
 * [i1-i0=1]  [i2-i1=1]  [i5-i3=2] [i6-i2=4]
 *
 *
 * 응용예제 [특정금액을 모으기위한 평균일수, 가장긴 시간이 걸린 시작된 날짜와 끝날짜, 2일걸려야하는 일만 추려내기],
 */
class DataSource1 implements Repositry {
    public int[] getAllData() {
        return new int[]{73,74,75,71,69,72,76,73};
    }
}

class DataSource2 implements Repositry {
    public int[] getAllData() {
        return new int[]{20,60,99,0,6,73,4,81};
    }
}

interface Repositry {
    int[] getAllData();
}

class Model {

    Repositry repositry;
    public void setDatasource(Repositry datasource) {
        this.repositry = datasource;
    }

    public int[] resultDailyTemperature() {
        int[] dataSoure = this.repositry.getAllData();
        Stack<Integer> resultStack = new Stack<>();
        int[] result = new int[dataSoure.length];

        for(int i=0; i<dataSoure.length; i++) {
            while(!resultStack.isEmpty() && dataSoure[resultStack.peek()] < dataSoure[i]) {
                int index = resultStack.pop();
                result[index] = i - index;
            }
            resultStack.push(i);
        }

        return result;
    }
}

public class Step4DailyTemperature {
    public static void main(String[] args) {
        DataSource1 dataSource1 = new DataSource1();
        Model model = new Model();
        model.setDatasource(dataSource1);
        int[] result = model.resultDailyTemperature();
        for (int j : result) {
            System.out.println(j);
        }
    }
}
