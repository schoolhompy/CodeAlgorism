package Step07JewelsAndStones;

import java.util.HashSet;
import java.util.Set;

/**
 * 7.보석 구하기
 * 문자열함수를 이용해서 특정 문자 개수찾기.
 * 응용예제 [보석찾기],
 */

class Model {
    private String jewels, stones;

    Model(String jewels, String stones) {
        this.jewels = jewels;
        this.stones = stones;
    }

    public int findJewels() {
        Set<Character> jewelTokens = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            jewelTokens.add(jewel);
        }

        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (jewelTokens.contains(stone)) {
                count++;
            }
        }
        return count;
    }
}

public class Step7JewelsAndStones {
    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";
        Model model = new Model(jewels, stones);

        System.out.println(model.findJewels());
    }
}
