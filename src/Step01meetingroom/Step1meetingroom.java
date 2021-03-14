package Step01meetingroom;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1.미팅룸 문제
 * 주어진 미팅시간간격에 다른 시간이 중복되는지 체크하는 것.
 * 일단 쇼트한다음, 쇼트된 값들을 기준으로 체크하되 2번부터 체크하면됨.
 * 응용예제 [열차예약시간, 미팅룸]
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
        MeetingTime meetingTime2 = new MeetingTime(10, 20);
        MeetingTime meetingTime3 = new MeetingTime(25, 27);
        return new MeetingTime[]{meetingTime1, meetingTime2, meetingTime3};
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

    ReserveState(DataRepositry dataRepositry) {
        if (dataRepositry != null) {
            this.dataRepositry = dataRepositry;
        }
    }

    public void sort() {
    }

    public boolean checkDuplication() {
        MeetingTime[] data = this.dataRepositry.datasource.getAllData();
        if (data == null) return false;

        Arrays.sort(data, new Comparator<MeetingTime>() {
            @Override
            public int compare(MeetingTime o1, MeetingTime o2) {
                return o1.startTime - o2.startTime;
            }
        });

        for (int i=1; i < data.length; i++) {
            if (data[i-1].endTime >= data[i].startTime) return false;
        }
        return true;
    }
}


public class Step1meetingroom {
    public static void main(String[] args) {
        DataRepositry dataRepositry = new DataRepositry();
        dataRepositry.setDataSource(new DataSourceCase1());
        ReserveState reserveState = new ReserveState(dataRepositry);
        reserveState.sort();
        System.out.println(reserveState.checkDuplication());

        //
        dataRepositry.setDataSource(new DataSourceCase2());
        reserveState = new ReserveState(dataRepositry);
        reserveState.sort();
        System.out.println(reserveState.checkDuplication());
    }

}