package Step41LogestIncreasingSubsequence;

import java.util.Arrays;

/**
 * 41.가장 길게 증가된 순차열
 *
 *  1,2,3,2,5,2,6,10,4,12 에서
 *  1,2,3,2,4,2,5,6, 2, 7 일떄
 *  1->2->3->5->6-10-12 계속증가된 최고의 길이는 7개이다.
 *  1->2->3->4 는 4개밖에 없으므로 탈락
 *
 *  dp 로 푼다.
 *
 */
class DataSource {
    int[] getAllData(){
        return new int[]{
            1,2,3,2,5,2,6,10,4,12
        };
    }
}

class Model {
    private final DataSource dataSource;

    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    int longestIncreasingSubssequnce() {
        //input
        int[] data = this.dataSource.getAllData();

        //output
        int result = -1;

        //process
        int[] dp= new int[data.length];
        Arrays.fill(dp,1);

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < i; j++) {

                if (data[j] < data[i]) {
                    dp[i] = Math.max(dp[j] +1, dp[i]);

                }
            }
            result = Math.max(result, dp[i]);
        }


        return result;
    }
}

public class Step41LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.longestIncreasingSubssequnce());
    }
}
