package algoexpert.matrix.spiraltraverse;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ProgramTest {

  @Test
  void spiralTraverseSquare() {
    int[][] matrix = {
        {1, 2, 3, 4},
        {12, 13, 14, 5},
        {11, 16, 15, 6},
        {10, 9, 8, 7}
    };
    assertEquals(
        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16),
        Program.spiralTraverse(matrix)
    );
  }

  @Test
  void spiralTraverseRectangle() {
    int[][] matrix = {
        {00, 01, 02, 03},
        {10, 11, 12, 13}
    };
    assertEquals(
        List.of(0, 1, 2, 3, 13, 12, 11, 10),
        Program.spiralTraverse(matrix)
    );
  }
  @Test
  void spiralTraverseRectangle2() {
    int[][] matrix = {
        {00, 01, 02, 03},
        {10, 11, 12, 13},
        {20, 21, 22, 23}
    };
    assertEquals(
        List.of(0, 1, 2, 3, 13, 23,22 ,21, 20, 10, 11, 12),
        Program.spiralTraverse(matrix)
    );
  }

  @Test
  void spiralTraverseOneLine() {
    int[][] matrix = {
        {00, 01, 02, 03},
    };
    assertEquals(
        List.of(0, 1, 2, 3),
        Program.spiralTraverse(matrix)
    );
  }

}