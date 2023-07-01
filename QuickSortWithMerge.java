public class QuickSortWithMerge {
    public static void sort(final int[] arr, int p, int r) {
        if (p < r) {
            int q = (int) Math.floor((double) (p + r) / 2);
            sort(arr, p, q);
            sort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    private static void merge(final int[] arr, int p, int q, int r) {
        int[] tempArr = new int[r - p + 1];
        int first = p, second = q + 1, temp = 0;
        while (first <= q && second <= r) {
            if (arr[first - 1] < arr[second - 1]) {
                tempArr[temp] = arr[first - 1];
                first++;
            } else {
                tempArr[temp] = arr[second - 1];
                second++;
            }
            temp++;
        }
        while (first <= q) {
            tempArr[temp] = arr[first - 1];
            first++;
            temp++;
        }
        while (second <= r) {
            tempArr[temp] = arr[second - 1];
            second++;
            temp++;
        }
        for (int i = p; i <= r; i++) arr[i - 1] = tempArr[i - p];
    }
}
