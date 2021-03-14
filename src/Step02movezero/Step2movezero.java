package Step02movezero;

/**
 * 2.0을 뒤로 옮기는 문제, 또는 0을 앞으로 옮기는 문
 * 정해진 데이터를 앞 또는 뒤로 옮기는것.
 * i    --> 0,1,2,3,4
 * data --> 0,b,0,d,c
 * index ->  ,0, ,1,2
 * result-> b,d,c,*,*
 * 역순일때.
 * i    --> 0,1,2,3,4
 * data --> 0,b,0,d,c
 * index ->  ,2, ,3,4 (index는 total data - index해서 역탐색)
 * result-> *,*,b,d,c
 *
 * 응용예제 [특정한사람만 앞/뒤에 세우기]
 */


interface DataSource {
    int[] getAllData();
}

class DataCase1 implements DataSource {
    @Override
    public int[] getAllData() {
        return new int[]{ 1, 3, 2, 0, 8, 5};
    }
}

class DataCase2 implements DataSource {
    @Override
    public int[] getAllData() {
        return new int[]{ 11, 12, 13, 0, 15, 0};
    }
}
class Model {
    private DataSource dataSource; // not used
    private int[] cachedData;
    private int target = 0;

    public void setTarget(int target) {
        this.target = target;
    }

    public void setDataSource(DataSource dataSource) {
        if (dataSource != null) {
            this.dataSource = dataSource;
            this.cachedData = this.dataSource.getAllData();
        }
    }

    public int[] moveToTailZero() {
        int currentIndex = 0;
        for (int i=0; i < this.cachedData.length; i++) {
            if (this.cachedData[i] != this.target) {
                this.cachedData[currentIndex] = this.cachedData[i];
                currentIndex++;
            }
        }

        if (currentIndex != this.cachedData.length) {
            while(currentIndex<this.cachedData.length) {
                this.cachedData[currentIndex] = this.target;
                currentIndex++;
            }
        }

        return this.cachedData;
    }

    public int[] moveToHeadZero() {
        int total = this.cachedData.length-1;
        int currentIndex = total;

        for (int i=total; i >= 0; i--) {
            if (this.cachedData[i] != this.target) {
                this.cachedData[currentIndex] = this.cachedData[i];
                currentIndex--;
            }
        }

        while(currentIndex >= 0) {
            this.cachedData[currentIndex] = this.target;
            currentIndex--;
        }

        return this.cachedData;
    }
}

public class Step2movezero {
    public static void main(String[] args) {
        Model model = new Model();
        //0이 있을때
        model.setTarget(0);
        model.setDataSource(new DataCase1());
        int[] result;
        result = model.moveToHeadZero();
        //result = model.moveToTailZero();

        for (int k : result) {
            System.out.println(k);
        }

        //0이 한개도없을때
        model.setTarget(0);
        model.setDataSource(new DataCase2());
        result = model.moveToHeadZero();
        //  result = model.moveToTailZero();

        for (int j : result) {
            System.out.println(j);
        }

    }
}
