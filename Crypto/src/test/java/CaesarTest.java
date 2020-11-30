import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CaesarTest {

    @Test
    public void caesarTest1() {
        Caesar caesar = new Caesar();
        String Q1 = "Hello world!";
        String A1 = "Jgnnq yqtnf!";
        // When
        String actual = caesar.crypt(Q1, 2);
        System.out.println(Q1);
        System.out.println(A1);
        // Then
        assertTrue(actual.equals(A1));

    }
}
