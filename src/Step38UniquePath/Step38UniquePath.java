package Step38UniquePath;

/**
 * 38.다이나믹 프로그램 예제
 *
 * 가로3,세로2의 형렬을 더하면 마지막 칸에는 3이 나온다. 새로운 셀은 이전셀의 결과들을 다시 합한거다.
 * 이게 다이나믹? 프로그램이란다. 재활용이란다. 그럼 리사이클이라고 부르지...
 * 1|1|1|
 * 1|2|3|
*/

class Model{
    int UniquePath(int m, int n) {
        //input
        Integer[][] map = new Integer[m][n];

        for (int i = 0; i < m ; i++) {
            map[i][0] = 1;
        }

        for (int i = 0; i < n ; i++) {
            map[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i][j-1] + map[i-1][j];
            }
        }

        return map[m-1][n-1];
    }
}

public class Step38UniquePath {
    public static void main(String[] args) {
        Model model = new Model();
        System.out.println(model.UniquePath(7,3) + "");
    }
}
