package katas.wordwrap;

public class Wrapper {
    public static String wrap(String text, int columnSize) {
        String firstWord = text.split(" ")[0];
        if (firstWord.length() <= columnSize) return text;

        String firstLine = text.substring(0, columnSize);
        String rest = text.substring(columnSize);
        return firstLine + "\n" + wrap(rest, columnSize);
    }

    public static String wrapWithTooMuchOfABigLeap(String text, int columnSize) {
        String[] words = text.split(" ");

        int currentLineCharCount = 0;
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            boolean wordWouldOverflowLine = currentLineCharCount + word.length() > columnSize;
            if (wordWouldOverflowLine) {
                result.append("\n");
                currentLineCharCount = 0;
            } else {
                result.append(" ");
            }
            result.append(word);
            currentLineCharCount += word.length();
        }
        return result.substring(1);
    }

    public static String wrapPremise(String text, int columnSize) {
        if (columnSize <= 0) throw new InvalidArgument();
        if (text == null) return "";
        return text;
    }

    public static class InvalidArgument extends RuntimeException {
    }
}
