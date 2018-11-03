package palindrome.implementation;

import palindrome.service.PalindromeService;

public class DefaultPalindromeService implements PalindromeService {

    @Override
    public boolean canBePalindrome(String text) {
        if (text.length() == 0 || text.length() == 1)
            return true;

        for (int i = 0; i < text.length() - 1; i++) {
            if ((text.charAt(i)) == (text.charAt(text.length() - 1)))
                return canBePalindrome(text.substring(i + 1, text.length() - 1));
            for (int j = text.length(); j > i + 1; j--) {
                if ((text.charAt(i)) == (text.charAt(j - 1)))
                    return canBePalindrome(text.substring(i, j));
            }
        }
        return false;
    }
}
