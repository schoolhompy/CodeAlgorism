package Step00basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Quiztype {
    public void type0() throws Exception {
        //1+2+3+...n 인 자연수에서 입력받은 수를 넘는 n 이라면

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        input = br.readLine();

        int wantNum =  Integer.parseInt(input);

        int sums = 0;
        int i = 0;
        while(sums < wantNum) {
            sums = sums + (i);
            if(sums < wantNum) i++;
        }
    }
}

public class Step0basic {
    public static void  main(String[] args) {

    }
}
