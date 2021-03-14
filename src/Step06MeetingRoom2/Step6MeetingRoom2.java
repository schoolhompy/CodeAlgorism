package Step06MeetingRoom2;

import java.util.*;

/**
 * 6.미팅룸 문제2
 * 여러개의 중복된 미팅룸의 시간들이 겹치지 않도록 방을 구성.
 * PriorityQueue로 MinHeap 자료구조, 이진트리구조(노드의 왼쪽은 부모보다 큰수, 오른쪽은 부모보다 작은수)를 사용
 * [0,30] [4,9] [5,15] [10,16] 일때
 * 첫번쨰방은 일단 필요. 두번째 시간부터 체크하면, 4-9사이는 일단 필요. 세번째는 4-9와 중복되니까 필요. 10-16은 4-9가 끝나면 그방을 쓰니까 불필요
 * PriorityQueue에 자료가 삽입되면 비교조건(a.endtime - b.endtime)에 의해 우선순위(부모노드가 될지)를 정하게 된다.
 * 1.[0,30] -> [0,30]
 * 2.[4,9] -> [4,9] [0,30]
 * 3.[5,15] -> [4,9] [0,30] [5,15]
 * 4.[10,16] -> [5,15] [0,30][10,16]  : peek한 최상위 [4,9]노드는 [10,16]과 시간이 중복되지않기 때문에 삭제되고, endtime 우선 순위에
 *   의해 [5,15]가 최우선노드가 됨.
 *
 * 응용예제 [미팅룸 개수구하기, 배송트럭개수 구하기, 놀이공원에서 최대이용가능 개수 구하기, 최대수강가능 강좌개수 구하기],
 *        [중복된 시간들 체크하기]
 */

//Entity
class MeetingTime {
    int startTime;
    int endTime;

    MeetingTime(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

interface DataSource {
    MeetingTime[] getAllData();
}

//User Data1
class DataSourceCase1 implements DataSource {
    public MeetingTime[] getAllData() {
        MeetingTime meetingTime1 = new MeetingTime(0, 30);
        MeetingTime meetingTime2 = new MeetingTime(4, 9);
        MeetingTime meetingTime3 = new MeetingTime(10, 16);
        MeetingTime meetingTime4 = new MeetingTime(5, 15);
        return new MeetingTime[]{meetingTime1, meetingTime2, meetingTime3, meetingTime4};
    }
}

//User Data2
class DataSourceCase2 implements DataSource {
    public MeetingTime[] getAllData() {
        MeetingTime meetingTime1 = new MeetingTime(0, 10);
        MeetingTime meetingTime2 = new MeetingTime(20, 30);
        return new MeetingTime[]{meetingTime1, meetingTime2};
    }
}


//repositry
class DataRepositry {
    DataSource datasource;
    public void setDataSource(DataSource datasource) {
        this.datasource = datasource;
    }
}

//Model BL
class ReserveState {
    DataRepositry dataRepositry;
    MeetingTime[] cachedData;

    ReserveState(DataRepositry dataRepositry) {
        if (dataRepositry != null) {
            this.dataRepositry = dataRepositry;
            this.cachedData = this.dataRepositry.datasource.getAllData();
        }
    }

    public int checkDuplication() {
        if (cachedData == null) return 0;
        Arrays.sort(cachedData, (MeetingTime o1, MeetingTime o2) -> o1.startTime - o2.startTime);
        Queue<MeetingTime> queue = new PriorityQueue<MeetingTime>((MeetingTime o1, MeetingTime o2) -> o1.endTime - o2.endTime);


        int result = 0;

        for (int i = 0; i < cachedData.length; i++) {
            while (!queue.isEmpty() && queue.peek().endTime <= cachedData[i].startTime) {
                queue.poll();
            }
            queue.offer(cachedData[i]);
            result = Math.max(result, queue.size());
        }
        return result;
    }
}
public class Step6MeetingRoom2 {
    public static void main(String[] args) {
        DataSourceCase1 dataSourceCase1 = new DataSourceCase1();
        DataRepositry dataRepositry = new DataRepositry();
        dataRepositry.setDataSource(dataSourceCase1);

        ReserveState reserveState = new ReserveState(dataRepositry);
        System.out.println(reserveState.checkDuplication());
    }
}
