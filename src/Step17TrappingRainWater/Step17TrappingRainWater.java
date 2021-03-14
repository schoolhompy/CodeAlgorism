package Step17TrappingRainWater;

/**
 * 17.이 빠진 블록 채워넣기
 * 난이도가 꽤있다. 현재 블록이 기준블록일떄 바로 옆의 블록이 비워져 있으면 현재블록높이만큼 채우는 로직.
 * 단, 단순히 현재블록과 다음블록만 비교하면 계속높아질뿐이니까, 다다음 블록의 상태도 체크해서 채울 블록의 높이를 결정한다.
 * 예로 현재2블록높이고, 다음 블록이 1블록, 다다음 블록이 3블록, 다다다음블록이 2블록일떄, 다다다음 블록이 2블록일떄
 * 1블록은 채우돼 3블록다음의 블록은 채울수 없는구조다. 수족관 이라 생각하면됨.
 * 따라서 최고수위를 채우는게 아니라 최소수위를 채우는 것으로 생각하면된다.
 * 왼쪽->오른쪽 방향으로의 최대높이블록의 변화를 체크하고, 오른쪽->왼쪽 방향으로의 최대높이 블록의 변화를 체크해서
 * 같은 지점에서 최소높이블록을 결정하면 된다.Math.Min
 * 그리고 원래 그곳에 있던 블록개수를 빼면 채워야할 블록개수가 나온다.
 *
 * 응용예제 [비공간 채우기]
 */

class DataSource {

    int[] getAllData() {
        return new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    }
}

class Model {
    private final DataSource dataSoure;

    Model (DataSource dataSource) {
        this.dataSoure = dataSource;
    }

    int getTrappingRainWater() {
        //input
        int[] data = this.dataSoure.getAllData();
        //output
        int result =0;
        //process
        int[] leftWall = new int[data.length];
        int[] rightWall = new int[data.length];

        int nowMaxWall = data[0];
        leftWall[0] = nowMaxWall;
        for(int i=1; i<data.length; i++) {
            if (nowMaxWall < data[i] ) {
                nowMaxWall = data[i];
            }
            leftWall[i] = nowMaxWall;
        }

        nowMaxWall = data[data.length -1];
        rightWall[data.length -1] = nowMaxWall;
        for(int i=data.length -2; i>=0; i--) {
            if (nowMaxWall < data[i] ) {
                nowMaxWall = data[i];
            }
            rightWall[i] = nowMaxWall;
        }

        for(int i=0; i<data.length; i++) {
            result += Math.min(leftWall[i], rightWall[i]) -data[i];
        }

        return result;
    }
}

public class Step17TrappingRainWater {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.getTrappingRainWater());
    }
}
