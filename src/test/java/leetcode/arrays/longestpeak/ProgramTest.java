package leetcode.arrays.longestpeak;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProgramTest {

  @Test
  void longestPeak() {
    testLongestPeak(
        6,
        2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3
    );
    testLongestPeak(
        9,
        1, 1, 1, 2, 3, 10, 12, -3, -3, 2, 3, 45, 800, 99, 98, 0, -1, -1, 2, 3, 4, 5, 0, -1, -1
    );
    testLongestPeak(
        0,
        1, 1, 1
    );
  }

  private void testLongestPeak(int expected, int... array) {
    assertEquals(
        expected,
        Program.longestPeak(array)
    );
  }
}