package Step12MaxinumSubarrayContinues;


/**
 * 12.연속된 숫자가 함이 가장 클때의 구간과 그 수
 * 논리적사고가 필요한 부분이다.
 * 연속된 숫자를 반복하면서 계속 더했을때 가장 큰 단위의 수가 나오는 연속된 구간을 찾아야한다.
 *      연속합     최고수  Max(연속합, 최고값)
 * -2   -2       -2    <=Max(-2,-2)
 * 1    -2+1=-1  1     <=Max(1,1)
 * -3   -3+1=-2  -2    <=Max(-2,1)
 * 4    4-2=2   4      <=Max(2,4)
 * -1   -1+4=3   4     <=Max(3,4)
 * 2    2+3=5   5      <=Max(5,4)
 * 1    1+5=6   6      <=Max(6,5)
 * -5   -5+6=1  6      <=Max(1,6)
 * 4    4+1=5   6      <=Max(5,6)
 *
 * 응용예제 [주가가 올라간 최고치]
 */

class DataSource {
    int[] getAllData() {
        return new int[]{-2,1,-3,4,-1,2,1,-5,4};
    }
}

class Model {
    DataSource dataSource;
    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    int getMaxSumOfSubarrays() {
        int[] data = this.dataSource.getAllData();

        int newSum = data[0];
        int max = data[0];

        for(int i=1; i<data.length; i++) {
            newSum = Math.max(data[i], newSum+data[i]);
            max = Math.max(newSum, max);
        }
        return max;
    }
}

public class Step12MaxinumSubarrayContinues {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.getMaxSumOfSubarrays());

    }
}
