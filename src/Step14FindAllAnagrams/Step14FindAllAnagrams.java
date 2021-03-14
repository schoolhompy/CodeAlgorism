package Step14FindAllAnagrams;

import java.util.ArrayList;
import java.util.List;

/**
 * 14.문자열의 특정그룹의 문자세트가 들어가 있는지 확인
 *
 * 응용예제 [아나그램]
 */

class DataSource {
    String getAllData() {
        return "BACDGABCDA";
    }
}

class Model {
    String pattern = "ABCD";
    DataSource dataSource;
    Model (DataSource dataSource) {
        this.dataSource = dataSource;
    }

    List<Integer> findAllAnagramss() {
        List<Integer> result = new ArrayList<>();
        int[] patAscii =new int[256];
        for(int i=0; i<pattern.length(); i++) {
            // [0,0,0,0,1,1,1,0,0,0,0] CharAt에 해당하는 위치만 1로 만들어 비교를 변하게 함.
            patAscii[pattern.charAt(i)]++;
        }

        for(int i=0; i<dataSource.getAllData().length()-pattern.length()+1; i++) {
            int[] targetAscii= new int[256];
            for(int j=0; j<pattern.length();j++) {
                // [0,0,0,0,1,1,1,0,0,0,0] 현재 지정된 4개의 문자들에 매치된 ascii 코드번호에 1을 입력
                targetAscii[dataSource.getAllData().charAt(i+j)]++;
            }

            if (checkMatched(patAscii, targetAscii)) {
                result.add(i);
            }
        }

        return result;
    }

    boolean checkMatched(int[]patAscii, int[] targetAscii) {
        for(int i=0; i<patAscii.length; i++) {
            if(patAscii[i] != targetAscii[i]) {
                return false;
            }
        }
        return true;
    }
}


public class Step14FindAllAnagrams {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        for(int v: model.findAllAnagramss()) {
            System.out.println(v);
        }
    }
}
