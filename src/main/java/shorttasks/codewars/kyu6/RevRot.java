package shorttasks.codewars.kyu6;

// description:

//The input is a string str of digits. Cut the string into chunks (a chunk here is a substring of the initial string) of size sz (ignore the last chunk if its size is less than sz).
//
//        If a chunk represents an integer such as the sum of the cubes of its digits is divisible by 2, reverse that chunk; otherwise rotate it to the left by one position. Put together these modified chunks and return the result as a string.
//
//        If
//
//        sz is <= 0 or if str is empty return ""
//        sz is greater (>) than the length of str it is impossible to take a chunk of size sz hence return "".
//        Examples:
//        revrot("123456987654", 6) --> "234561876549"
//        revrot("123456987653", 6) --> "234561356789"
//        revrot("66443875", 4) --> "44668753"
//        revrot("66443875", 8) --> "64438756"
//        revrot("664438769", 8) --> "67834466"
//        revrot("123456779", 8) --> "23456771"
//        revrot("", 8) --> ""
//        revrot("123456779", 0) --> ""
//        revrot("563000655734469485", 4) --> "0365065073456944"

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class RevRot {

    static String revRot(String strng, int sz) {
        List<String> stringChunks = getStringChunks(strng, sz);
        StringBuilder builder = new StringBuilder();

        stringChunks
                .forEach(s -> {
                    String computed = sumOfCubesDivisibleBy2(s) ?
                            reverseString(s) : rotateToLeftByOnePosition(s);
                    builder.append(computed);
                });

        String s = builder.toString();
        return s;
    }

    private static boolean sumOfCubesDivisibleBy2(String s) {
        char[] chars = s.toCharArray();
        int[] intChars = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            intChars[i] = (int) chars[i];
        }

        return IntStream.of(intChars)
                .map(operand -> operand * operand * operand)
                .summaryStatistics()
                .getSum() % 2 == 0;
    }

    private static String rotateToLeftByOnePosition(String s) {
        String tail = s.substring(1);
        String head = String.valueOf(s.charAt(0));
        return tail + head;
    }

    private static List<String> getStringChunks(String strng, int sz) {
        if (sz <= 0)
            return List.of();

        List<String> chunks = new ArrayList<>();
        for (int i = 0; i < strng.length(); i = i + sz) {
            int calculatedEndIndex = i + sz;
            if (calculatedEndIndex <= strng.length()) {
                chunks.add(strng.substring(i, calculatedEndIndex));
            }
        }
        return chunks;
    }

    private static String reverseString(String strToReverse) {
        StringBuilder stringBuilder = new StringBuilder(strToReverse);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s1 = revRot("123456987654", 6);
        String s2 = revRot("123456987653", 6);
        String s3 = revRot("66443875", 4);
        String s4 = revRot("66443875", 8);
        String s5 = revRot("664438769", 8);
        String s6 = revRot("123456779", 8);
        String s7 = revRot("", 8);
        String s8 = revRot("123456779", 0);
        String s9 = revRot("563000655734469485", 4);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);
        System.out.println(s8);
        System.out.println(s9);
    }
}

