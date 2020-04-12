package katas.wordwraptpp;

public class Wrapper {

    public static final int NOT_FOUND = -1;

    private final int colSize;

    private Wrapper(int colSize) {
        this.colSize = colSize;
    }

    public static String wrap(String text, int colSize) {
        return new Wrapper(colSize).wrap(text);
    }

    private String insertBreak(String text, int breakStart, int breakEnd) {
        return text.substring(0, breakStart) + '\n' + wrap(text.substring(breakEnd), colSize);
    }

    private String wrap(String text) {
        if (text.length() < colSize) return text;

        int indexOfLastSpace = text.substring(0, colSize).lastIndexOf(' ');
        boolean hasSpace = indexOfLastSpace != NOT_FOUND;

        if (hasSpace) {
            return insertBreak(text, indexOfLastSpace, indexOfLastSpace + 1);
        } else {
            return insertBreak(text, colSize, colSize);
        }
    }

     /*
     Path 1:
     SHARED: emptyString_returnsEmptyString()
     SHARED: enoughSpace_doNotWrap()

     12 | Function | breakBetween2Words_breakAtSpace()

     13 | Mutation | multipleWords_onlyBreakWhenGoingOverTheColLimit()
     12 | Function | multipleWords_onlyBreakWhenGoingOverTheColLimit()
     10 | Loop | multipleWords_onlyBreakWhenGoingOverTheColLimit()
     6 | Conditional | multipleWords_onlyBreakWhenGoingOverTheColLimit()


     -------------------

     Path 2:
     SHARED: emptyString_returnsEmptyString()
     SHARED: enoughSpace_doNotWrap()

     12 | Function | singleWord_notEnoughSpace_breakInMiddleOfWord()
     6 | Conditional | singleWord_notEnoughSpace_breakInMiddleOfWord()

     12 | Function | breakBetween2Words_breakAtSpace_path2
     6 | Conditional | breakBetween2Words_breakAtSpace_path2

     9 | Tail Recursion | wordTooLongToFitOn2Lines_breakMultipleTimesOnSameWord()

     6 | Conditional | multipleWhitespacesTogetherOnTheSameLine
     9 | Tail Recursion | multipleWhitespacesTogetherOnTheSameLine
      */
}
