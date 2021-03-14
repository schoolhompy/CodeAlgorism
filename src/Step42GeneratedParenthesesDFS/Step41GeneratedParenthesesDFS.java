package Step42GeneratedParenthesesDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 41.가장 길게 증가된 순차열
 *
 *  DFS로 이진트리의 최하단계0까지 단계를 빼기하여 내려갔을때
 *  좌측을 ( 로 우측을 ) 로 하여 중간에 만나는 트리들과 조합을 해보면 여러가지의 경우 가 나온다.
 *
 *  dp 로 푼다.
 *
 */
class Model {
    List<String> generateParenthees_dfs(int n) {
        //output
        List<String> result = new ArrayList<>();

        //process
        dfs(result, "", n, n, "");

        //result
        return  result;
    }

    int count =0;
    private void dfs(List<String> result, String str, int left, int right, String str1) {
        count ++;
        System.out.println("str :" + str + " left:" + left + " right:" + right + " count:" + count + "str1:" + str1);

        if (left <0 || left > right)  return;

        if (left==0 && right==0) {
            result.add(str);
            return;
        }
        dfs(result, str+"(" , left-1, right, str1+"+");
        dfs(result, str+")" , left, right-1, str1+"-");
    }
}

public class Step41GeneratedParenthesesDFS {
    public static void main(String[] args) {
        Model model  = new Model();
        System.out.println(model.generateParenthees_dfs(1));
    }
}
