package Step23BaseballGame;

import java.util.Stack;

/**
 * 23.오퍼레이터 처리
 *
 * 응용예제 [스택]
 */

class DataSource {
    String[] getAllData() {
        return new String[] {"5","-2","4","C","D","9","+","+"};
    }
}

class Model {
    private final DataSource dataSource;

    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    int baseBallGame() {
        String[] data = this.dataSource.getAllData();
        int result =0;
        Stack<Integer> stack = new Stack<>();

        for(String op: data) {
            switch(op) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() *2);
                    break;
                case "+":
                    int op1Num = stack.pop();
                    int op2Num = stack.peek();
                    stack.push(op1Num);
                    stack.push(op1Num + op2Num);
                    break;
                default:
                    stack.push(Integer.valueOf(op));
            }
        }

        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}

public class Step23BaseballGame {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.baseBallGame());
    }
}
