package Step08LicenseKeyFormatting;

/**
 * 8.문자열 포맷 형식
 * 문자열을 특정 포맷으로 변환하.
 * 응용예제 [카드번호, 티켓번호],
 */

class Model {
    private final String password;
    private final int seperator;

    Model(String password, int seperator) {
        this.password = password;
        this.seperator = seperator;
    }

    public String convertPassword() {
        String  formatedPassword = this.password.replace("-", "").toUpperCase();
        int lengthPassword=  formatedPassword.length();

        StringBuilder  newPassword = new StringBuilder();
        for(char s:formatedPassword.toCharArray()) {
            newPassword.append(s);
        }

        for(int i=seperator; i < lengthPassword; i = i+seperator) {
            newPassword.insert(lengthPassword-i, " ");
        }
        return newPassword.toString();


    }
}

public class Step8LicenseFormatting {
    public static void main(String[] args) {
        Model model = new Model("5df3F3f-Fv2354fj-e-fa", 4);
        System.out.println(model.convertPassword());
    }
}
