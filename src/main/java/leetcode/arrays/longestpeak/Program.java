package leetcode.arrays.longestpeak;


class Program {

  private final int[] array;

  Program(int[] array) {this.array = array;}

  public static int longestPeak(int[] array) {
    return new Program(array).longestPeak();
  }

  public int longestPeak() {
    int longestPeak = 0;
    for (int i = 1; i < array.length - 1; i++) {
      if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
        int peakLength = findPeakLength(i);
        if (peakLength > longestPeak) {longestPeak = peakLength;}
      }
    }
    return longestPeak;
  }


  private int findPeakLength(int peakIdx) {
    int start = peakIdx;
    int end = peakIdx;
    int peakLength = 1;
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
