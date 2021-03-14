package Step16GroupAnagrams;

import java.util.*;

/**
 * 16.어구전철(말바꾸기) 된 단어 찾기
 *
 * 응용예제 [같은 단어를 사용한 문장들 찾기]
 */

class DataSource {
    String[] getAllData(){
        return new String[]{
            "eat", "tea", "tan", "ate", "nat","bat"
        };
    }
}

class Model {
    DataSource dataSource;
    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    List<List<String>> getGroupAnagrams() {
        //input
        String[] data = this.dataSource.getAllData();
        //output
        List<List<String>> result = new ArrayList<>();
        //process
        Map<String,List<String>> map = new HashMap<>();
        for(String s:data) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key,list);
            }
        }
        result.addAll(map.values());
        return result;
    }

}

public class Step16GroupAnagrams {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.getGroupAnagrams());
    }
}
