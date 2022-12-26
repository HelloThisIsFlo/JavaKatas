package leetcode.arrays.longestpeak;


import java.util.*;

class Program {

  private final int[] array;

  Program(int[] array) {this.array = array;}

  public static int longestPeak(int[] array) {
    return new Program(array).longestPeak();
  }

  public int longestPeak() {
    return findPeaks()
        .stream()
        .map(this::expandPeak)
        .max(Integer::compareTo)
        .orElse(0);
  }

  private List<Integer> findPeaks() {
    List<Integer> peakIdx = new ArrayList<>();
    for (int i = 1; i < array.length - 1; i++) {
      if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
        peakIdx.add(i);
      }
    }
    return peakIdx;
  }

  private int expandPeak(int peakIdx) {
    int start = peakIdx;
    int end = peakIdx;
    int peakLength  = 1;
    do {
      start--;
      peakLength++;
    } while (start > 0 && array[start - 1] < array[start]);

    do {
      end++;
      peakLength++;
    } while (end < array.length - 1 && array[end] > array[end + 1]);

    return peakLength;
  }
}
