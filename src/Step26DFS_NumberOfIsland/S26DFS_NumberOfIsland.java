package Step26DFS_NumberOfIsland;


import java.util.Arrays;

/**
 * 26.DFS　깉이탐색
 *
 * 방문한 요소는 반드시 체크를 할것
 *
 * 1. 0,0 에서 시작해서 1이라면 일단 섬이 있다고 카운팅하고 , 앞뒤위아래녀셕들도 재귀하면서 연결된 애들은 X 를 칠한다.
 * {'X','X','X','0','1'},
 * {'X','X','0','0','0'},
 * {'X','X','0','0','1'},
 * {'X','X','0','0','1'},
 * {'0','0','0','0','1'},
 * 2. for i ,j 를 돌면서 0,4에 서는 다시 1을 만나니 카운팅을 하고 또 반복한다.
 * {'X','X','X','0','x'},
 * {'X','X','0','0','0'},
 * {'X','X','0','0','1'},
 * {'X','X','0','0','1'},
 * {'0','0','0','0','1'},
 * 3. for i ,j 를 돌면서 2,4에 서는 다시 1을 만나니 카운팅을 하고 또 반복한다.
 * {'X','X','X','0','x'},
 * {'X','X','0','0','0'},
 * {'X','X','0','0','1'},
 * {'X','X','0','0','1'},
 * {'0','0','0','0','1'},
 * 3개가 된다.
 *
 *
 * 응용예제 [섬찾기, 오역구역카운팅하기]
 */


class DataSource {
    char[][] getAllData() {
        return new char[][] {
                {'1','1','1','0','1'},
                {'1','1','0','0','0'},
                {'1','0','1','0','1'},
                {'1','1','0','0','1'},
                {'0','0','0','0','1'},
        };
    }
}

class Model {
    private final DataSource database;

    Model(DataSource dataBase) {
        this.database = dataBase;
    }

    int numberOfIspland() {
        char[][] data = this.database.getAllData();

        int max =0;
        int result = 0;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j] == '1') {
                    result++;
                    dfs(data, i, j);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] data, int i, int j) {
        int m = data.length;
        int n = data[0].length;

        if(i<0||i>=m||j<0||j>=n||data[i][j] != '1') return;
        data[i][j] ='X';

        dfs(data, i-1 , j);
        dfs(data, i+1 , j);
        dfs(data, i , j-1);
        dfs(data, i , j+1);

        for (int i2 = 0; i2< data.length; i2++) {
            for (int j2 = 0; j2 < data[i2].length; j2++) {
                    System.out.print(data[i2][j2]);
            }
        }
    }
}

public class S26DFS_NumberOfIsland {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.numberOfIspland());
    }
}
