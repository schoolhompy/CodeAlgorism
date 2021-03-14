package Step31MaxAreaOfIsland;


/**
 * 31.DFS　깉이탐색
 *
 * 방문한 요소는 반드시 체크를 할것
 *
 * 1. 0,0 에서 시작해서 1이라면 일단 섬이 있다고 카운팅하고 , 앞뒤위아래녀셕들도 재귀하면서 연결된 애들은 X 를 칠한다.
 * {'X','X','X','0','1'},
 * {'X','X','0','0','0'},
 * {'X','0','0','0','1'},
 * {'X','X','0','0','1'},
 * {'0','0','0','0','1'},
 * 1번영역은 area 가 0에서 시작해서 dfs가 1을 만날때마다  area 가 추가되고 반환한 area는 누적된다. 8 이된다.
 * 2. for i ,j 를 돌면서 0,4에 서는 다시 1을 만나니 카운팅을 하고 또 반복한다.
 * {'X','X','X','0','x'},
 * {'X','X','0','0','0'},
 * {'X','0','0','0','1'},
 * {'X','X','0','0','1'},
 * {'0','0','0','0','1'},
 * 2번영역은 area 가  1 이되지만 max에의해 max(1,8) =8이된다.
 * 3. for i ,j 를 돌면서 2,4에 서는 다시 1을 만나니 카운팅을 하고 또 반복한다.
 * {'X','X','X','0','x'},
 * {'X','X','0','0','0'},
 * {'X','0','0','0','1'},
 * {'X','X','0','0','1'},
 * {'0','0','0','0','1'},
 * 2번영역은 area 가  4 이되지만 max에의해 max(4,8) =8이된다.
 * 섬은 3개가 된다. 최대영역은 8이다.
 *
 *
 * 응용예제 [가장큰 섬찾기, 오역구역카운팅하기]
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

        int maxResult =0;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j] == '1') {
                    int area = dfs(data, i, j, 0);
                    System.out.println("area"+area);
                    maxResult = Math.max(maxResult, area);
                }
            }
        }

        return maxResult;
    }

    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private int dfs(char[][] data, int i, int j, int area ) {
        int m = data.length;
        int n = data[0].length;

        if(i<0||i>=m||j<0||j>=n||data[i][j] != '1') return area;
        data[i][j] ='0';
        area++;

        for(int[] dir:dirs) {
            area = dfs(data, i+dir[0], j+dir[1], area);
        }
        return area;
    }
}

public class Step31MaxAreaOfIsland {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.numberOfIspland());
    }
}

