import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class ROT13Test {


    @Test
    public void rotateStringTest0() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "ABCDEF";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'A');

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest1() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "DEFABC";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'D');

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest2() {
        // Given
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s2 = "NOPQRSTUVWXYZABCDEFGHIJKLM";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'N');
        System.out.println(s1);
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void cryptTest1() {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String Q1 = "Why did the chicken cross the road?";
        String A1 = "Jul qvq gur puvpxra pebff gur ebnq?";

        String Q2 = "Gb trg gb gur bgure fvqr!";
        String A2 = "To get to the other side!";

        // When
        String actual = cipher.encrypt(Q1);
        System.out.println(Q1);
        System.out.println(A1);
        // Then
        assertTrue(actual.equals(A1));

        // When
        String actual2 = cipher.decrypt(Q2);
        System.out.println(Q2);
        System.out.println(A2);
        // Then
        assertTrue(actual2.equals(A2));
    }

    @Test
    public void cryptTest2() {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String Q1 = "Why did the chicken cross the road?";
        System.out.println(Q1);

        // When
        String actual = cipher.crypt(cipher.crypt(Q1));
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(Q1));
    }

    @Test
    public void testEncryptionDecryptionWriter(){
        ROT13 cipher = new ROT13();

        cipher.encryptFile(new File("sonnet18.txt"));
        cipher.decryptFile(new File("sonnet18.enc"));
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader("sonnet18.txt"));
            BufferedReader reader2 = new BufferedReader(new FileReader("sonnet18.dec"));
            String line1;
            String line2;
            while (reader1.readLine() != null && reader2.readLine() != null){
                line1 = reader1.readLine();
                line2 = reader2.readLine();
                Assert.assertEquals(line1, line2);
            }
            reader1.close();
            reader2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
