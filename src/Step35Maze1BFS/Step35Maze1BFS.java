package Step35Maze1BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 35.BFS 미로찾기 !
 *
 * 큐로 탐색하여 원하는 지점에 도달할수 있는지를 체크함.
 * 단, 한쪽 방향을 탑색하다가 막힐때 까지 반복해서 통화 실필요가 있다.
 * 벽을 만나거나 갈수없는곳을 만나면 그것을 현재최종위치로 해서 큐에 집에 넣는다. 따라서 중간 위치는 탐색할수 없다.
 */


class DataSource {
    int[][] getAllData() {
        return new int[][] {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0},
        };
    }
}

class Model {

    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int m,n;
    
    private final DataSource dataSource;

    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    boolean Maze1(int[] start, int[] dest) {
        int[][] maze = this.dataSource.getAllData();

        m=maze.length;
        n=maze[0].length;

        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});

        while(!queue.isEmpty()) {
            int[] p = queue.poll();
            for(int[] dir : dirs) {
                System.out.println("Start ->" + p[0] + ":"+p[1] + "");
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];

                System.out.println("->Nexxt ->" + x + ":"+y + "");
                while(x>=0 && x<m && y>=0 && y<n && maze[x][y]==0) {
                    x+=dir[0];
                    y+=dir[1];
                    System.out.println("-->Search ->" + x + ":"+y + "");
                }
                x-=dir[0];
                y-=dir[1];

                System.out.println("->Revert ->" + x + ":"+y + "");
                if(visited[x][y]) continue;
                visited[x][y] = true;

                //printGamer(maze, visited);


                if(x==dest[0] && y==dest[1]) return true;
                queue.offer(new int[]{x,y});
            }
        }
        return false;
        
    }

    private void printGamer(int[][] maze, boolean[][] visited) {
        System.out.println("+==================");
        String h = "";
        for (int i = 0; i <m; i++) {
            for (int j = 0; j <n; j++) {
                h = visited[i][j] ? "O":".";
                h = maze[i][j] ==1 ? "B":h;
                System.out.print( h+"|");
            }
            System.out.println();
        }
    }
}
public class Step35Maze1BFS {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.Maze1(new int[]{0,4},new int[]{4,4}));
    }
}
