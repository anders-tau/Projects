import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class StringUtilsTest {
    @Test
    public void testToArray() {
        String[] expected = {"T", "E", "S", "T"};
        String source="T:E:S:T";
        assertArrayEquals(expected, StringUtils.toArray(source, ':'), "Wrong array");
        assertEquals(0,StringUtils.toArray(null, ':').length);
    }

    @Test
    public void testJoinArray() {
        String expected ="T:E:S:T";
        String[] source = {"T", "E", "S", "T"};
        assertEquals(expected, StringUtils.joinArray(source, ':'), "Wrong string");
    }

    @Test
    public void testIsEmpty() {
        assertFalse(StringUtils.isEmpty("TEST"), "Non empty string claimed to be empty");
        assertTrue(StringUtils.isEmpty(""), "Empty string not recognized");
        assertTrue(StringUtils.isEmpty(" "), "Whitespaces not recognized");
    }

    @Test
    public void testToDouble() {
        assertEquals(3.1415, StringUtils.toDouble("3.1415"), 0.0001);
        assertEquals(Double.NaN, StringUtils.toDouble(null), 0.00001);
    }

    @Test
    public void testFromDouble() {
        double source = 3.1415;
        String expected="3.1415";
        String actual = StringUtils.fromDouble(source);
        assertEquals(expected, actual, "Unexpected string value");
    }
}
