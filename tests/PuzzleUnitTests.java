import models.Board;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

public class PuzzleUnitTests {
    @Test
    public void testConstructor() {
        Board b = new Board("023145678");
        StringWriter writer = new StringWriter();
        PrintWriter pw = new PrintWriter(writer);
        pw.println(" 23");
        pw.println("145");
        pw.println("678");
        assertEquals(b.toString(), writer.toString());
        pw.close();
    }

    @Test
    public void testConstructor2() {
        Board b = new Board("123485670");
        StringWriter writer = new StringWriter();
        PrintWriter pw = new PrintWriter(writer);
        pw.println("123");
        pw.println("485");
        pw.println("67 ");
        assertEquals(b.toString(), writer.toString());
        pw.close();
    }

    @Test
    public void testTrueIsGoal() {
        Board b = new Board("123485670");
        Board bSolved = new Board("123485670");

        assertTrue(b.isGoal(bSolved));
    }

    @Test
    public void testFalseIsGoal() {
        Board b = new Board("123485670");
        Board bSolved = new Board("023145678");

        assertFalse(b.isGoal(bSolved));

        Board b1 = new Board();
        assertFalse(b1.isGoal(bSolved));
    }

    @Test
    public void testTrueEquals() {
        Board b = new Board("123485670");
        Board bSolved = new Board("123485670");

        assertTrue(b.equals(bSolved));
    }

    @Test
    public void testFalseEquals() {
        Board b = new Board("123485670");
        Board bSolved = new Board("023145678");

        assertFalse(b.equals(bSolved));
    }

    @Test
    public void testTrueHashCode() {
        Board b = new Board("123485670");
        Board bSolved = new Board("123485670");
        assertEquals(b.hashCode(), bSolved.hashCode());
    }
    
    @Test
    public void testFalseHashCode() {
        Board b = new Board("123485670");
        Board bSolved = new Board("023145678");
        assertEquals(b.hashCode(), bSolved.hashCode());
    }
}