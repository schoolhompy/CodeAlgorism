package Step33WordSearchDFS;
/**
 * 33.DFS 로 제안된 문자열과 같은 연결문자 찾기
 *
 * 그리드데이터에서 제안된 문자열과 같은 순서의 문자열이 있는지 체크.
 * 조건은 현재 수행중인 xy 위치를 true로 해놓아야 상하좌욱검색때 현재위치를 중복검사하지 않게 된다. 또한 제안된 문자중 그 다음 문자가 시작되면 false 로 돌려
 * 놓아야 제안된 두번쨰 글자부터 연결되어 이쓴지 판단할수 있다.
 *
 * 1.제안된 BCCED중 B 문자를 기준으로 A-B-S , B-C-F, S-F-A, 순으로 검색하되 제안된 현재 한글자와 매치안되는 것들은 바로 무시해서 B-C 에서 게속진행한다.
 * 2.B-C에서 C의상하좌우 C-D-C 를 검색해서 C-C 를 찾으면 밑의 C가 C-C-E를 찾고 C-E를 찾았으니, E-D-E 를 찾는데, B-C-C-E-D 로 true값이 타고 올라가서
 * 맨위(현재 방문중인 좌표 xy)까지 true를 전달하여 for 문을 빠져나오게 된다.
 * 3.dfs로 부터 true가 오는 순간 wordsearch함수는 true를 리턴하여 이하 for를 돌지않게 한다.
 *
 */

class DataSource {
    char[][] getAllDatas() {
        return new char[][]{
                {'A', 'B', 'C', 'D' },
                {'S', 'F', 'C', 'C' },
                {'A', 'D', 'E', 'E' }
        };
    }
}

class Model {
    private final DataSource dataSource;

    Model(DataSource dataSource ) {
        this.dataSource = dataSource;
    }

    int m =0, n=0;
    boolean wordSearch(String searchWord) {
        char[][] data = this.dataSource.getAllDatas();

        m = data.length;
        n = data[0].length;

        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(dfs(data, visited, i, j, 0, searchWord)) return true;

            }
        }

        return false;

    }

    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private boolean dfs(char[][] data, boolean[][] visited, int x, int y, int start, String searchWord) {
        if(start == searchWord.length()) return true;
        if(x<0||x>=m ||y<0||y>=n) return false;
        if(visited[x][y]) return false;
        if(data[x][y] != searchWord.charAt(start)) return false;

        visited[x][y]= true;
        for(int[] dir: dirs) {
            int dx = x+dir[0];
            int dy = y+dir[1];
            if(dfs(data, visited, dx, dy, start+1, searchWord)){
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
}

public class Step33WordSearch {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.wordSearch("BCCED"));
    }
}
