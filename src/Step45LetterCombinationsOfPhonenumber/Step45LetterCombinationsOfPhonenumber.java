package Step45LetterCombinationsOfPhonenumber;

import java.util.ArrayList;
import java.util.List;

/**
 * 4４.subsets 주어진 문자열이 가지는 하위 조합수
 *
 *
 *
 */
class DataSource {
    String[] getAllData() {
        return new String[] {
                "", "", "adc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
    }
}


class Model {
    private final DataSource dataSource;

    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    List<String> letterCombinationsOfPhoneNumber(String whichDigit) {
        //input
        String[] data = this.dataSource.getAllData();

        //result
        List<String> result = new ArrayList<>();
        result.add("");

        for (int i = 0; i < whichDigit.length(); i++) {
            result = combine(result, data[whichDigit.charAt(i) - '0']);
        }


        return result;
    }

    private List<String> combine(List<String> firstList, String digit) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digit.length(); i++) {
            for (String firstStr : firstList) {
                result.add(firstStr + digit.charAt(i));
            }
        }
        return result;
    }

    private void dfs(List<List<Integer>> lists, List<Integer> cur, int[] nums, int start) {
        List<Integer> list = new ArrayList<>(cur);
        lists.add(list);
        System.out.println(lists);

        for(int i=start; i< nums.length; i++) {
            cur.add(nums[i]);
            dfs(lists, cur, nums, i+1);
            cur.remove(cur.size()-1);
        }
    }
}
public class Step45LetterCombinationsOfPhonenumber {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.letterCombinationsOfPhoneNumber("23"));
    }
}
