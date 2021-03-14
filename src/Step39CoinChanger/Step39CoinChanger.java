package Step39CoinChanger;


import java.util.Arrays;

/**
 * 39.다이나믹 프로그램 예제 - 기억 프로그램 방식
 *
 *  한번계산한 결과는 일단 기억해 두고 빠르게 꺼내 사용하도록 하는 일종의 팁 프로그램방식
 *  kanpsack 문제 / 제한된 가방에 가장 값어치있게 물건을 담는 방법
 *  결국 하나의 문제에 대한 해결책이 있는데, 여러가지 다이나믹한 경우의 수르 고려할때
 *  좀더 좋은 결과를 내가 위한 과정을 도출해 내는거다.
 *
 *  주로 제한된자료(동전종류)/최상의결과 를 알았을때 가능한경우의 수를 맞추는 거다.
 *  상향식 : for(int i =0; i<=n; i++)
 *  하향식 : for(int i =0; i>1; i--) 주로 사용.
 *
 *
 */

class DataSource{
    int[] getAllData(){
        return new int[]{
                1,2,5
        };
    }
}

class  Model {
    private final DataSource dataSource;

    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    int conChange(int amount){
        //input
        int[] data = this.dataSource.getAllData();

        int max = amount +1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            System.out.println("-----" + i + "-------");
            for (int j = 0; j < data.length; j++) {
                System.out.println(" -----" + j + "-" + data[j] +"-------");
                if(i >= data[j]) {
                    System.out.println("  -----" + data[j] + ","+ dp[i] + ","+ (dp[i - data[j]] +1));
                    dp[i] = Math.min(dp[i], dp[i - data[j]] +1);
                    System.out.println("   -----" + dp[i] + "-------");
                }
            }
        }
        return dp [amount] > amount ? -1: dp[amount];
    }

 }

public class Step39CoinChanger {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.conChange(11));
    }
}
