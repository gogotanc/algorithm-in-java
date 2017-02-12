package org.tanc.algorithm.sort;

import org.junit.Test;
import org.tanc.algorithm.sort.impl.InsertionSort;
import org.tanc.algorithm.sort.impl.SelectionSort;

import static org.junit.Assert.*;

/**
 * 排序算法测试
 * Created by tanc on 2017/2/12.
 */
public class BaseSortAlgorithmTest {

    @Test
    public void insertionSort() throws Exception {
        Integer[] array = {234, 352, 674, 396, 597, 103, 496, 307, 372, 623, 354, 528, 158};
        BaseSortAlgorithm<Integer> sortAlgorithm = new InsertionSort<>();
        printArray(sortAlgorithm.sort(array));
    }

    @Test
    public void selectionSort() throws Exception {
        Integer[] array = {234, 352, 674, 396, 597, 103, 496, 307, 372, 623, 354, 528, 158};
        BaseSortAlgorithm<Integer> sortAlgorithm = new SelectionSort<>();
        printArray(sortAlgorithm.sort(array));
    }

    private void printArray(Object[] array) {
        for (Object o : array) {
            System.out.print(o + ",");
        }
    }
}