package Step40ClimbingStairs;


/**
 * 40.다이나믹 프로그램 예제 - 기억 프로그램 방식
 *
 *  계단오르기도 3번쨰 계단부터는 이전 계단두개의 합이 총 경우의 수가 된다.

 *
 */

class Model {
    int solve(int stairs) {
        int[] dp = new int[stairs+1];
        if(stairs ==1) return 1;
        if(stairs ==2) return 2;

        dp[0]=0;
        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=stairs;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[stairs];
    }
}

public class Step40ClimbingStaris {
    public static void main(String[] args) {

    }
}
