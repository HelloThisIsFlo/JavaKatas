package katas.wordwrap;

import org.junit.Ignore;
import org.junit.Test;

import static katas.wordwrap.Wrapper.wrap;
import static katas.wordwrap.Wrapper.wrapPremise;
import static org.junit.Assert.assertEquals;

public class WrapperTest {
    @Test
    public void emptyString() {
        assertEquals("", wrap("", 1));
    }

    @Test
    public void smallerThanColumn() {
        assertEquals("hello", wrap("hello", 100));
    }

    @Test
    @Ignore
    public void oneWordPerLine() {
        assertEquals("word\nword", wrap("word word", 5));
    }

    @Test
    @Ignore("Too much of a big leap")
    public void moreThanOneWordPerLine() {
        assertEquals("word word\nword", wrap("word word word", 10));
    }

    @Test
    public void wordLongerThanColumnSize() {
        assertEquals("someLong\nWord", wrap("someLongWord", 8));
    }

    @Test
    public void wordLongerThanMultipleColumns() {
        assertEquals("someLong\nVeryLong\nWord", wrap("someLongVeryLongWord", 8));
    }

    @Test
    public void premiseBlogArticleDebug() {
        assertEquals("", wrapPremise(null, 10));
        assertEquals("", wrapPremise("", 10));
    }

    @Test(expected = Wrapper.InvalidArgument.class)
    public void invalidArg() {
        wrapPremise("abc", 0);
    }

    @Test
    public void shortWord() {
        assertEquals("word", wrapPremise("word", 5));
    }

    @Test
    @Ignore
    public void TwoWordsLongerThanLimitShouldWrap() throws Exception {
        assertEquals("word\nword", wrapPremise("word word", 6));
    }
    /*


    ({}–>nil) no code at all->code that employs nil
    (nil->constant)
    (constant->constant+) a simple constant to a more complex constant
    (constant->scalar) replacing a constant with a variable or an argument
    (statement->statements) adding more unconditional statements.
    (unconditional->if) splitting the execution path
    (scalar->array)
    (array->container)
    (statement->recursion)
    (if->while)
    (expression->function) replacing an expression with a function or algorithm
    (variable->assignment) replacing the value of a variable.

    */
}