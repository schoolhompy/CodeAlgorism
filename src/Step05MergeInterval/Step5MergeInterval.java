package Step05MergeInterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * 4.미팅룸과 비슷하지만 ArrayList 를 이용해서 타이테이블을 다시 구성하는것
 * 시작시간이 기준이므로 시작시간을 정렬하고 for 문에서 이전값과 비교해서 결과list에 재구성
 * 겹쳐지는 시간으  하나로 합치기 (알바생이 카운터도지키면서, 여러가지 일한거에 대해 중복시간으로 겹쳤을때 시간처리)
 *
 * 응용예제 [알바생의 근무시간 정리하기],
 */

class TimeSchedule {
    int startTime;
    int endTime;
    TimeSchedule (int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class DataSource1 implements Repositry {
    @Override
    public List<TimeSchedule> getAllData() {
        List<TimeSchedule> timeSchedules = new ArrayList<>();
        timeSchedules.add(new TimeSchedule(1,3));
        timeSchedules.add(new TimeSchedule(8,10));
        timeSchedules.add(new TimeSchedule(2,6));
        timeSchedules.add(new TimeSchedule(15,18));

        return timeSchedules;
    }
}


class DataSource2 implements Repositry {
    @Override
    public List<TimeSchedule> getAllData() {
        List<TimeSchedule> timeSchedules = new ArrayList<>();
        timeSchedules.add(new TimeSchedule(1,2));
        timeSchedules.add(new TimeSchedule(5,10));
        timeSchedules.add(new TimeSchedule(3,6));
        timeSchedules.add(new TimeSchedule(15,18));

        return timeSchedules;
    }
}

interface Repositry {
    List<TimeSchedule> getAllData();
}

class Model {
    Repositry repositry;
    public void setRepositry(Repositry repositry){
        this.repositry = repositry;
    }

    public List<TimeSchedule> refinedTimeSchedule() {
        List<TimeSchedule> timeSchedules = repositry.getAllData();
        List<TimeSchedule> resultTImeSchedule = new ArrayList<TimeSchedule>();
        sort(timeSchedules);

        TimeSchedule beforeTimeschedule = timeSchedules.get(0);

        for(int i=1; i<timeSchedules.size(); i++) {
            TimeSchedule currentTimeSchedule = timeSchedules.get(i);
            if (beforeTimeschedule.endTime >= currentTimeSchedule.startTime) {
                beforeTimeschedule.endTime = Math.max(beforeTimeschedule.endTime, currentTimeSchedule.endTime);
            } else {
                resultTImeSchedule.add(beforeTimeschedule);
                beforeTimeschedule = currentTimeSchedule;
            }
        }

        if (!resultTImeSchedule.contains(beforeTimeschedule)) {
            resultTImeSchedule.add(beforeTimeschedule);
        }

        return resultTImeSchedule;
    }

    public void sort(List<TimeSchedule> timeSchedules){
        Collections.sort(timeSchedules, new Comparator<TimeSchedule>() {
            @Override
            public int compare(TimeSchedule o1, TimeSchedule o2) {
                return o1.startTime - o2.startTime;
            }
        });
    }

}



public class Step5MergeInterval {
    public static void main(String[] args) {
        DataSource1 dataSource1 = new DataSource1();
        Model model = new Model();
        model.setRepositry(dataSource1);
        model.refinedTimeSchedule().forEach(s -> System.out.println(s.startTime + "/"+ s.endTime));

        model.setRepositry(new DataSource2());
        model.refinedTimeSchedule().forEach(s -> System.out.println(s.startTime + "/"+ s.endTime));

    }
}
