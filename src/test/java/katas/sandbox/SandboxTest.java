package katas.sandbox;

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

  interface Thing {

    String sayHi();
  }

  static class RealThing implements Thing {

    @Override
    public String sayHi() {
      return "hi";
    }
  }

  static class DecoratorThing implements Thing {

    private final Thing thing;

    public DecoratorThing(Thing thing) {this.thing = thing;}

    @Override
    public String sayHi() {
      return thing.sayHi();
    }

  }

  public static DecoratorThing decorate(Thing thing) {
    if (thing instanceof DecoratorThing) return (DecoratorThing) thing;

    return new DecoratorThing(thing);
  }

  @Test
  public void name() {

    Thing realThing = new RealThing();
    Thing decoratedOnce = decorate(realThing);
    Thing decoratedTwice = decorate(decoratedOnce);

    assertEquals(decoratedOnce, decoratedTwice);

  }
}
