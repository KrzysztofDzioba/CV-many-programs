package palindrome;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import palindrome.implementation.DefaultPalindromeService;
import palindrome.service.PalindromeService;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DefaultPalindromeServiceTest {

    private static PalindromeService palindromeService;

    @BeforeAll
    static void setUp() {
        palindromeService = new DefaultPalindromeService();
    }

    @DisplayName("Should test if there is a possibility that any fragment of the word could be a palindrome.")
    @ParameterizedTest(name = "{index} => text={0}, canBePalindrome={1}")
    @MethodSource("sumProvider")
    void shouldTestIfTextCouldBePalindrome(String text, boolean expectedValue) {
        //when
        boolean actualValue = palindromeService.canBePalindrome(text);

        //then
        assertEquals(actualValue, expectedValue);
    }

    private static Stream<Arguments> sumProvider() {
        return Stream.of(
                Arguments.of("aaa", true),
                Arguments.of("aba", true),
                Arguments.of("foo", true),
                Arguments.of("dakar", true),
                Arguments.of("abcdedzxc", true),
                Arguments.of("abcdefgghijk", true),
                Arguments.of("foo bar rab oof", true),
                Arguments.of("abc", false),
                Arguments.of("abckdba", false),
                Arguments.of("moskito", false),
                Arguments.of("test", false),
                Arguments.of("bar", false),
                Arguments.of("this is milk", false),
                Arguments.of("it can be text with spaces", false)
        );
    }

}