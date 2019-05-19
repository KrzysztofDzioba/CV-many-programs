package shorttasks.arrayrevert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Solution2 {

    public static void main(String[] args) {
        Integer[] integers1 = IntStream.of(2, 1, 5, 4, 3).boxed().toArray(Integer[]::new);
        List<Integer> list = Arrays.asList(integers1);
        Collections.reverse(list);
        System.out.println(list.toString());
    }
}
