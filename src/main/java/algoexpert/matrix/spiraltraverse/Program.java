package algoexpert.matrix.spiraltraverse;

import java.util.*;

class Program {


  private int[][] array;
  private int n;
  private int m;
  private List<Integer> result;

  Program() {
    this.result = new ArrayList<>();
  }

  public static List<Integer> spiralTraverse(int[][] array) {
    Program program = new Program();
    program.setArray(array);
    return program.spiralTraverse();
  }

  public void setArray(int[][] array) {
    this.array = array;
    this.m = array.length;
    this.n = this.m != 0 ? array[0].length : 0;
  }

  public List<Integer> spiralTraverse() {
    if (n == 0) {return result;}
    doTraverse(0, 0);
    return result;
  }

  private void doTraverse(int si, int sj) {
    int ei = n - 1 - si;
    int ej = m - 1 - sj;
    if (si > ei) {return;}
    if (sj > ej) {return;}

    boolean singleRow = sj == ej;
    boolean singleCol = si == ei;
    for (int i = si; i <= ei; i++) {
      result.add(array[sj][i]);
    }
    for (int j = sj + 1; j <= ej; j++) {
      result.add(array[j][ei]);
    }
    for (int i = ei - 1; si <= i && !singleRow; i--) {
      result.add(array[ej][i]);
    }
    for (int j = ej - 1; sj + 1 <= j && !singleCol; j--) {
      result.add(array[j][si]);
    }

    doTraverse(si + 1, sj + 1);
  }

  private void debug(String tag, int i, int j) {
    System.out.println(tag + " | i = " + i + " | j = " + j + " | val = " + array[j][i]);
  }


}
