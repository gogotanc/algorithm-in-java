package org.tanc.algorithm.sort;

import org.junit.Test;
import org.tanc.algorithm.sort.impl.InsertionSort;
import org.tanc.algorithm.sort.impl.SelectionSort;
import org.tanc.algorithm.sort.impl.ShellSort;

import static org.junit.Assert.*;

/**
 * 排序算法测试
 * Created by tanc on 2017/2/12.
 */
public class BaseSortAlgorithmTest {

    @Test
    public void insertionSort() throws Exception {
        Integer[] array = {9, 3, 4, 6, 5, 8, 7, 2, 1, 0};
        BaseSortAlgorithm<Integer> sortAlgorithm = new InsertionSort<>();
        printArray(sortAlgorithm.sort(array));
    }

    @Test
    public void selectionSort() throws Exception {
        Integer[] array = {9, 3, 4, 6, 5, 8, 7, 2, 1, 0};
        BaseSortAlgorithm<Integer> sortAlgorithm = new SelectionSort<>();
        printArray(sortAlgorithm.sort(array));
    }

    @Test
    public void shellSort() throws Exception {
        Integer[] array = {9, 3, 4, 6, 5, 8, 7, 2, 1, 0};
        BaseSortAlgorithm<Integer> sortAlgorithm = new ShellSort<>();
        printArray(sortAlgorithm.sort(array));
    }

    private void printArray(Object[] array) {
        for (Object o : array) {
            System.out.print(o + ",");
        }
        System.out.println();
    }
}