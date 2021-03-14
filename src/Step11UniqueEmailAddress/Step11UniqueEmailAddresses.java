package Step11UniqueEmailAddress;

import java.util.HashSet;
import java.util.Set;

/**
 * 11.유일한 메일주소 찾기
 * 중복된 자료중에 등적 예외를 무시한 이후의 동일한 유일값을 가려내기
 * string indexof, substring
 *
 * 응용예제 [메일분류, 주소분류 ]
 */

class DataSource {
    String[] getAllData() {
        return new String[]{
                "test.email+my1@coding.com",
                "test.em.ail+myhaete@coding.com",
                "test.email@coding.man.com"
        };
    }
}

class Model {
    private final DataSource dataSource;

    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    int getCountUniques() {
        Set<String> uniqueEmails = new HashSet<>();

        for(String email: dataSource.getAllData()) {
            uniqueEmails.add(getUniueEmail(email));
        }
        return uniqueEmails.size();
    }

    private String getUniueEmail(String email) {
        int atPos = email.indexOf("@");
        String domainName = email.substring(atPos);
        String localName = escapedLocalName(email.substring(0,atPos));
        return localName + domainName;
    }

    private String escapedLocalName(String substring) {
        StringBuilder sb = new StringBuilder();
        for(char c:substring.toCharArray()) {
            if (c == '.') continue;
            if (c == '+') break;
            sb.append(c);
        }
        return sb.toString();
    }
}

public class Step11UniqueEmailAddresses {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.getCountUniques());
    }
}
