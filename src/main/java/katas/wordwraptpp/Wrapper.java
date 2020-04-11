package katas.wordwraptpp;

public class Wrapper {
    public static String wrap(String text, int colNum) {
        int lastSeenSpace = 0;
        StringBuilder result = new StringBuilder(text);

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                lastSeenSpace = i;
            }
            if (i > colNum) {
                result.setCharAt(lastSeenSpace, '\n');
            }
        }
        return result.toString();
    }
}
