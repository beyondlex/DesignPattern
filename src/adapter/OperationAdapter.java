package adapter;

import java.util.Arrays;

interface ScoreOperation {
    public int[] sort(int[] array);
    public int search(int[] array, int key);
}

class QuickSort {

    public int[] quickSort(int[] array) {
        // etc ...
        return array;
    }
}

class BinarySearch {

    public int binarySearch(int[] array, int key) {
        // etc ...
        return key;
    }
}

public class OperationAdapter implements ScoreOperation{
    private QuickSort sortObj;
    private BinarySearch searchObj;

    public OperationAdapter() {
        sortObj = new QuickSort();
        searchObj = new BinarySearch();
    }

    @Override
    public int[] sort(int[] array) {
        return sortObj.quickSort(array);
    }

    @Override
    public int search(int[] array, int key) {
        return searchObj.binarySearch(array, key);
    }
}

class Client {
    public static void main(String[] args) {
        int[] scores = {2,9,37,3, 11};
        int[] result;
        ScoreOperation scoreOperation = new OperationAdapter();
        result = scoreOperation.sort(scores);
        Arrays.stream(result).forEach(System.out::println);

        System.out.println(scoreOperation.search(result, 2));
    }
}
