package katas.sandbox;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SandboxTest {


  private SomeOtherClass someOtherClass;

  @BeforeEach
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
    try (MockedStatic<SomeClassWithStaticMethod> mocked = mockStatic(SomeClassWithStaticMethod.class)) {
      mocked.when(SomeClassWithStaticMethod::hello).thenReturn("Bonjour");
      String greeting = someOtherClass.greet("Nicola");
      assertEquals("Bonjour Nicola!", greeting);
    }
  }
}
