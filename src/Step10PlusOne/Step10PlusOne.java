package Step10PlusOne;

/**
 * 10.디지털 카운터 자리수 올리기
 * 디지털 카운터처럼 끝의자리수가 올라가면 맨앞자리가 한자리 늘어나도록
 * % 나머지 연산자로 1을더한후가 두자리 수인지 판단
 * carry 가 0일때 까지 올리다가 더이상 자리수를 올릴필요가 없으면 그냥 현재 숫자에 1만 더하고 끝.
 *
 * 응용예제 [디자털 카운터 ]
 */

interface DataSource {
    int[] getAllData();
}

class DataSource1 implements DataSource {
    @Override
    public int[] getAllData() {
        return new int[]{1,2,3};
    }
}

class DataSource2 implements DataSource {
    @Override
    public int[] getAllData() {
        return new int[]{9,0,9};
    }
}

class Model {

    DataSource dataSource;
    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    int[] plugOne() {
        int[] datas = this.dataSource.getAllData();
        int currentIndexPos = datas.length -1;
        int carry = 1;

        while(currentIndexPos >= 0 && carry >0 ) {
            datas[currentIndexPos] = (datas[currentIndexPos] +1) % 10; //10 -> 0, 1..9->1..9
            if(datas[currentIndexPos] ==0) {
                carry =1;
            }else {
                carry =0;
            }
            --currentIndexPos;
        }

        if (carry == 1) {
            datas = new int[datas.length+1];
            datas[0] = 1;
        }
        return datas;
    }
}

public class Step10PlusOne {
    public static void main(String[] args) {
        DataSource1 dataSource = new DataSource1();
        Model model = new Model(dataSource);

        for(int v:model.plugOne()) {
            System.out.println(v);
        }

        model.setDataSource(new DataSource2());
        for(int v:model.plugOne()) {
            System.out.println(v);
        }
    }
}
