import models.Board;
import services.Ilayout;

import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

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
<<<<<<< Updated upstream
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
        assertFalse(b.isGoal(bSolved));
=======
    public void testChildren() {
        Board i = new Board("703642185"); // initial config 703642185
        Board p1 = new Board("073642185");// possibility 1
        Board p2 = new Board("743602185");// possibility 2
        Board p3 = new Board("730642185");// possibility 3
        List<Ilayout> finalList = new ArrayList<Ilayout>();
        finalList.add(p2); //Adicionar as possibilidades à lista final
        finalList.add(p3);
        finalList.add(p1);
        List<Ilayout> testList = i.children(); // correr o children e guardar numa lista

        assertTrue(finalList.size() == testList.size());
        //assertTrue(finalList.containsAll(testList) && testList.containsAll(finalList));
        //assertEquals(finalList, testList);
>>>>>>> Stashed changes
    }
}