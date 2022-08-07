import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArraySorterTest {
    @Test
    void bubbleSortingTest(){
        ArraySorter as = new ArraySorter();
        int[] expectedResult = new int[] {1,2,3,4,5,6};
        int[] unsorted = new int[]{3,4,1,5,6,2};
        int[] a = as.boobleSorter(unsorted);
        assertArrayEquals(expectedResult, a);
    }

    @Test
    void mergeSortTest(){
        ArraySorter ob = new ArraySorter();
        int[] expectedResult = new int[] {3,4,5,6,7,8,10};
        int[] unsorted = new int[]{10,6,8,5,7,4,3};
        ob.sort(unsorted, 0, unsorted.length - 1);
        assertArrayEquals(expectedResult, unsorted);
    }

    @Test
    void  bucketSortTest(){
        ArraySorter as = new ArraySorter();
        int[] expectedResult = {3,4,5,6,7,8,10};
        int[] unsorted = {10,6,8,5,7,4,3};
        int[] sorted = new int[unsorted.length];
        for (int i = 0; i < as.nrOfBin(unsorted).size(); i++) {
            sorted[i] = (int)as.nrOfBin(unsorted).get(i);
        }

        assertArrayEquals(expectedResult, sorted);
    }

}