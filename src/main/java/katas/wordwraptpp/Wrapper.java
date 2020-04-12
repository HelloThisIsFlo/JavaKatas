package katas.wordwraptpp;

public class Wrapper {

    public static final int NOT_FOUND = -1;

    public static String wrap(String text, int colSize) {
        if (text.length() < colSize) return text;

        String substringForTheFirstColumn = text.substring(0, colSize);
        int indexOfLastSpace = substringForTheFirstColumn.lastIndexOf(' ');
        boolean hasSpace = indexOfLastSpace != NOT_FOUND;
        if (hasSpace) {
            return text.substring(0, indexOfLastSpace) + '\n' + wrap(text.substring(indexOfLastSpace + 1), colSize);
        } else {
            return text.substring(0, colSize) + '\n' + wrap(text.substring(colSize), colSize);
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

     --------------------

     Path 1 (optimized):
     SHARED: emptyString_returnsEmptyString()
     SHARED: enoughSpace_doNotWrap()

     12 | Function | breakBetween2Words_breakAtSpace()

     12 | Function | multipleWords_onlyBreakWhenGoingOverTheColLimit()
     6 | Conditional | multipleWords_onlyBreakWhenGoingOverTheColLimit()

     6 | Conditional | wordTooLongForOneColumn

     9 | Tail-Recursion | breakInTheMiddleOfAWord


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
