package Step27BFS_NumberOfIsland;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 27.BFS　탐색
 *
 * 방문한 요소는 반드시 체크를 할것
 *
 * 1. 0,0 에서 시작해서 1이라면 일단 섬이 있다고 카운팅하고 , queue에 현재 위치를 집어넣는다. 그리고 사방을 탐색한다.
 * 일단 좌우위아래 탐색하면서 1이 있는 애들은 0으로 탐색필요없음을 하고 난뒤  queue넣어서 계속 검색이 가능하도록 하고 ,  0이 만나면 아무것도 안한다.
 * {'0','0','0','0','1'},
 * {'0','0','0','0','0'},
 * {'0','0','0','0','0'},
 * {'0','0','0','1','1'},
 * 2. for i ,j 를 돌면서 0,4에 서는 다시 1을 만나니 카운팅을 하고 bfs 반복한다.
 * {'0','0','0','0','0'},
 * {'0','0','0','0','0'},
 * {'0','0','0','0','0'},
 * {'0','0','0','1','1'},
 * 3. for i ,j 를 돌면서 3,4에 서는 다시 1을 만나니 카운팅을 하고 bfs 반복한다.
 * {'0','0','0','0','0'},
 * {'0','0','0','0','0'},
 * {'0','0','0','0','0'},
 * {'0','0','0','0','0'},
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
                {'0','0','0','0','0'},
                {'0','0','0','1','1'},
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

        int result = 0;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j] == '1') {
                    result++;
                    bfs(data, i, j);
                }
            }
        }

        return result;
    }

    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    private void bfs(char[][] data, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});


        while(!queue.isEmpty()) {
            int size = queue.size();
            int[] point = queue.poll();
            for(int i=0; i<size; i++) {
                for(int[] dir:dirs) {
                    int x1 = point[0]+dir[0];
                    int y1 = point[1]+dir[1];
                    if(x1>=0 && y1>=0 && x1<data.length && y1<data[0].length && data[x1][y1] =='1') {
                        data[x1][y1] = '0';
                        queue.offer(new int[]{x1, y1});
                    }
                }
            }
        }
    }
}


public class Step27BFS_NumberOfIsland {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.numberOfIspland());
    }
}
