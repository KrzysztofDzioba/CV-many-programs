package shorttasks.arrayrevert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution1 {

    public static void main(String[] args) {
        int[] ints = IntStream.of(2, 1, 5, 4, 3).toArray();

        for (int i = 0; i < ints.length/2; i++) {
            int temp = ints[ints.length - i - 1];
            ints[ints.length - i - 1] = ints[i];
            ints[i] = temp;
        }

        Arrays.stream(ints).forEach(System.out::println);

    }
}
