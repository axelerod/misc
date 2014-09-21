package burov.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class EraserTest {

    @Test
    public void testWithoutString() throws Exception {
        /*
        * withoutString("Hello there", "llo") → "He there"
        withoutString("Hello there", "e") → "Hllo thr"
        withoutString("Hello there", "x") → "Hello there"
        * */
        Eraser eraser = new Eraser();
        assertEquals("He there", eraser.withoutString("Hello there", "llo"));
        assertEquals("Hllo thr", eraser.withoutString("Hello there", "e"));
        assertEquals("TH a FH", eraser.withoutString("THIS is a FISH", "is"));
    }
}