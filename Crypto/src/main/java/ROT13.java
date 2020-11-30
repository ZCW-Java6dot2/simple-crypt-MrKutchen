import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ROT13 {
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
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) +
                        13 - 65) % 26 + 65);
                result.append(ch);
            } else if (Character.isLowerCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) +
                        13 - 97) % 26 + 97);
                result.append(ch);
            } else {
                result.append(text.charAt(i));
            }
        }
        return result.toString();
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
        for (int i = 0; i < stringS.length; i++) {
            if (stringS[i] == c) {
                startIndex = i;
            }
        }
        //fill first half of string with last bit of array
        for (int i = startIndex; i < stringS.length; i++) {
            answer.append(stringS[i]);
        }
        //fill last half of string with first bit of array
        for (int i = 0; i < startIndex; i++) {
            answer.append(stringS[i]);
        }
        return answer.toString();
    }

    public void encryptFile(File file){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("sonnet18.enc")));
            String line;
            while ((line = reader.readLine()) != null){
                writer.write(encrypt(line) + "\n");
            }
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decryptFile(File file){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("sonnet18.dec")));
            String line;
            while ((line = reader.readLine()) != null){
                writer.write(decrypt(line) + "\n");
            }
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}