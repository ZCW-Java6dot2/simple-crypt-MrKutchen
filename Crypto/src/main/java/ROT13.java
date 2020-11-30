import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    private Character cs;
    private Character cf;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
        cs = 'a';
        cf = 'n';
    }


    public String crypt(String text) throws UnsupportedOperationException {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'm') {
                ch += 13;
            } else if (ch >= 'A' && ch <= 'M') {
                ch += 13;
            } else if (ch >= 'n' && ch <= 'z') {
                ch -= 13;
            } else if (ch >= 'N' && ch <= 'Z') {
                ch -= 13;
            }
            answer.append(ch);
        }
        return answer.toString();
    }

    public String encrypt(String text) {

        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        int startIndex = 0;
        StringBuilder answer = new StringBuilder();
        char[] stringS = s.toCharArray();
        //get starting index
        for (int i=0; i<stringS.length; i++){
            if (stringS[i] == c){
                startIndex = i;
            }
        }
        //fill first half of string with last bit of array
        for (int i=startIndex; i<stringS.length; i++){
            answer.append(stringS[i]);
        }
        //fill last half of string with first bit of array
        for (int i=0; i<startIndex; i++){
            answer.append(stringS[i]);
        }
        return answer.toString();
    }

}
