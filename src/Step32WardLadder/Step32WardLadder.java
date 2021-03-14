package Step32WardLadder;

import java.util.*;

/**
 * 32.워드사다리 깊이 구하기
 *
 * 방문한 요소는 반드시 체크를 할것
 *
 * 1.hit 를 입력받아 큐에 넣고 각각의 글자별로 a-z 를 돌려서 wordlist 에 매칭되는 단어가 있을때는 그걸반환받아 큐에 다시 넣고 깊이를 1더함
 * 2.다시 큐(hot 찾게됨)에들어있는 순서대로 , 1을 반복한다음 dot->hot,lot->dog,lot,hot....등등 큐에들어있는 3글자로 돌면서 cog가 나올때 까지 반복
 * 1개 3개 10개 33개 순으로 각 단계별 나오는 단어가 큐에 모두 중복포함해서 들어간다.
 *
 */

class DataSource {
    String[] getAllDatas() {
        return new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
    }
}

class Model {
    private final DataSource dataSource;

    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    int wordLaddar(String startWord, String endWord) {
        List<String> wordList = Arrays.asList(this.dataSource.getAllDatas());

        Queue<String> queue = new LinkedList<>();
        queue.offer(startWord);

        Set<String> wantSearch = new HashSet<>(wordList);
        wantSearch.add(endWord);
        wantSearch.remove(startWord);
        int level = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String str = queue.poll();
                if(str.equals(endWord)) return level;
                for(String neighbor : neighbors(str, wordList)) {
                    queue.offer(neighbor);
                }
            }
            level++;
        }
        return 0;

    }


    List<String> neighbors(String s, List<String> wordlist) {
        List<String> res = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordlist);;

        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String word = new String(chars);
                if (dict.remove(word)) {
                    res.add(word);
                }
            }
        }
        return res;
    }
}
public class Step32WardLadder {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.wordLaddar("hit", "cog"));
    }
}
