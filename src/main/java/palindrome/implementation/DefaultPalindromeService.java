package palindrome.implementation;

import palindrome.service.PalindromeService;

public class DefaultPalindromeService implements PalindromeService {

    @Override
    public boolean canBePalindrome(String text) {
        if (text.length() < 2)
            return true;

        for (int leftCharIndex = 0; leftCharIndex < text.length() - 1; leftCharIndex++) {
            if (charAtGivenIndexEqualToLastChar(text, leftCharIndex))
                return canBePalindrome(trimFromGivenIndexToLastChar(text, leftCharIndex));
            for (int rightCharIndex = text.length(); rightCharIndex > leftCharIndex + 1; rightCharIndex--) {
                if (firstAndLastCharAreEqual(text, leftCharIndex, rightCharIndex))
                    return canBePalindrome(trimStringFromIndexToIndex(text, leftCharIndex, rightCharIndex));
            }
        }
        return false;
    }

    private String trimStringFromIndexToIndex(String text, int leftIndex, int rightIndex) {
        return text.substring(leftIndex, rightIndex);
    }

    private boolean firstAndLastCharAreEqual(String text, int leftIndex, int rightIndex) {
        return text.charAt(leftIndex) == text.charAt(rightIndex - 1);
    }

    private String trimFromGivenIndexToLastChar(String text, int index) {
        return text.substring(index + 1, text.length() - 1);
    }

    private boolean charAtGivenIndexEqualToLastChar(String text, int leftCharIndex) {
        int lastCharIndex = text.length() - 1;
        return text.charAt(leftCharIndex) == text.charAt(lastCharIndex);
    }
}
