import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void leonTariqTest() throws IOException {
        File fileToWrite = new File("/Users/vle/Documents/Projects/Week6/RegexHameletParser_3.11/Maven.Regex-Hamlet-Parser/src/main/resources/leon.txt");
        hamletParser.parseLeonTariq(fileToWrite);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String testHam = "Horatio";
        String expected = "Tariq";
        String actual = hamletParser.changeHoratioToTariq(testHam);

        assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq2() {
        String testHam = "HORATIO";
        String expected = "TARIQ";
        String actual = hamletParser.changeHoratioToTariq(testHam);

        assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq3() {
        String testHam = "Horati0o";
        String expected = "Horati0o";
        String actual = hamletParser.changeHoratioToTariq(testHam);

        assertEquals(expected, actual);
    }

    @Test
    public void testChangeHamletToLeon() {
        String testHam = "Hamlet";
        String expected = "Leon";
        String actual = hamletParser.changeHamletToLeon(testHam);

        assertEquals(expected, actual);
    }

    @Test
    public void testChangeHamletToLeon2() {
        String testHam = "HAMLET";
        String expected = "LEON";
        String actual = hamletParser.changeHamletToLeon(testHam);

        assertEquals(expected, actual);
    }

    @Test
    public void testChangeHamletToLeon3() {
        String testHam = "hamleet";
        String expected = "hamleet";
        String actual = hamletParser.changeHamletToLeon(testHam);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        String test = "Is this hamlet a good test";
        String expected = "Is this leon a good test";
        String actual = hamletParser.findHameletAndReplace(test);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet2() {
        String test = "Is this Hamlet a good test";
        String expected = "Is this Leon a good test";
        String actual = hamletParser.findHameletAndReplace(test);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet3() {
        String test = "Is this homlet a good test";
        String expected = "Is this homlet a good test";
        String actual = hamletParser.findHameletAndReplace(test);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio(){
        String test = "Hamlet bad, Horatio good";
        String expected = "Hamlet bad, Tariq good";
        String actual = hamletParser.findHoratioAndReplace(test);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio2(){
        String test = "Hamlet bad, HORATIO good";
        String expected = "Hamlet bad, TARIQ good";
        String actual = hamletParser.findHoratioAndReplace(test);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio3(){
        String test = "Hamlet bad, DEW good";
        String expected = "Hamlet bad, DEW good";
        String actual = hamletParser.findHoratioAndReplace(test);

        assertEquals(expected, actual);
    }
}