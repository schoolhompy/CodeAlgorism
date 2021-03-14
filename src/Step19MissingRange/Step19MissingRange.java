package Step19MissingRange;

import java.util.ArrayList;
import java.util.List;

/**
 * 19.빠진 구간 찾기
 *
 * 응용예제 [결석자찾기]
 */


class DataSource {
    int[] getAllData() {
        return new int[] {2,3,5,50,75};
    }
}

class Model {
    private final DataSource dataSource;
    private int areaStart = 0;
    private int areaEnd = 99;

    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    void setRange(int start, int end ) {
        this.areaStart = start;
        this.areaEnd = end;
    }

    List<String> missingRange() {
        int[] data = this.dataSource.getAllData();
        List<String> result = new ArrayList<>();

        if (data[0] < areaStart) {
            result.add(makeRange(areaStart, data[0]-1 ));
        }

        for(int i=1; i<data.length-1; i++) {
            if (data[i] != data[i+1] && data[i]+1 < data[i+1]) {
                result.add(makeRange(data[i]+1, data[i+1]-1 ));
            }
        }

        if (data[data.length-1] < areaEnd) {
            result.add(makeRange(data[data.length-1]+1, areaEnd));
        }

        return result;
    }

    private String makeRange(int rangeStart, int rangeEnd) {
        return (rangeStart==rangeEnd) ? String.valueOf(rangeStart) : rangeStart + "->" + rangeEnd;

    }
}

public class Step19MissingRange {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.missingRange());
    }
}
