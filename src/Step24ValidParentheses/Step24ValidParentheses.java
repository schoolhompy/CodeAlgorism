package Step24ValidParentheses;

import java.util.Stack;

/**
 * 24.괄호쌍 맞추기
 *
 * 응용예제 [스택]
 */

class DataSource {
    String getAllData() {
        return "([)]";
    }
}

class Model {
    private final DataSource dataSource;

    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    boolean ValidParentheses() {
        String data = this.dataSource.getAllData();
        boolean result = true;
        Stack<Character> stack = new Stack<>();

        for(int i =0; i<data.length(); i++) {
            switch(data.charAt(i)) {
                case ')':
                    if(stack.peek() == '(') stack.pop();
                    break;
                case ']':
                    if(stack.peek() == '[') stack.pop();
                    break;
                case '}':
                    if(stack.peek() == '{') stack.pop();
                    break;
                default:
                    stack.push(data.charAt(i));
                    break;
            }

        }


        return stack.isEmpty();
    }
}

public class Step24ValidParentheses {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.ValidParentheses());
    }

}
