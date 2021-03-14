package Step34RemoveInvalidParenthesesBFS;

import java.util.*;

/**
 * 34.BFS 로 제안된 문자열과 짝 맞추기
 *
 * 큐에 스트링을 넣어서 짝 체크해서 문제가 없다면 다음 큐로 이동해서 글자개수만큼 반복한다.
 * 1.큐에 원본 스트링을 넣고 정상체크해서 문제가 있으면
 * 2.문자열의  앞에서부터 하나씩 늘려가며 정상하고 큐에 넣는다.
 * 3.큐에 계속 들어가는 문자열들은 다시 정상체크를 해서 정상인 애들만 결과에 들어간다.
 *
 * (a)())() 잘못된 셋
 * 1. (a)를 처음 찾게된다. 정상이라서 결과에 자장.
 *  j    newStr      주의;substring(0,3) 은 1,2반환
 *  0 = " a)())()" -> '(' 일떄 0-0 과 1-마지막
 *       a 는 통과
 *  2 = "(a ())()" -> ')' 일떄 0-2 과 3-마지막 => 정상패턴
 *  3 = "(a) ))()" -> '(' 일떄 0-3 과 4-마지막
 *  4 = "(a)( )()" -> ')' 일떄 0-4 과 5-마지막 => 정상패턴
 *  5 = "(a)()) )" -> ')' 일떄 0-5 과 6-마지막
 *  6 = "(a)())( " -> ')' 일떄 0-6 과 7-마지막
 *
 *  다시 0,2,3,4,5,6을 큐에 넣고, 다시 문자별 정상체크를 한후 결과를 큐에 넣고
 *  다시 반복하는데, visited 에 이미 각 조합문자열이 다 들어가 있어서(예제의 문자열이 짧은 이유로)
 *  큐에 아무것도 추가 안하게 되어 맨처음 for에서 체크되었던 두개의 경우만 정상패턴으로 결과를 줌
 */

class DataSource {
    String getAllDatas() {
        return "(a)())()";
        };
    }


class Model {
    private final DataSource dataSource;

    Model(DataSource dataSource ) {
        this.dataSource = dataSource;
    }

    List<String> removaInvalidParentheses() {
        String data = this.dataSource.getAllDatas();

        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(data);
        visited.add(data);

        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String str = queue.poll();
                if(isValidBrace(str)) {
                    result.add(str);
                    found = true;
                }
                if(found) continue;
                for(int j=0; j < str.length(); j++) {
                    if(str.charAt(j)!='(' && str.charAt(j)!=')') continue;
                    String newStr = str.substring(0,j) + str.substring(j+1);
                    if(!visited.contains(newStr)) {
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
            }
        }
        return  result;
    }

    private boolean isValidBrace(String s) {
        int count =0;
        for(char c:s.toCharArray()) {
            if(c == '(') {
                count++;
            } else if (c==')'){
                count--;
                if (count<0) return  false;
            }
        }
        return count == 0;
    }
}
public class Step34RemoveInvalidParentheses {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        for(String s:model.removaInvalidParentheses()) {
            System.out.println(s);
        }
    }
}
