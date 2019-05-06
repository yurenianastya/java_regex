package ua.lviv.iot;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class StringProcessorTest {

    private StringProcessor sp = new StringProcessor();

    private String testString;

    private List<String> expected;

    private List<String> actual;

    @Before
    public void setUp() throws Exception {

        expected = new LinkedList<String>();

        actual = new LinkedList<String>();

        testString = "See through-the-lies of the Jedi!"
                + " I do not fear the dark side as you do."
                + " I have brought peace, freedom, justice, and security to my new empire."
                + " Taken from Star Wars: Episode III Revenge-of-the Sith!"
                + " The ability to destroy a planet"
                + " is insignificant next to the power of the Force."
                + " I find your lack-of-faith disturbing!";

        expected.add("See through-the-lies of the Jedi!");
        expected.add("Taken from Star Wars: Episode III Revenge-of-the Sith!");
        expected.add("I find your lack-of-faith disturbing!");


        sp.setUserInput(testString);

    }

    @Test
    public void testMyCustomRegex() {

        actual = sp.myCustomRegex();

        Assertions.assertEquals(expected, actual);

        sp.showResults();
    }

    @Test
    public void noMatch() {

        sp.setUserInput("nothing");

        actual = sp.myCustomRegex();

        Assertions.assertNotEquals(expected, actual);

        sp.showResults();


    }
}