package shorttasks.codewars.kyu6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class CountingDuplicates {
    static int duplicateCount(String text) {
        if (text == null || text.length() == 0 || text.length() == 1)
            return 0;

        String lowerCased = text.toLowerCase();

        List<Character> distinctChars = getDistinctChars(text);
        AtomicInteger counter = new AtomicInteger();
        distinctChars
                .forEach(i ->
                        {
                            int firstIndexCharOccuring = lowerCased.indexOf(i);
                            int lastIndexCharOccuring = lowerCased.lastIndexOf(i);
                            if (firstIndexCharOccuring != lastIndexCharOccuring) {
                                counter.getAndIncrement();
                            }
                        }
                );
        return counter.get();
    }

    private static List<Character> getDistinctChars(String text) {
        List<Character> distinctChars = new ArrayList<>();
        text.trim().chars()
                .mapToObj(i -> (char) i)
                .forEach(character -> {
                    if (!distinctChars.contains(character)) {
                        distinctChars.add(character);
                    }
                });
        return distinctChars;
    }
}