package Step36Maze1DFS;


/**
 * 37.DFS 미로찾기 !
 *
 * 벽에 막힐때 마다 시작위치를 바꾸어 탐색하여 원하는 지점에 도달할수 있는지를 체크함.
 * 이동하여 벽에 도달하면 이미 지나온 곳을 제외한 곳을 탐색
 * 시작점은 바뀌지만 끝지점은 계속 들고다니면 체크를 함.
 */


class DataSource {
    int[][] getAllData() {
        return new int[][] {
                {1,0,1,0,0},
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

        return dfs(maze, start, dest, visited);


    }

    private boolean dfs(int[][] maze, int[] start, int[] dest, boolean[][] visited) {
        if (start[0] <0 || start[0] >=m ||start[1] <0 ||start[1] >=n||visited[start[0]][start[1]]) return false;

        visited[start[0]][start[1]] = true;
        if(start[0]==dest[0] && start[1]==dest[1]) return true;

            for(int[] dir : dirs) {
                int x = start[0];
                int y = start[1];
                System.out.println("ReStart ->" + x + ":"+y + "");

                while(x>=0 && x<m && y>=0 && y<n && maze[x][y]!=1) {
                    x+=dir[0];
                    y+=dir[1];
                    System.out.println("-->ReSearch ->" + x + ":"+y + "");
                }
                x-=dir[0];
                y-=dir[1];

                System.out.println("->ReRevert ->" + x + ":"+y + "");
                if(dfs(maze, new int[]{x,y}, dest, visited)) return true;

                //printGamer(maze, visited);
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
public class Step37Maze1DFS {
    public static void main(String[] args) {

        Model model = new Model(new DataSource());
        System.out.println(model.Maze1(new int[]{0,4},new int[]{4,4}));
    }
}
