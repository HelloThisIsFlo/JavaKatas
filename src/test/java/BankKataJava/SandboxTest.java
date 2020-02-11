package BankKataJava;

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

    @Test
    public void mockFunctionWithReturnValue() {
        when(greeterMock.greet(any())).thenReturn("hello frank");

        String result = greeterMock.greet("WHATEVER");

        verify(greeterMock).greet("WHATEVER");
        assertEquals("hello frank", result);

        assertThat(result, containsString("frank"));
    }


    public interface Greeter {
        String greet(String name);
    }
}
