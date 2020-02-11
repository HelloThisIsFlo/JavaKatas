package BankKataJava.sandbox;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SandboxTest {

    @Mock
    Greeter greeterMock;
    @Mock
    Frank frankMock;

    private Frank frankReal;

    @Before
    public void setUp() {
        frankReal = new Frank();
    }

    @Test
    public void mockFunctionWithReturnValue() {
        when(greeterMock.greet(any())).thenReturn("hello frank");

        String result = greeterMock.greet("WHATEVER");

        verify(greeterMock).greet("WHATEVER");
        assertEquals("hello frank", result);

        assertThat(result, containsString("frank"));
    }

    @Test
    public void mockVoidMethods() {
        frankReal.rememberSomething("bicycle");
        assertEquals("bicycle", frankReal.whatDidIAskYouToRemember());

        frankReal.rememberSomething("sun");
        assertEquals("sun", frankReal.whatDidIAskYouToRemember());

        when(frankMock.whatDidIAskYouToRemember()).thenReturn("hello");
        assertEquals("hello", frankMock.whatDidIAskYouToRemember());
    }

    public interface Greeter {
        String greet(String name);
    }

    public static class Frank {
        private String thingToRemember;

        void rememberSomething(String thing) {
            this.thingToRemember = thing;
        }

        String whatDidIAskYouToRemember() {
            return this.thingToRemember;
        }
    }
}
