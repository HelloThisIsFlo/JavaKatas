package katas.sandbox;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SandboxTest {


  private SomeOtherClass someOtherClass;

  @Before
  public void setUp() throws Exception {
    someOtherClass = new SomeOtherClass();
  }

  @Test
  public void greetInEnglish() {
    String greeting = someOtherClass.greet("Nicola");
    assertEquals("Hello Nicola!", greeting);
  }

  @Test
  public void greetInFrench() {
    String greeting = someOtherClass.greet("Nicola");
    assertEquals("Bonjour Nicola!", greeting);
  }
}
