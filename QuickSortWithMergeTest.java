import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickSortWithMergeTest {
    @Test
    public void roundTest() {
        Function<Float, Integer> func = (x) -> (int) Math.floor(x);
        assertEquals(2, func.apply(2.5f));
        assertEquals(1, func.apply(1f));
        assertEquals(1, func.apply(1.2f));
        assertEquals(2, func.apply(2.75f));
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void sortTest(int[] arr, int[] sortedArray) {
        QuickSortWithMerge.sort(arr, 1, arr.length);
        assertArrayEquals(sortedArray, arr);
    }

    static Stream<Arguments> testData() {
        Map<int[], int[]> data = Map.of(
                new int[]{3, 2, 1}, new int[]{1, 2, 3},
                new int[]{4, 2, 3, 1}, new int[]{1, 2, 3, 4},
                new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5},
                new int[]{5,2,4,6,1,3,2,6}, new int[]{1,2,2,3,4,5,6,6}
        );
        return data.entrySet().stream()
                .map(entry -> Arguments.of(entry.getKey(), entry.getValue()));
    }
}